#include <Password.h>
#include <Keypad.h>
#include <LiquidCrystal.h>

Password keypadPassword = Password( "0241" );
LiquidCrystal LcdDriver(11, 9, 5, 6, 7, 8);

const byte ROWS = 4;
const byte COLS = 4;

char keys[ROWS][COLS] = {
  {'1','2','3','!'},
  {'4','5','6','@'},
  {'7','8','9','#'},
  {'S','0','E','$'}
};

byte rowPins[ROWS] = { 14, 15, 16, 17 };
byte colPins[COLS] = { 18, 19, 20, 21 };


// Create the Keypad
Keypad keypad = Keypad( makeKeymap(keys), rowPins, colPins, ROWS, COLS );

void setup() {
  Serial.begin(9600);

  LcdDriver.begin(16, 2);
  LcdDriver.clear();
  LcdDriver.setCursor(0, 0);
  
  keypad.addEventListener(keypadEvent);

}

void loop() {
  keypad.getKey();   //Saves input to memory

}
  
void keypadEvent(KeypadEvent eKey){
  switch (keypad.getState()){
    case PRESSED:
      Serial.print("Enter:");

      LcdDriver.clear();
      LcdDriver.print(eKey);
        
      switch (eKey) {
        case '*':
          checkKeypadPassword();
          break;
        
        default:
          keypadPassword.append(eKey);
    
      }
  }
}

void checkKeypadPassword() {
  
  if (keypadPassword.evaluate()) {
    Serial.println("Access Denied");
    LcdDriver.clear();
    LcdDriver.print("Access Granted");
    
  } else {
    Serial.println("Access Denied");
    
    LcdDriver.clear();
    LcdDriver.print("Access Denied");

  }
}