/**
 * Class that holds the variables, structure, and
 * calculations for the other dependent classes
 *
 * @author Terran Blake
 * @version Project 8
 */
import java.text.DecimalFormat;

public class Student {
    private String studentFirstName;
    private String studentLastName;
    private String wildcatID;
    private double overallLabScore;
    private double overallProjectScore;
    private double overallExamScore;
    private double overallCodelabScore;
    private double overallFinalExamScore;
    private double overallPercentScore;
    private char studentLetterGrade;

    private final double WEIGHT_PERCENTS_ARRAY [] = {.15, .15, .30, .10, .30};

    /**
     * Default construtor for Student
     * object
     */
    public Student() {
        this.studentFirstName = "no name entered";
        this.studentLastName = "no name entered";
        this.wildcatID = "no WID";
        this.overallLabScore = 0;
        this.overallProjectScore = 0;
        this.overallExamScore = 0;
        this.overallCodelabScore = 0;
        this.overallFinalExamScore = 0;
        this.overallPercentScore = 0;

    }

    /**
     * 8-Paraneter Constructor definition
     *
     * @param studentFirstName Holds the student's first name
     * @param studentLastName Holds the student's last name
     * @param wildcatID Holds the student's Wildcat Id
     * @param totalAdjustedLabScore Holds the total calculated lab score for the student
     * @param totalAdjustedProjectScore Holds the total calculated project score for the student
     * @param totalAdjustedExamScore Holds the total calculated exam score for the student
     * @param totalAdjustedCodelabScore Holds the total calculated Codelab score for the student
     * @param totalAdjustedFinalExamScore Holds the total calculated final exam score for the student
     */
    public Student(String studentFirstName, String studentLastName, String wildcatID, double totalAdjustedLabScore, double totalAdjustedProjectScore, double totalAdjustedExamScore, double totalAdjustedCodelabScore, double totalAdjustedFinalExamScore) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.wildcatID = wildcatID;
        this.overallLabScore = totalAdjustedLabScore;
        this.overallProjectScore = totalAdjustedProjectScore;
        this.overallExamScore = totalAdjustedExamScore;
        this.overallCodelabScore = totalAdjustedCodelabScore;
        this.overallFinalExamScore = totalAdjustedFinalExamScore;

    }

    /**
     * getStudentInformation Holds the student information arrays
     *
     * @param studentInformationArray Holds the array with all the student information in it
     */
    public void getStudentInformation(String [] studentInformationArray) {
        this.studentFirstName = studentInformationArray[0];
        this.studentLastName = studentInformationArray[1];
        this.wildcatID = studentInformationArray[2];

    }

    /**
     * getOverallWeightedPercent Calls methods to calculate the overall weighted percent for a student
     *
     * @param highestPossibleScoresArray Holds the array with all the highest possible scores in it
     * @param studentScoresArray Holds the array with all the student's scores in it
     */
    public double getOverallWeightedPercent(double [] highestPossibleScoresArray, double [] studentScoresArray) {
        this.overallPercentScore = calcOverallWeightedPercent(highestPossibleScoresArray, studentScoresArray);
        getLetterGrade();

        return this.overallPercentScore;

    }

    /**
     * getOverallWeightedPercent Calculate the overall weighted percent for a student
     *
     * @param highestPossibleScoresArray Holds the array with all the highest possible scores in it
     * @param studentScoresArray Holds the array with all the student's scores in it
     *
     * @return The overall weighted percent for a student
     */
    private double calcOverallWeightedPercent(double [] highestPossibleScoresArray, double [] studentScoresArray) {
        double totalPointsPossible = highestPossibleScoresArray[0] + highestPossibleScoresArray[1]
                + highestPossibleScoresArray[2] + highestPossibleScoresArray[2]
                + highestPossibleScoresArray[4];

        double studentFinalScore = (studentScoresArray[0] / highestPossibleScoresArray[0]) * (WEIGHT_PERCENTS_ARRAY[0] * totalPointsPossible)
                + (studentScoresArray[1] / highestPossibleScoresArray[1]) * (WEIGHT_PERCENTS_ARRAY[1] * totalPointsPossible)
                + (studentScoresArray[2] / highestPossibleScoresArray[2]) * (WEIGHT_PERCENTS_ARRAY[2] * totalPointsPossible)
                + (studentScoresArray[3] / highestPossibleScoresArray[3]) * (WEIGHT_PERCENTS_ARRAY[3] * totalPointsPossible)
                + (studentScoresArray[4] / highestPossibleScoresArray[4]) * (WEIGHT_PERCENTS_ARRAY[4] * totalPointsPossible);

        return((studentFinalScore / totalPointsPossible) * 100);

    }

    /**
     * getLetterGrade Chooses the correct letter based upon the overall weighted percent for a student
     */
    private void getLetterGrade() {
        char studentLetterGrade;

        if(overallPercentScore >= 89.5)
            studentLetterGrade = 'A';
        else if(overallPercentScore >= 79.5)
            studentLetterGrade = 'B';
        else if(overallPercentScore >= 68.5)
            studentLetterGrade = 'C';
        else if(overallPercentScore > 58.5)
            studentLetterGrade = 'D';
        else
            studentLetterGrade = 'F';

        this.studentLetterGrade = studentLetterGrade;

    }

    /**
     * toString Formats a string to print out with all the information of a student
     *
     * @return A string that is formatted to include all the information for a certain student
     */
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");

        return ("Student Name: " + studentLastName +
                ", " + studentFirstName +
                "\nWID: " + wildcatID +
                "\nOverall Pct: " + decimalFormat.format(overallPercentScore) +
                "%\n" + "Final Grade: " + studentLetterGrade);

    }
}