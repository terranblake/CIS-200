/**
 * Class that contains all the logic and decision
 * making behind the application.
 *
 * @author Terran Blake
 * @version Project 9
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class Payroll extends PayrollApp {
    private String name;          // Employee name
    private int idNumber;         // 6-digit ID number
    private int numEmployees = 1;     // Number of employees entered
    private double payRate;       // Hourly pay rate
    private double hoursWorked;   // Number of hours worked
    private double grossPay;      // Total pay
    private String [] employeeInformationArray = new String[5];

    /**
     The constructor initializes an object with the
     employee's name, ID number, pay rate, and
     hours worked.

     @param name The employee's name.
     @param idNumber The employee's ID number.
     @param payRate The employee's pay rate.
     @param hoursWorked The employee's hours worked.
     @param grossPay The employee's gross pay.
     */
    public Payroll(String name, int idNumber, double payRate, double hoursWorked, double grossPay) {
        this.name = name;
        this.idNumber = idNumber;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.grossPay = grossPay;

    }

    /**
     The constructor is the default for the constructor
     that is built above.
     */
    public Payroll() {
    }

    /**
     This method returns the array containing all
     the specific information for each employee

     @return employeeInformationArray The array that contains all the information for the employee
     */
    public String [] getEmployeeId() {
        return this.employeeInformationArray;

    }

    /**
     This method gets all the specific information about
     each employee, from the user
     */
    public void getEmployeeInformation() {
        int x = 0;

        System.out.print("Please enter the employee's NAME(e.g. Hingle McCringleberry): ");
        employeeInformationArray[0] = validateUserInput(x); x++;

        System.out.print("Please enter the employee's ID NUMBER(e.g. 8818921): ");
        employeeInformationArray[1] = validateUserInput(x); x++;

        System.out.print("Please enter the employee's PAY RATE(e.g. 7.25): ");
        employeeInformationArray[2] = validateUserInput(x); x++;

        System.out.print("Please enter the employee's HOURS WORKED(e.g. 35.5: ");
        employeeInformationArray[3] = validateUserInput(x);

        employeeInformationArray[4] = Double.toString(Double.parseDouble(employeeInformationArray[2])
                * Double.parseDouble(employeeInformationArray[3]));

    }

    /**
     This method returns the validated input that is to be
     placed inside of thee array for all the employee
     information

     @param x Holds the number for which kind of input is being passed

     @return userInput The variable containing the validated user input
     */
    public String validateUserInput(int x) {
        Scanner read = new Scanner(System.in);
        String userInput;

        if(x == 0) {
            while (true) {

                try {
                    userInput = read.nextLine();

                    if (userInput.isEmpty()) {
                        System.out.print("\nInvalid Input.\nPlease enter the employee's NAME: ");

                    } else {
                        return userInput;

                    }

                } catch (IllegalArgumentException e) {
                    System.out.print("\nInvalid Input.\nPlease enter the employee's NAME: ");
                    System.out.println();

                }

            }

        } else if(x == 1) {
            while (true) {

                try {
                    userInput = read.next();
                    Integer.parseInt(userInput);

                    return userInput;

                } catch (NumberFormatException e) {
                    System.out.print("\nInvalid Input.\nPlease enter the employee's ID NUMBER: ");

                }

            }

        } else if(x == 2) {
            while (true) {

                try {
                    userInput = read.nextLine();
                    Double.parseDouble(userInput);

                    return userInput;

                } catch (NumberFormatException e) {
                    System.out.print("\nInvalid Input.\nPlease enter the employee's PAY RATE: ");

                }

            }

        } else {
            while (true) {

                try {
                    userInput = read.nextLine();
                    Double.parseDouble(userInput);

                    return userInput;

                } catch (NumberFormatException e) {
                    System.out.print("\nInvalid Input.\nPlease enter the employee's HOURS WORKED: ");

                }

            }
        }
    }

    /**
     This method returns a string that contains the pertinent
     information for the given employee

     @return "String" Contains the pertinent information for the given employee
     */
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        return ("\tEmployee Name: " + employeeInformationArray[0] +
                "\n\tId Number: " + employeeInformationArray[1] +
                "\n\tGross Pay: " + formatter.format(Double.parseDouble(employeeInformationArray[4])) +
                "\n");

    }

    /**
     This method returns a boolean value that determines
     whether or not the user would like to enter another
     employee

     @return "boolean" Containing whether or not the user would like to input another employee or not
     */
    public boolean getAnotherEmployee() {
        Scanner read = new Scanner(System.in);

        System.out.println("\nWould you like to enter another employee?");
        System.out.println("\t(Unlimited employees can be entered.)");
        System.out.print("Press Enter for another employee or any other key to quit. ");
        String input = read.nextLine();
        System.out.println();

        if((input != null && !input.isEmpty())) {
            return false;

        } else {
            return true;

        }

    }

    /**
     This method returns the integer value for the
     id of the employee that the user would like
     to delete

     @return "Integer" Value for the id number to be deleted
     */
    public int getSelectedEmployee() {
        Scanner read = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter a 6-digit ID NUMBER to be deleted: ");
            String userInput = read.nextLine();

            if (userInput.length() > 6 || userInput.length() < 0) {
                System.out.print("\nInvalid Input.\nPlease enter the employee's ID NUMBER: ");

            } else {
                return Integer.parseInt(userInput);

            }
        }
    }

} // end class
