import java.io.*;
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

    //Main function declaration
    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(System.in);

        String inputFileName = GetFileName();
        int numberOfQuestions = GetNumberOfQuestions(read);
        int numberOfPointsPerQuestion = GetPointsPerQuestion(read);

        String answerKeyArray[] = GetAnswerKey(inputFileName, read, numberOfQuestions);
        GetQuizzesFromFile(read, answerKeyArray, inputFileName, numberOfQuestions);

    }

    // Method to ask for user input
    public static String GetFileName() {
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

    //Method to get the number of questions on the quiz
    public static int GetNumberOfQuestions(Scanner read) {
        System.out.print("Please enter the number of questions on the exam: ");
        String input = read.nextLine();
        int numberOfQuestions = Integer.parseInt(input);

        return numberOfQuestions;

    }

    //Method to get the answer key from the user
    public static String [] GetAnswerKey(String inputFileName, Scanner read, int numberOfQuestions) {
        String answerKeyArray[] = new String[numberOfQuestions + 1];
        String input = "";
        int h = 1;

        System.out.println("\nPlease enter the answers for the following questions");
        System.out.println("where 'T' = true, 'F' = false, or A, B, C, D, E for multiple choice");

        for (; h < answerKeyArray.length; h++) {
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

    //Method to get the number of points each question is worth
    public static int GetPointsPerQuestion(Scanner read) {
        System.out.print("Please enter the number of points per questions: ");
        String input = read.nextLine();
        int numberOfPointsPerQuestion = Integer.parseInt(input);

        return numberOfPointsPerQuestion;

    }

    //Method to get the students quizzes from external file
    public static String [][] GetQuizzesFromFile(Scanner read, String answerKeyArray[], String inputFileName, int numberOfQuestions) {

        int x = 0, y = 0;
        String answerString = null, input = null;
        String studentAnswersArray[][] = new String[GetNumberOfStudents(inputFileName)][answerKeyArray.length];

        System.out.println(GetNumberOfStudents(inputFileName) + " " + answerKeyArray.length); // <-----------

        try {

            read = new Scanner((new File(inputFileName)));
            read.useDelimiter(",");



            while ((read.hasNext()) && (x < GetNumberOfStudents(inputFileName) + 1)) {

                studentAnswersArray[x][y] = read.next();

                System.out.print(studentAnswersArray[x][y]); // <-----------

                if (x < 4) {
                    x++;

                } else if (x < 5) {
                    answerString = read.nextLine().substring(1);

                }

                while (y < numberOfQuestions + 1) {

                    if (y < 15) {

                        char c = answerString.charAt(y);
                        input = Character.toString(c);

                    }

                    if (y == 15) {

                        break;
                    } else {
                        y++;

                    }

                    studentAnswersArray[x][y] = input;

                    System.out.print(" " + studentAnswersArray[x][y]); // <-----------

                    }
                System.out.println();
                y = 0;

            }

            System.out.print("\nANSWERKEY "); // <-----------

            for(int h = 0; h < answerKeyArray.length - 1; h++)
                System.out.print(answerKeyArray[h] + " "); // <-----------

            System.out.println(); // <-----------
            System.out.println("\nMethod Called"); // <-----------

        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file"); // <-----------

        }
        return studentAnswersArray;

    }

    //Method to grade all the students' quizzes based upon the answer key
    public static int GetNumberOfStudents(String inputFileName) {
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

    //Method to grade all the students' quizzes based upon the answer key
    public static void GradeQuizzes(Scanner read, int scoresArray[], String inputFileName, String answerKeyArray[], int numberOfQuestions, int numberOfPointsPerQuestion) {
        int studentAnswer = 0, x = 0, y = 0;

        String studentAnswersArray[][] = GetQuizzesFromFile(read, answerKeyArray, inputFileName, numberOfQuestions);

        while (x < GetNumberOfStudents(inputFileName)) {
            y = 1;

            while(y < answerKeyArray.length) {

                System.out.println(answerKeyArray[y]); // <-----------
                System.out.println(studentAnswersArray[x][y]); // <-----------

                studentAnswer = Integer.parseInt(studentAnswersArray[x][y]);
                y++;

                if(ConvertAnswerKeyToNumeric(studentAnswer).equals(answerKeyArray[y])) {

                    System.out.print("CORRECT"); // <-----------

                    studentAnswersArray[x][(numberOfQuestions + 2)] += numberOfPointsPerQuestion;

                    System.out.print(scoresArray[answerKeyArray.length + 1]); // <-----------

                } else {

                    System.out.print(ConvertAnswerKeyToNumeric(studentAnswer) + " " + answerKeyArray[y]); // <-----------
                    System.out.print("INCORRECT"); // <-----------

                }
                y++;

            }
            x++;

        }
    }

    public static String ConvertAnswerKeyToNumeric(int studentAnswer) {
        int x = 0;
        String convertedAnswerKey = Integer.toString(studentAnswer);

        switch(convertedAnswerKey.toLowerCase()) {
            case ("t"): convertedAnswerKey = "1";
                break;
            case ("f"): convertedAnswerKey = "2";
                break;
            case ("a"): convertedAnswerKey = "1";
                break;
            case ("b"): convertedAnswerKey = "2";
                break;
            case ("c"): convertedAnswerKey = "3";
                break;
            case ("d"): convertedAnswerKey = "4";
                break;
            default: convertedAnswerKey = "5";
                break;

        }
        x++;
        return convertedAnswerKey;

    }

    //Method to display all the individual grades for each student
    public static void DisplayQuizScores() {

    }

    //Method to display the combined scores of the entire class
    public static void DisplayClassScores() {

    }

    //Method to create a file to store the results of the quiz
    public static void CreateQuizResultsFile() {

    }

    //Method to output the results of the quiz to the file
    public static void OutputToResultsFile() {

    }

}