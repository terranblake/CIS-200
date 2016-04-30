/*******************************************************************
* Proj2.java
* <Terran Blake / C Friday / 7:30>
*
* This program, a Season Ticketing Software, will have the 
* functionality to display an opening menu, let a user select different
* season pass plans, purchase parking passes, and display all the 
* information back to the user at the end. 
* 		%^&^* ALL EXTRA CREDIT INCLUDED %^&*$
*******************************************************************/

//Import Declarations
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Class declaration
public class Proj2 {

	//Main function declaration
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Scanner Declaration
		Scanner read = new Scanner(System.in);
		
		//Format declaration
		DecimalFormat df = new DecimalFormat("#,000.00");
		
		
		
		//Non-constant variable declarations
		int planSelection = 0;
		int seatSelection = 0;
		int seatNumber = 0;
		double untaxedTotal = 0;
		double taxFee = 0;
		double parkingFee = 0;
		double finalTotal = 0;
		String YorN;
		String plan = null;
		String seat = null;
		String parking = null;
		boolean decider = false;
		boolean restart = false;
		
		//Error dialog box declaration
		JFrame frame = new JFrame();
		
		//Constant variable declarations
		double TAXRATE = 0.0575;
		
		do {
		
		System.out.println("***Welcome to the World Champion Royals 2016 Season Ticketing Application! ***");
		System.out.println("\t\t(Application developed by Terran Blake)");
		System.out.println("\t\t\t----CROWNED K.C.! ----- \n");
		System.out.println("Please select one of the Season Ticket Plans listed below:");
		System.out.println("\t1)          Full Season Plan (tickets to all 81 regular season games!)");
		System.out.println("\t2)  Half Season Plan (tickets to 40 regular season games)");

		do {
			
			System.out.print("\tSelection: ");
			planSelection = read.nextInt();
			
			if(planSelection == 1) {
	            planSelection = 81;
	            plan = "FULL Season 81-game plan";
	            decider = true;
	            
	            break;
			} else if (planSelection == 2) {
	        	planSelection = 40;
	        	plan = "HALF 40-game plan";
	        	decider = true;
	            
	            break;
			} else if (planSelection == 3) {
	        	planSelection = 20;
	        	plan = "QUARTER Season 20-game plan";
	        	decider = true;
	            
	            break;
			} else {
				JOptionPane.showMessageDialog(frame, "Invalid Entry. 1-3 Only.", "Inane error", JOptionPane.ERROR_MESSAGE);
				
			}
		} while(decider = true);
		
		decider = false;
        	
		
		System.out.println();
		System.out.println("Please select one of the Seating Options listed below:");
		System.out.println("\t     Seating            Per Game");
		System.out.println("   1)  BATS Crown Club Seats        $235");
		System.out.println("   2)  Diamond Club Box              $95");
		System.out.println("   3)  Dugout Box                    $51");	
		System.out.println("   4)  Dugout Plaza                  $40");
		System.out.println("   5)  Field Box                     $36");
		System.out.println("   6)  Field Plaza                   $28");		
		System.out.println("   7)  Outfield Box                  $26");
		System.out.println("   8)  Hy-Vee Box                    $16\n");
		System.out.println("");
		
		do {
		
		System.out.print("\tSelection: ");
		seatSelection = read.nextInt();
		
		if(seatSelection == 1) {
        	seatSelection = 235;
        	seat = "BATS Crown Club Seats";
        	
            break;
		} else if(seatSelection == 2) {
        	seatSelection = 95;
        	seat = "Diamond Club Box";
            
            break;
		} else if(seatSelection == 3) {
        	seatSelection = 51;
        	seat = "Dugout Box";
            
            break;
		} else if(seatSelection == 4) {
        	seatSelection = 40;
        	seat = "Dugout Plaza";
        	
            break;
		} else if(seatSelection == 5) {
        	seatSelection = 36;
        	seat = "Field Box";
            
            break;
		} else if(seatSelection == 6) {
        	seatSelection = 28;
        	seat = "Field Plaza";
            
            break;
		} else if(seatSelection == 7) {
        	seatSelection = 26;
        	seat = "Outfield Box";
            
            break;
		} else if(seatSelection == 8) {
        	seatSelection = 16;
        	seat = "Hy-Vee Box";
            
            break;
		} else {
			JOptionPane.showMessageDialog(frame, "Invalid Entry. 1-8 Only.", "Inane error", JOptionPane.ERROR_MESSAGE);
        	
		}	
		
		} while(decider = true);
        	
        System.out.print("\n\tHow many seats would you like to purchase? ");
        seatNumber = Integer.valueOf(read.nextInt());
    
        untaxedTotal = (planSelection * seatSelection * seatNumber);
        
        decider = false;
        
    	System.out.println("\n\tA single parking pass is available for purchase at a discounted rate of $8 pergame (regularly $10).");
    	System.out.println("\t(You will be charge for all games of a given package.)");
        
        do {
        
        	System.out.print("\n\tWould you like to include parking? (Y or N): ");
        	YorN = read.next();
        
        	if(YorN.equalsIgnoreCase("y")) {
        		parkingFee = (planSelection * 8);
        		parking = "with Parking";
        		decider = true;
        		break;
        	
        	} else if (YorN.equalsIgnoreCase("n")) {
        		parkingFee = (planSelection * 10);
        		parking = "without Parking";
        		decider = true;
        		break;
        	
        	} else {
				JOptionPane.showMessageDialog(frame, "Invalid Entry. Y or N Only.", "Inane error", JOptionPane.ERROR_MESSAGE);
				
			}
        
        } while(decider = true);
        
        taxFee = (untaxedTotal * TAXRATE);
        finalTotal = (untaxedTotal + taxFee + parkingFee);
        
        System.out.println("\n\tYou purchased the " + plan + " / " + seatNumber + " " + seat + " " + parking);
        System.out.printf("\t   Ticket Total: $" + df.format(untaxedTotal));
        System.out.printf("\n\t   Tax: $" + df.format(taxFee));
        System.out.printf("\n\t   Parking: $" + df.format(parkingFee));
        System.out.printf("\n\t   Grand Total: $" + df.format(finalTotal));
        
        
        do {
        
        	System.out.print("\n\n\tConfirm Order (Y or N)? ");
        	YorN = read.next();
        
        	if(YorN.equalsIgnoreCase("y")) {
        		System.out.print("\n\tOrder was confirmed. $" + df.format(finalTotal) + " will be charged to the account on file.");
        		decider = true;
        		break;
        		
        	} else if (YorN.equalsIgnoreCase("n")) {
        		System.out.print("\n\tPurchase cancelled. Re-run the application to reselect tickets.");
        		decider = true;
        		break;
        		
        	} else {
				JOptionPane.showMessageDialog(frame, "Invalid Entry. Y or N Only.", "Inane error", JOptionPane.ERROR_MESSAGE);
				
			}
        
        } while(decider = true);
        
        decider = false;
        
        System.out.print("\n\n\tWould you like to process another order? ");
        
        do {
        
        YorN = read.next();
        
        if(YorN.equalsIgnoreCase("y")) {
        	restart = true;
        	System.out.println("\n\n");
        	decider = true;
    		break;
        	
        } else if (YorN.equalsIgnoreCase("n")) {
        	System.err.print("\n\tApplication ended. Re-run the application to reselect tickets.");
        	decider = true;
    		break;
        	
        } else {
			JOptionPane.showMessageDialog(frame, "Invalid Entry. Y or N Only.", "Inane error", JOptionPane.ERROR_MESSAGE);
			System.out.print("\b");
			
		}
        
        } while(decider = true);
        
	  } while(restart = true);
	}
}
