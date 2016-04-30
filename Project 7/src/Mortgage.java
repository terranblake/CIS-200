/**
 * <Mortgage.java>
 * <Terran Blake / B Friday/7:30am>
 *
 * <This class calculates all values, as well as
 * displaying all the menus, and data validation>
 */
import java.text.DecimalFormat;
import java.util.*;

public class Mortgage {
    private Scanner read = new Scanner(System.in);

    private double interestRate;
    private double termOfLoan;
    private double amountOfLoan;
    private double monthlyPayment;
    private double totalPayment;

    private String customerLastName;
    private String mortgageString;

    static DecimalFormat myFormatter = new DecimalFormat("###,###.###");

    /** Mortgage
     * Default Constructor
     */
    public Mortgage() {
    }

    /** Mortgage
     * Creates an object with the following
     * parameters inside of it
     *
     * @param interestRate Holds the interest rate for the mortgage
     * @param termOfLoan Holds the term of the loan for the mortgage
     * @param amountOfLoan Holds the amount of the loan for the mortgage
     * @param customerLastName Holds the last name of the person getting the loan
     * @param monthlyPayment Holds the monthly payment for the loan
     * @param totalPayment Holds the total payment of the loan at the end of the mortgage
     * @param mortgageString Holds the String variable with the information for thr Mortgage object
     */
    public Mortgage(double interestRate, double termOfLoan, double amountOfLoan, String customerLastName, double monthlyPayment, double totalPayment, String mortgageString) {
        this.interestRate = interestRate;
        this.termOfLoan = termOfLoan;
        this.amountOfLoan = amountOfLoan;
        this.customerLastName = customerLastName;
        this.monthlyPayment = monthlyPayment;
        this.totalPayment = totalPayment;
        this.mortgageString = mortgageString;

    }

    /** populateUniqueLoanObject
     * Populates the unique loan object
     *
     * @return newMortgage Holds the unique loan object
     */
    public Mortgage populateUniqueLoanObject() {
        storeLastName();
        storeLoanAmount();
        storeInterestRate();
        storeTerm();
        calcMonthlyPayment();
        calcTotalPayment();
        toString();

        System.out.print("\nUNIQUE LOAN...:");
        Mortgage newMortgage = new Mortgage(this.interestRate, this.termOfLoan, this.amountOfLoan, this.customerLastName, this.monthlyPayment, this.totalPayment, this.mortgageString);
        return newMortgage;

    }

    /** populateUniqueLoanObject
     * Populates the promotional loan object
     *
     * @return newMortgage Holds the promotional loan object
     */
    public Mortgage populatePromotionalLoanObject() {
        storeLastName();
        this.amountOfLoan = 250000;
        this.interestRate = (3.2 * 0.01) / 12;
        this.termOfLoan = 20 * 12;
        calcMonthlyPayment();
        calcTotalPayment();
        toString();

        System.out.print("\nPROMOTIONAL LOAN...:");
        Mortgage newMortgage = new Mortgage(this.interestRate, this.termOfLoan, this.amountOfLoan, this.customerLastName, this.monthlyPayment, this.totalPayment, this.mortgageString);

        return newMortgage;

    }

    /** storeTerm
     * Stores the term of the loan
     * in the private variable
     */
    public void storeTerm() {
        System.out.print("Enter number of years for the loan: ");
        this.termOfLoan = Integer.parseInt(read.nextLine());

        while(termOfLoan < 10 || termOfLoan > 40) {
            System.out.println("\nValid Loan Terms are 10-40");
            System.out.print("Please re-enter valid number of years: ");
            this.termOfLoan = Integer.parseInt(read.nextLine());

        }
        this.termOfLoan = this.termOfLoan * 12;

    }

