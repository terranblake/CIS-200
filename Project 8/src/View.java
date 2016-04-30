/**
 * Class that does all the input and output of the program. Provides
 * formatting for the entire program, and readability for the user.
 *
 * @author Terran Blake
 * @version Project 8
 */
import java.util.*;

public class View {
    private Scanner read;
    private int i = 1;

    /**
     * Default constructor for View
     * object
     */
    public View() {
        read = new Scanner(System.in);

    }

    /**
     * getHighestPossibleScores Gets the information for
     * the highest possible scores array
     *
     * @return highestPossibleScoresArray Array that holds the highest scores for each part of the class
     */
    public double [] getHighestPossibleScores() {
        double highestPossibleScoresArray [] = new double[5];

        System.out.print("Please enter the total number of points possible for Labs: ");
        highestPossibleScoresArray[0] = Double.parseDouble(read.nextLine());

        System.out.print("Please enter the total number of points possible for Projects: ");
        highestPossibleScoresArray[1] = Double.parseDouble(read.nextLine());

        System.out.print("Please enter the total number of points possible for Exams: ");
        highestPossibleScoresArray[2] = Double.parseDouble(read.nextLine());

        System.out.print("Please enter the total number of points possible for Codelab: ");
        highestPossibleScoresArray[3] = Double.parseDouble(read.nextLine());

        System.out.print("Please enter the total number of points possible for Final Exam: ");
        highestPossibleScoresArray[4] = Double.parseDouble(read.nextLine());
        System.out.println();

        return highestPossibleScoresArray;

    }

    /**
     * getStudentInformation Gets the information for
     * the student information array
     *
     * @return studentInformationArray Array that holds the information for the student
     */
    public String [] getStudentInformation() {
        String studentInformationArray [] = new String[3];

        System.out.print("Enter the student's first name: ");
        studentInformationArray[0] = read.nextLine();

        System.out.print("Enter the student's last name: ");
        studentInformationArray[1] = read.nextLine();

        System.out.print("Enter the student's WID: ");
        studentInformationArray[2] = read.nextLine();

        return studentInformationArray;

    }

    /**
     * getStudentScores Gets the information for
     * the student scores array
     *
     * @return studentScoresArray Array that holds the individual scores for the student
     */
    public double [] getStudentScores() {
        double studentScoresArray [] = new double[5];

        System.out.print("\nEnter the student's Total Labs score: ");
        studentScoresArray[0] = Double.parseDouble(read.nextLine());

        System.out.print("Enter the student's Total Projects score: ");
        studentScoresArray[1] = Double.parseDouble(read.nextLine());

        System.out.print("Enter the student's Total Exams score: ");
        studentScoresArray[2] = Double.parseDouble(read.nextLine());

        System.out.print("Enter the student's CodeLab score: ");
        studentScoresArray[3] = Double.parseDouble(read.nextLine());

        System.out.print("Enter the student's Final Exam score: ");
        studentScoresArray[4] = Double.parseDouble(read.nextLine());

        return studentScoresArray;

    }

    /**
     * getAnotherStudent Asks the user if they want to input another
     * student
     *
     * @return Boolean for true if the user wants to input another student, or false if the user is done with student input
     */
    public boolean getAnotherStudent() {
        System.out.println("\nWould you like to enter another student?");
        System.out.println("\t" + i + " Student(s) entered so far.");
        System.out.println("\t(20 Students can be entered.)");
        System.out.print("Press Enter for another student or any other key to quit. ");
        String input = read.nextLine();
        System.out.println();

        if((input != null && !input.isEmpty()) || (i == 20)) {
            return false;

        } else {
            i++;
            return true;

        }
    }
}