/**
 * Class that outlines the application, makes all the
 * method calls, and lets the user input a max of 20
 * students
 *
 * @author Terran Blake
 * @version Project 8
 */
import java.util.Scanner;

public class StudentApp {

    /**
     * main Outline for the whole application
     */
    public static void main(String [] args) {

        Scanner read = new Scanner(System.in);

        double highestPossibleScoresArray [];
        String studentInformationArray [];
        double studentScoresArray [];
        String studentArray [] = new String[20];

        View view = new View();
        Student student = new Student();

        int i = 0;
        highestPossibleScoresArray = view.getHighestPossibleScores();

        while(i < 20) {

            studentInformationArray = view.getStudentInformation();
            studentScoresArray = view.getStudentScores();

            student.getStudentInformation(studentInformationArray);
            student.getOverallWeightedPercent(highestPossibleScoresArray, studentScoresArray);

            studentArray[i] = student.toString();

            if (view.getAnotherStudent() == true) {

            } else {
                break;

            }
            i++;

        }
        int x = 0;

            while(x < 20 || studentArray[x] == null) {
                if(studentArray[x] == null) {
                    System.out.print("All students displayed...");
                    break;

                } else {
                    System.out.println(studentArray[x]);
                    x++;

                    System.out.println("\tPress enter to display next student...");
                    read.nextLine();

            }
        }
    }
}