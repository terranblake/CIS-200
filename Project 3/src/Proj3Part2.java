/*******************************************************************
* Proj3Part1.java
* <Terran Blake / C Friday / 7:30>
*
* This program, a dice game called Pig, is played between a human 
* player and a systematically-coded computer AI algorithm.
* The program will continue unless one of the players gets to 20
* points. If one person rolls a one, they lose all their points for
* that turn. Otherwise, the players total is continuously added up
* for each turn, until someone wins. This is to test the algorithm
* written for the computer's AI.
*******************************************************************/

//Import statements
import java.util.Scanner;
import java.util.Random;

//Class declaration
public class Proj3Part2 {
	
   //Main declaration
   public static void main(String[] args) {
	   
	  //Variable declarations
      int player1Scores = 0;
      int player1Total = 0;
      int computerScores = 0;
      int computerTotal = 0;
      int dice = 0, x = 0;
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
              System.out.print("Your turn total is " + player1Scores + ". Enter (r)oll or (s)top: ");
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
    	  	System.out.println("Current score: You have " + player1Total + ", Computer has " + computerTotal);
            player1Scores = 0;
            
            turnOver = false;
            
            if (player1Total >= WINNING_SCORE) {
            	System.out.print("You win");
            	gameOver = true;
            	break;
            }

            System.out.println();
            
            //Computer turn
            do {
                
            	if (computerScores + computerTotal < WINNING_SCORE && x < 4 && computerScores <= 18) {
            		System.out.println("Computer turn total is " + computerScores + ". Computer rolls: ");
            		//input = read.nextLine();
            		repeat = 'r';
                
            	} else {
            		System.out.println("Computer turn total is " + computerScores + ". Computer stops: ");
                    //input = read.nextLine();
                    repeat = 's';
            		
            	}
                
                if (repeat == 'r' || repeat == 'R') {
              	  
                    dice = rand.nextInt(6) + 1;
                
                    if (dice == 1) {
                  	  computerScores = 0;
                  	  System.out.println("Computer rolled: 1");
                  	  turnOver = true;
                  	  x = 0;

                    } else {
                  	  computerScores += dice;
                  	  System.out.println("Computer rolled: " + dice + "\n");

                    }

                } else if (repeat == 's' || repeat == 'S') {
              	  turnOver = true;
              	  x = 0;
              	  
                }

                x++;
                
      	  } while(turnOver == false);

            computerTotal += computerScores;
    	  	System.out.print("Turn over.\n");
    	  	System.out.println("Current score: You have " + player1Total + ", Computer has " + computerTotal);
            computerScores = 0;
            
            turnOver = false;

            if (computerTotal >= WINNING_SCORE) {
            	System.out.print("Computer wins");
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