    /** storeInterestRate
     * Stores the interest rate of the
     * loan in the private variable
     */
    public void storeInterestRate() {
        System.out.print("Enter yearly interest rate (Ex: 8.25): ");
        this.interestRate = Double.parseDouble(read.nextLine());

        while(interestRate < 2 || interestRate > 7) {
            System.out.println("\nValid Interest Rates are 2% - 7%");
            System.out.print("Please re-enter valid yearly interest rate (Ex: 8.25): ");
            this.interestRate = Double.parseDouble(read.nextLine());

        }
        this.interestRate = (this.interestRate * 0.01) / 12;

    }

    /** storeLoanAmount
     * Stores the amount of the
     * loan in the private variable
     */
    public void storeLoanAmount() {
        System.out.print("Enter the amount of the loan (Ex:75000): ");
        this.amountOfLoan = Double.parseDouble(read.nextLine());

        while(amountOfLoan < 75000 || amountOfLoan > 1000000) {
            System.out.println("\nValid Loan Amounts are $75000-$1000000");
            System.out.print("Please re-enter loan amount without $ or commas (Ex:75000): ");
            this.amountOfLoan = Double.parseDouble(read.nextLine());

        }
    }

    /** calcMonthlyPayment
     * Calculates the monthly payment
     * and stores it in the private variable
     */
    public void calcMonthlyPayment() {
        this.monthlyPayment = (amountOfLoan * interestRate * Math.pow(1 + interestRate, termOfLoan)/(Math.pow(1 + interestRate, termOfLoan) - 1));

    }

    /** storeLastName
     * Stores the last name of the
     * person taking out the loan
     * in the private variable
     */
    public void storeLastName() {
        System.out.print("\nEnter customer's Last Name Only: ");
        this.customerLastName = read.nextLine();

        while(customerLastName.matches(".*\\d.*")) {
            System.out.println("\nNames do not contain numbers ;)");
            System.out.print("Please re-enter valid name (Ex: Bob): ");
            this.customerLastName = read.nextLine();

        }
        int randomNumber = (int)((Math.random() * 10000) + 100);
        this.customerLastName = (this.customerLastName).substring(0, 4) + Integer.toString(randomNumber);

    }

    /** calcTotalPayment
     * Calculates the total payment
     * and stores it in the private variable
     */
    private void calcTotalPayment() {
        this.totalPayment = (this.monthlyPayment * this.termOfLoan);

    }

    /** calcMonthlyPayment
     * Calculates the monthly payment
     * and stores it in the private variable
     */
    public String getMortgageString() {
        return this.mortgageString;

    }

    /** toString
     * Set the private variable equal to
     * the information retrieved from
     * the customer and other private
     * variables
     *
     * @return mortgageString Holds the infromation retrieved from the private variables
     */
    public String toString() {
        this.mortgageString = ("\nAccount Number: " + this.customerLastName + "\nThe monthly payment is $" +
                myFormatter.format(this.monthlyPayment) + "\nThe total payment is $" + myFormatter.format(this.totalPayment));

        return this.mortgageString;

    }

    /** printInitialMenu
     * Prints the menu that is displayed
     * for each new object and at the
     * beginning of the program
     */
    public int printInitialMenu() {
        System.out.println("\n\nPlease choose from the following choices below: ");
        System.out.println("\t1) Promotional Loan (preset loan amount, rate, term)");
        System.out.println("\t2) Unique Loan (enter in loan values)");
        System.out.println("\t3) Quit (Exit the program)\n");
        System.out.print("\tPlease enter your selection (1-3): ");
        int input = Integer.parseInt(read.nextLine());

        switch(input) {
            case 1:
                return 1;

            case 2:
                return 2;

            case 3:
                return 3;

            default:
                while(input < 1 || input > 3) {
                    System.out.print("Invalid Choice. Please select 1, 2, or 3: ");
                    input = Integer.parseInt(read.nextLine());

                }
                if(input == 1)
                    return 1;

                else if(input == 2)
                    return 2;

                else
                    return 3;

        }
    }

}