/*******************************************************************
* Proj3Part1.java
* <Terran Blake / C Friday / 7:30>
*
* This program, a dice game called Pig, is played between two people.
* The program will continue unless one of the players gets to 20
* points. If one person rolls a one, they lose all their points for
* that turn. Otherwise, the players total is continuously added up
* for each turn, until someone wins. This is to test the functionality
* and parameters of the game in a real-world application.
*******************************************************************/

//Import statements
import java.util.Scanner;
import java.util.Random;

//Class declaration
public class Proj3Part1 {
	
   //Main declaration
   public static void main(String[] args) {
	   
	  //Variable declarations
      int player1Scores = 0;
      int player1Total = 0;
      int player2Scores = 0;
      int player2Total = 0;
      int dice = 0;
      boolean gameOver = false;
      boolean turnOver = false;
      char repeat;
      String input;
      
      //Constant Variable Declarations
      final int WINNING_SCORE = 20;

      //Scanner and Random declarations
      Scanner read  = new Scanner(System.in);
      Random rand = new Random();
               
      while (gameOver == false) {  
    	 
    	  //Player 1 turn
    	  do {
              System.out.print("Player 1 turn total is " + player1Scores + ". Enter (r)oll or (s)top: ");
              input = read.nextLine();
              repeat = input.charAt(0);
              
              if (repeat == 'r' || repeat == 'R') {
            	  
                  dice = rand.nextInt(6) + 1;
              
                  if (dice == 1) {
                	  player1Scores = 0;
                	  System.out.println("You rolled: 1");
                	  turnOver = true;

                  } else {
                	  player1Scores += dice;
                	  System.out.println("You rolled: " + dice + "\n");
                      
                  }
                  
              } else if (repeat == 's' || repeat == 'S') {
            	  turnOver = true;
            	  
              }
            
    	  } while(turnOver == false);
         
    	  	player1Total += player1Scores;
    	  	System.out.print("Turn over.\n");
    	  	System.out.println("Current score: Player 1 has " + player1Total + ", Player 2 has " + player2Total);
            player1Scores = 0;
            
            turnOver = false;
            
            if (player1Total >= WINNING_SCORE) {
            	System.out.print("Player 1 wins");
            	gameOver = true;
            	break;
            }

            System.out.println();
            
            //Player 2 turn
            do {
                
                System.out.print("Player 2 turn total is " + player2Scores + ". Enter (r)oll or (s)top: ");
                input = read.nextLine();
                repeat = input.charAt(0);
                
                if (repeat == 'r' || repeat == 'R') {
              	  
                    dice = rand.nextInt(6) + 1;
                
                    if (dice == 1) {
                  	  player2Scores = 0;
                  	  System.out.println("You rolled: 1");
                  	  turnOver = true;

                    } else {
                  	  player2Scores += dice;
                  	  System.out.println("You rolled: " + dice + "\n");

                    }

                } else if (repeat == 's' || repeat == 'S') {
              	  turnOver = true;
              	  
                }

      	  } while(turnOver == false);

            player2Total += player2Scores;
    	  	System.out.print("Turn over.\n");
    	  	System.out.println("Current score: Player 1 has " + player1Total + ", Player 2 has " + player2Total);
            player2Scores = 0;
            
            turnOver = false;

            if (player2Total >= WINNING_SCORE) {
            	System.out.print("Player 2 wins");
            	gameOver = true;
            	break;
            } 
            
            System.out.println();

      }

      if(read!=null) {
    	  read.close();

  	  }
      
   }
}