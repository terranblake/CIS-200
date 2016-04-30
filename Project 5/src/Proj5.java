

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

/*******************************************************************
 * Proj5.java
 * <Terran Blake / C Friday / 7:30>
 *
 *This program, an automated scan-tron grading application, will take
 * any number of questions in an answer key and use that to grade
 * the test scores that have been input into the text file. After
 * the application has completed grading the scores, it will output
 * the results for each student, and the entire class, to a separate
 * text file.
 *******************************************************************/

//Class declaration
public class Proj5 {

    /** main
     * Outline of the method calls and
     * declarations of variables that
     * are needed in more than one place
     */
    public static void main(String[] args) throws IOException {

        DecimalFormat formatNumber = new DecimalFormat("0.0");

        Scanner read = new Scanner(System.in);
        int studentScore = 0;

        String inputFileName = getFileName();
        int numberOfQuestions = GetNumberOfQuestions(read);
        int numberOfPointsPerQuestion = getPointsPerQuestion(read);

        String answerKeyArray[] = getAnswerKey(inputFileName, read, numberOfQuestions);
        String studentAnswersArray[][] = GetQuizzesFromFile(read, answerKeyArray, inputFileName, numberOfQuestions);

        convertAnswerKeyToNumeric(answerKeyArray, numberOfQuestions);

        for(int x = 0; x < studentAnswersArray.length; x++) {
            studentScore = gradeIndividualQuiz(studentAnswersArray, read, inputFileName, answerKeyArray, numberOfQuestions, numberOfPointsPerQuestion, x);

            studentAnswersArray[x][2] = String.valueOf(studentScore);
            getStudentLetterGrade(studentAnswersArray, numberOfQuestions, x);

        }
        getClassAverage(studentAnswersArray, numberOfQuestions);
        displayQuizScores(formatNumber, studentAnswersArray, numberOfQuestions, numberOfPointsPerQuestion);
        outputToResultsFile(formatNumber, studentAnswersArray, numberOfQuestions, numberOfPointsPerQuestion);

    }

    /** getFileName
     * Gets the file name from the user
     * and verifies that a file exists
     * with that name
     *
     * @return The name of the file
     */
    public static String getFileName() {
        boolean isValid = false;
        Scanner read = new Scanner(System.in);
        String inputFileName = "";

        while(isValid == false) {
            while(isValid == false) {

                try {
                    read = new Scanner(System.in);
                    System.out.print("Enter name of quiz file (i.e. Quizscores.txt): ");
                    inputFileName = read.nextLine();
                    Scanner readFileName = new Scanner(new File(inputFileName));

                } catch (FileNotFoundException e) {
                    isValid = false;
                    System.out.println("Unable to open file");
                    break;

                }
                isValid = true;

            }
        }
        return inputFileName;

    }

    /** getNumber of questions
     * Gets the number of questions from
     * the user.
     *
     * @read Passes in the scanner
     * @return an integer with the number
     * of questions in the exam
     */
    public static int GetNumberOfQuestions(Scanner read) {
        System.out.print("Please enter the number of questions on the exam: ");
        String input = read.nextLine();
        int numberOfQuestions = Integer.parseInt(input);

        return numberOfQuestions;

    }

    /** getAnswerKey
     * Gets the answer key that will be
     * used to grade all of the tests that
     * are in the input file
     *
     * @inputFileName  The name of the input file
     * @read Passes in the scanner
     * @numberOfQuestions Passes in the number
     * of questions for the exam
     * @return An array with the contents of the
     * answer key
     */
    public static String [] getAnswerKey(String inputFileName, Scanner read, int numberOfQuestions) {
        String answerKeyArray[] = new String[numberOfQuestions];
        String input = "";
        int h = 1;

        System.out.println("\nPlease enter the answers for the following questions");
        System.out.println("where 'T' = true, 'F' = false, or A, B, C, D, E for multiple choice");

        for (; h < answerKeyArray.length + 1; h++) {
            System.out.print(h + ") ");
            input = read.nextLine();

            if (input.equalsIgnoreCase("t") || input.equalsIgnoreCase("f") || input.equalsIgnoreCase("a") || input.equalsIgnoreCase("b") || input.equalsIgnoreCase("c") || input.equalsIgnoreCase("d") || input.equalsIgnoreCase("e")) {
                answerKeyArray[h - 1] = input;

            } else {
                input = "";

                while (!(input.equalsIgnoreCase("t") || input.equalsIgnoreCase("f") || input.equalsIgnoreCase("a") || input.equalsIgnoreCase("b") || input.equalsIgnoreCase("c") || input.equalsIgnoreCase("d") || input.equalsIgnoreCase("e"))) {
                    System.out.println("Error!");
                    System.out.print(h + ") ");
                    input = read.nextLine();

                }
            }
        }
        return answerKeyArray;

    }

