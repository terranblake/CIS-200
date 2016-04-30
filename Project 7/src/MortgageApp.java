/**
 * <MortgageApp.java>
 * <Terran Blake / B Friday/7:30am>
 *
 * <This class is an outline of the program,
 * makes all the calls to the Mortgage class,
 * and validates menu choices>
 */
public class MortgageApp extends Mortgage {

    /** main
     * Outline of the entire program
     */
    public static void main(String [] args) {

        String[] mortgageArray = new String[10];
        Mortgage newMortgage = new Mortgage();

        int i = 0;
        int selection = 0;

        while(i < 10) {
            selection = newMortgage.printInitialMenu();

            if (selection == 1) {
                newMortgage.populatePromotionalLoanObject();
                mortgageArray[i] = newMortgage.getMortgageString();
                System.out.print(newMortgage);

            } else if (selection == 2) {
                newMortgage.populateUniqueLoanObject();
                mortgageArray[i] = newMortgage.getMortgageString();
                System.out.print(newMortgage);

            } else {
                break;

            }
            i++;

        }
        System.out.print("\nPROGRAM COMPLETE\nContents of Array...\n");

        for (int x = 0; x < 10; x++) {

            if(mortgageArray[x] == null) {
            } else {

                System.out.println(mortgageArray[x]);

            }

        }
    }
}