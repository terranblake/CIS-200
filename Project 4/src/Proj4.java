import java.awt.*;
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
		int numberOfQuestions = 0, numberOfPointsPerQuestion = 0, h = 0, y = 0;
		String inputFileName = "";

		String [][] studentAnswersArray = new String [50][51];

		inputFileName = SetDestinationFolder(inputFileName);

		Scanner read = new Scanner(System.in);
		Scanner readTests = new Scanner((new File(inputFileName)));

		//String idNumber, testAnswer;

		numberOfQuestions = GetNumberOfQuestions(read);
		numberOfPointsPerQuestion = GetPointsPerQuestion(read, numberOfPointsPerQuestion);
		String[] answerKeyArray = new String[numberOfQuestions];
		GetAnswerKey(numberOfQuestions, read, answerKeyArray, h);

		GetQuizzesFromFile(readTests, answerKeyArray, studentAnswersArray);

	}

	// Method to ask for user input
	public static String GetFileName(String inputFileName) {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter name of quiz file (i.e. Quizscores.txt): ");
		inputFileName = read.nextLine();

		return inputFileName;

	}

	// Method to set destination folder
	public static String SetDestinationFolder(String inputFileName) {
		try {
			inputFileName = GetFileName(inputFileName);
			Scanner read = new Scanner(new File(inputFileName));

		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file");
			inputFileName = SetDestinationFolder(inputFileName);

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
	public static String [] GetAnswerKey(int numberOfQuestions, Scanner read, String [] answerKeyArray, int h) {
		String input = "";
		h = 1;

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

	//Method to get the number of points each question is worth
	public static int GetPointsPerQuestion(Scanner read, int numberOfPointsPerQuestion) {
		System.out.print("Please enter the number of points per questions: ");
		String input = read.nextLine();
		numberOfPointsPerQuestion = Integer.parseInt(input);
		return numberOfPointsPerQuestion;

	}

	//Method to get the students quizzes from external file
	public static String [][] GetQuizzesFromFile(Scanner readTests, String answerKeyArray[], String studentAnswersArray[][]) {
		readTests.useDelimiter(",");
		System.out.println("The delimiter used is " + readTests.delimiter());
		int y = 0;

		while (readTests.hasNext()) {
			for (int x = 0; x < GetNumberOfStudents(readTests); x++) {
				studentAnswersArray[x][y] = studentAnswers;

				for(y = 0; y < answerKeyArray.length;) {
					char c = studentAnswers.charAt(y);
					String input = Character.toString(c);

					studentAnswersArray[x][y] = input;

				}
			}
		}
		return studentAnswersArray;

	}

	//Method to grade all the students' quizzes based upon the answer key
	public static int GetNumberOfStudents(Scanner readTests) {
		int countStudents = 0;

		for(int x = 1; readTests.hasNext(); x++) {
			readTests.nextLine();
			countStudents++;

		}
		return countStudents;

	}

	//Method to grade all the students' quizzes based upon the answer key
	public static void GradeQuizzes() {

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