    /** getPointsPerQuestion
     * Gets the value of how much each
     * question is worth
     *
     * @read Passes in the scanner
     * @return An integer with the value
     * of how much each question is worth
     */
    public static int getPointsPerQuestion(Scanner read) {
        System.out.print("Please enter the number of points per questions: ");
        String input = read.nextLine();
        int numberOfPointsPerQuestion = Integer.parseInt(input);

        return numberOfPointsPerQuestion;

    }

    /** getQuizzesFromFile
     * Gets all the id numbers and answers
     * that the students have input, and
     * puts them in an array
     *
     * @read Passes in the scanner
     * @answerKeyArray[] Passes in the array that
     * contains the answer key
     * @inputFileName Passes in the name of the
     * file
     * @numberOfQuestions Passes in the number of
     * questions on the exam
     * @return An array that contains the student's
     * information and answers for the test
     */
    public static String [][] GetQuizzesFromFile(Scanner read, String answerKeyArray[], String inputFileName, int numberOfQuestions) {

        int x = 0, y = 0;
        String answerString = null;
        String studentAnswersArray[][] = new String[getNumberOfStudents(inputFileName)][answerKeyArray.length];

        try {
            read = new Scanner((new File(inputFileName)));
            read.useDelimiter(",");

            while ((read.hasNext()) && (x < getNumberOfStudents(inputFileName))) {

                studentAnswersArray[x][y] = read.next();
                answerString = read.nextLine().substring(1);

                y++;

                studentAnswersArray[x][y] = answerString;

                x++;
                y = 0;

            }

        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file"); // <-----------

        }
        return studentAnswersArray;

    }

