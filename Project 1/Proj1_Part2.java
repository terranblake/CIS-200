/*******************************************************************
* Proj1_Part2.java
* <Terran Blake / C Friday / 7:30>
*
* This program will take the user's input, and tell them their monthly
* payment and the total amount to be paid, as well as the extra amount
* that they paid.
*******************************************************************/

	//Import Declarations
import java.util.Scanner;

	//Project 1 Part 2 Class
class Proj1_Part2 {

	//Main function
public static void main(String [] args) {
	
	//Scanner Declaration
	Scanner read = new Scanner(System.in);
	
	//NON-constant Declarations
	String computerBrand, computerModel;
	double computerCost;

	//Constant declarations
	double KANSAS_TAX_RATE = 0.0615;
	
	//Output and input for Computer Brand
	System.out.print("Which brand of computer do you wish to purchase?: ");
	computerBrand = read.nextLine();
	
	//Output and input for Computer Model
	System.out.print("Which model?: ");
	computerModel = read.nextLine();
	
	//Output and input for Computer Cost
	System.out.print("Enter the cost of the computer: ");
	computerCost = Double.valueOf(read.nextLine());
	
	//Output for user information
	System.out.print("\nBrand: " + computerBrand);
	System.out.print("\nModel: " + computerModel);
	System.out.printf("\nSales tax: $%.2f", (computerCost * KANSAS_TAX_RATE));
	System.out.printf("\nTotal Cost: $%.2f", ((computerCost * KANSAS_TAX_RATE) + computerCost));
	
 }
}