/*******************************************************************
* Proj1_Part1.java
* <Terran Blake / C Friday / 7:30>
*
* This program will take the user's input for the name and price of
* a product, and tell them their monthly payment and the total 
* amount to be paid, as well as the extra amount that they paid.
*******************************************************************/

	//Import Declarations
import java.util.Scanner;

	//Project 1 Part 1 Class
class Proj1_Part1 {

	//Main function
public static void main(String [] args) {
	
	//Scanner Declaration
	Scanner read = new Scanner(System.in);
	
	//NON-constant Declarations
	String itemPurchased;
	double purchasePrice, monthlyPayment, totalPayment;
	
	//Constant declarations
	double FINANCING_RATE = 0.03;
	int FINANCING_MONTHS = 12;
	
	//Output and input for Item Purchased
	System.out.print("Enter the item to be purchased: ");
	itemPurchased = read.nextLine();
	
	//Output and input for Purchase Price
	System.out.print("Enter the amount of the purchase: ");
	purchasePrice = Double.valueOf(read.nextLine());
	
	//Calculation for Monthly Payment
	monthlyPayment = (((purchasePrice * FINANCING_RATE) + purchasePrice) / FINANCING_MONTHS);
	
	//Output for Monthly Payment
	System.out.printf("Your monthly payment is: $%.2f", monthlyPayment);
	
	//Claculation for Total Payment
	totalPayment = (purchasePrice + (purchasePrice * FINANCING_RATE));
	
	//Output for Total Payment
	System.out.printf("\nYour total payment is: $%.2f", totalPayment);
	
	//Output for amount paid for Financing
	System.out.printf("\nAmount paid in financing is: $%.2f", (purchasePrice * FINANCING_RATE));
	
 }
 
}