    /** getNumberOfStudents
     * Gets the number of students that are in
     * the file
     *
     * @inputFileName Passes in the name of the
     * file
     * @return An integer with the number of students
     * that took the exam
     */
    public static int getNumberOfStudents(String inputFileName) {
        int countStudents = 0;

        try {
            Scanner readTests = new Scanner(new File(inputFileName));

            for (int x = 1; readTests.hasNext(); x++) {
                readTests.nextLine();
                countStudents++;

            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file");

        }
        return countStudents;

    }

    /** gradeIndividualQuiz
     * Grades a single student's exam
     *
     * @studentAnswersArray[][] Passes in an array that
     * contains the students' ids and their corresponding
     * answers
     * @read Passes in the scanner
     * @inputFileName Passes in the name of the
     * file
     * @answerKeyArray Passes in the array with all the
     * answers to the exam
     * @numberOfQuestions Passes in the number of
     * questions on the exam
     * @numberOFPointsPerQuestion Passes in the number of
     * points per question on the exam
     * @return An integer with the student's grade for
     * the exam
     */
    public static int gradeIndividualQuiz(String studentAnswersArray[][], Scanner read, String inputFileName, String answerKeyArray[], int numberOfQuestions, int numberOfPointsPerQuestion, int x) {
        int y = 1, studentScore = 0;
        String studentAnswers = null;

        for (int questionNumber = 0; questionNumber < numberOfQuestions; questionNumber++) {
            studentAnswers = studentAnswersArray[x][y];

            if (studentAnswers.substring(questionNumber, questionNumber + 1).equals(answerKeyArray[questionNumber])) {
                studentScore += numberOfPointsPerQuestion;

            }
        }
        return studentScore;

    }

    /** getClassAverage
     * Gets the class's average
     *
     * @studentAnswersArray[][] Passes in an array that
     * contains the students' ids and their corresponding
     * answers
     * @numberOfQuestions Passes in the number of questions
     * on the exam
     * @return A double value with the class average
     */
    public static double getClassAverage(String studentAnswersArray[][], int numberOfQuestions) {
        double classAverage = 0.0;

        for(int x = 0; x < studentAnswersArray.length; x++) {
            classAverage += (Integer.parseInt(studentAnswersArray[x][2]) * 10.0 / numberOfQuestions);

        }
        return classAverage;

    }

    /** getClassAverageLetterGrade
     * Gets the class's average letter grade
     *
     * @studentAnswersArray[][] Passes in an array that
     * contains the students' ids and their corresponding
     * answers
     * @numberOfQuestions Passes in the number of questions
     * on the exam
     * @return A double value with the class average
     */
    public static String getClassAverageLetterGrade(String studentAnswersArray[][], int numberOfQuestions) {
        double classGradePercentage = 0.0;
        String classAverageGradeLetter = "";

        for(int x = 0; x < studentAnswersArray.length; x++) {
            classGradePercentage += (Integer.parseInt(studentAnswersArray[x][2]) * 50.0 / numberOfQuestions);

        }
        classGradePercentage /= studentAnswersArray.length;

        if (classGradePercentage >= 90 && classGradePercentage <= 100) {
            classAverageGradeLetter = "A";

        } else if (classGradePercentage >= 80 && classGradePercentage <= 89.9) {
            classAverageGradeLetter = "B";

        } else if (classGradePercentage >= 70 && classGradePercentage <= 79.9) {
            classAverageGradeLetter = "C";

        } else if (classGradePercentage >= 60 && classGradePercentage <= 69.9) {
            classAverageGradeLetter = "D";

        } else {
            classAverageGradeLetter = "F";

        }
        return classAverageGradeLetter;

    }

    /** getStudentLetterGrade
     * Gets the individual student's letter grade for the
     * exam
     *
     * @studentAnswersArray[][] Passes in an array that
     * contains the students' ids and their corresponding
     * answers
     * @numberOfQuestions Passes in the number of questions
     * on the exam
     * @x Passes in the incrementing variable for the current
     * student being graded
     * on the exam
     * @return sets the 3rd column in the student array equal
     * to a string value that represents the student's letter
     * grade for the exam
     */
    public static void getStudentLetterGrade(String studentAnswersArray[][], int numberOfQuestions, int x) {
        double studentGradePercentage = (Integer.parseInt(studentAnswersArray[x][2]) * 50.0 / numberOfQuestions);

        if (studentGradePercentage >= 90 && studentGradePercentage <= 100) {
            studentAnswersArray[x][3] = "A";

        } else if (studentGradePercentage >= 80 && studentGradePercentage <= 89.9) {
            studentAnswersArray[x][3] = "B";

        } else if (studentGradePercentage >= 70 && studentGradePercentage <= 79.9) {
            studentAnswersArray[x][3] = "C";

        } else if (studentGradePercentage >= 60 && studentGradePercentage <= 69.9) {
            studentAnswersArray[x][3] = "D";

        } else {
            studentAnswersArray[x][3] = "F";

        }
    }

    /** convertAnswerKeyToNumeric
     * Converts the answer key to a numeric array, in order
     * to be easily compared to the students' answers
     *
     * @answerKeyArray[] Passes in an array that
     * contains the answers to the exam
     * @numberOfQuestions Passes in the number of questions
     * on the exam
     * @return an array with the converted values of the
     * answer key
     */
    public static String [] convertAnswerKeyToNumeric(String answerKeyArray[], int numberOfQuestions) {
        String convertedAnswerKey = null;

        for(int x = 0; x < numberOfQuestions; x++) {

            convertedAnswerKey = answerKeyArray[x];

            switch (convertedAnswerKey.toLowerCase()) {
                case ("t"):
                    convertedAnswerKey = "1";
                    break;
                case ("f"):
                    convertedAnswerKey = "2";
                    break;
                case ("a"):
                    convertedAnswerKey = "1";
                    break;
                case ("b"):
                    convertedAnswerKey = "2";
                    break;
                case ("c"):
                    convertedAnswerKey = "3";
                    break;
                case ("d"):
                    convertedAnswerKey = "4";
                    break;
                default:
                    convertedAnswerKey = "5";
                    break;

            }
            answerKeyArray[x] = convertedAnswerKey;

        }
        return answerKeyArray;

    }

    /** displayQuizScores
     * Displays to the console the statistics of each
     * student, as well as the average, high, and low
     * scores of the class
     *
     * @formatNumber Passes in a format for making the
     * display of the scores much more readable
     * @studentAnswersArray[][] Passes in an array with
     * the students' ids and their corresponding answers
     * @numberOfQuestions Passes in the number of questions
     * on the exam
     * @numberOFPointsPerQuestion Passes in the number of
     * points per question on the exam
     * @return an array with the converted values of the
     * answer key
     */
    public static void displayQuizScores(DecimalFormat formatNumber, String studentAnswersArray[][], int numberOfQuestions, int numberOFPointsPerQuestion) {
        double testPercentage = 100.0;

        System.out.println("Student ID      # Correct       % Correct       Score   Grade");

        for (int x = 0; x < studentAnswersArray.length; x++) {
            System.out.println(studentAnswersArray[x][0] + "\t" + (Integer.parseInt(studentAnswersArray[x][2])/numberOFPointsPerQuestion) + "\t\t" + formatNumber.format(Integer.parseInt(studentAnswersArray[x][2])*testPercentage/numberOfQuestions/2) + "%\t\t" + studentAnswersArray[x][2] + "\t" + studentAnswersArray[x][3]);

        }
        System.out.println("\nAverage: " + formatNumber.format(getClassAverage(studentAnswersArray, numberOfQuestions)) + "% (" + getClassAverageLetterGrade(studentAnswersArray, numberOfQuestions) + ")");
        System.out.println("High Score: " + getHighScore(studentAnswersArray));
        System.out.println("Low Score: " + getLowScore(studentAnswersArray));

    }

    /** getLowScore
     * Gets the lowest score in the class
     *
     * @studentAnswersArray[][] Passes in an array with
     * the students' ids and their corresponding answers
     * @return a value with the lowest score in the
     * class
     */
    public static int getLowScore(String studentAnswersArray[][]) {
        int lowScore = 1000;

        for(int x = 0; x < studentAnswersArray.length; x++) {
            if(lowScore > Integer.parseInt(studentAnswersArray[x][2])) {
                lowScore = Integer.parseInt(studentAnswersArray[x][2]);

            }
        }
        return lowScore;

    }

    /** getHighScore
     * Gets the highest score in the class
     *
     * @studentAnswersArray[][] Passes in an array with
     * the students' ids and their corresponding answers
     * @return a value with the highest score in the
     * class
     */
    public static int getHighScore(String studentAnswersArray[][]) {
        int highScore = 0;

        for(int x = 0; x < studentAnswersArray.length; x++) {
            if(highScore < Integer.parseInt(studentAnswersArray[x][2])) {
                highScore = Integer.parseInt(studentAnswersArray[x][2]);

            }
        }
        return highScore;

    }

    /** outputToResultsFile
     * Outputs all information from the class into a
     * file that is delimited by a ","
     *
     * @formatNumber A format to keep the numbers in
     * readable format
     * @studentAnswersArray[][] Passes in an array with
     * the students' ids and their corresponding answers
     * @numberOfQuestions Passes in the number of questions
     * on the exam
     * @return a value with the highest score in the
     * class
     */
    public static void outputToResultsFile(DecimalFormat formatNumber, String studentAnswersArray[][], int numberOfQuestions, int pointsPerQuestion) throws IOException {
        double testPercentage = 100.0;

        PrintWriter printWriter = new PrintWriter(new File("Results.txt"));

        System.out.print("\nResults.txt File created...");

        for (int x = 0; x < studentAnswersArray.length; x++) {
            printWriter.println(studentAnswersArray[x][0] + "," + (Integer.parseInt(studentAnswersArray[x][2])/pointsPerQuestion) + "," + formatNumber.format(Integer.parseInt(studentAnswersArray[x][2])*testPercentage/numberOfQuestions/2) + "," + studentAnswersArray[x][2] + "," + studentAnswersArray[x][3]);

        }
        printWriter.close();

    }
}