/**
 * Class that outlines the application, makes all the
 * method calls, and lets the user input unlimited
 * employees
 *
 * @author Terran Blake
 * @version Project 9
 */
import java.util.ArrayList;

public class PayrollApp {
    /**
     * main Outline for the entire application
     */
    public static void main(String[] args) {
        ArrayList<Payroll> payrollArrayList = new ArrayList<Payroll>();

        boolean loop = true, employeeFound = false;
        int x = 0;

        while(loop == true) {
            Payroll newPayroll = new Payroll();
            newPayroll.getEmployeeInformation();
            payrollArrayList.add(newPayroll);

            loop = newPayroll.getAnotherEmployee();

            x++;

        }

        System.out.println("\tPrint Employee Array...\n");

        System.out.println(payrollArrayList);

        for(int i = 0; i < x; i++) {
            String selectedObject = payrollArrayList.get(i).toString();
            System.out.println(selectedObject);

        }

        Payroll newPayroll = new Payroll();
        int selectedEmployee = newPayroll.getSelectedEmployee();

        while(employeeFound == false) {
            for (int i = 0; i < x; i++) {
                String[] employeeInformationArray = payrollArrayList.get(i).getEmployeeId();

                if (selectedEmployee == Integer.parseInt(employeeInformationArray[1])) {
                    payrollArrayList.remove(i);

                    System.out.println("\nEmployee Id: " + selectedEmployee + "\nHas been deleted.\n");
                    employeeFound = true;
                    break;

                } else if(i == payrollArrayList.size()) {
                    System.out.println("Employee Id not found.\n");

                }

            }

        }
        Payroll lastPayroll = new Payroll();
        lastPayroll.getEmployeeInformation();
        payrollArrayList.add(lastPayroll);

        System.out.println("\n\tPrint Employee Array...");

        for(int i = 0; i < x; i++) {
            System.out.println();
            String selectedObject = payrollArrayList.get(i).toString();
            System.out.print(selectedObject);

        }
    }
}