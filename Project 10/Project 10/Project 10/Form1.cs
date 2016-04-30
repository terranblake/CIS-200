/**
*   This application, a C# Word Jumble game, uses
*   arrays and forms to organize a graphical
*   interface for the user to interact with.
*
*   This file specifically controls all the events,
*   logic, input, and output.
*
* @author Terran Blake
* @version Project 10
*/

using System;
using System.IO;
using System.Windows.Forms;

namespace Project_10
{
    public partial class Form1 : Form
    {
        private string[] wordsArray = new string[5];

        /**
        * Form1
        * Initializes the form that the 
        * user interfaces with

        */
        public Form1()
        {
            InitializeComponent();

        }

        /**
        * Form1_Load
        * Method that runs before the user
        * is able to interact with it. creates
        * all variables that are necessary at
        * the start of the application
        *
        * @param sender References this form when calling other methods
        * @param e The data the is retrieved or manipulated when calling other methods
        */
        private void Form1_Load(object sender, EventArgs e)
        {
            string[] jumbledArray = new string[5];
            Random rnd = new Random();


            for (int x = 0; x < 5; x++)
            {
                int i = rnd.Next(2, 5050);

                wordsArray[x] = pickWords(i);
                string jumbledWord = jumbleWords(wordsArray[x]);

                while (wordsArray[x] == jumbledWord)
                    wordsArray[x] = pickWords(i);

                jumbledArray[x] = jumbledWord;

            }
            randomWord1.Text = jumbledArray[0];
            randomWord2.Text = jumbledArray[1];
            randomWord3.Text = jumbledArray[2];
            randomWord4.Text = jumbledArray[3];
            randomWord5.Text = jumbledArray[4];

        }

        /**
        * pickWords
        * Establishes connection with the
        * external file, and randomly selects
        * the words to be scrambled.
        *
        * @param x Random number to be used to search the file for the random word
        * @return randomWord String that contains the random word to be scrambled
        */
        private string pickWords(int x)
        {
            string randomWord;

            try
            {   // Open the text file using a stream reader.
                using (StreamReader sr = new StreamReader("words.txt"))
                {
                    // Read the stream to a string, and write the string to the console.

                    for (int h = 0; h < x - 1; h++)
                    {
                        sr.ReadLine();

                    }
                    randomWord = sr.ReadLine();

                    return randomWord;

                }

            }
            catch (Exception e)
            {
                Console.WriteLine("The file could not be read:");
                Console.WriteLine(e.Message);
                return " ";

            }

        }

        /**
        * jumbleWords
        * Takes the word and scrambles it with
        * the given algorithm
        *
        * @param randomWord String that holds the selected word
        * @return String(chars) String that holds the jumbled word
        */
        private string jumbleWords(string randomWord)
        {
            char[] chars = new char[randomWord.Length];
            Random rand = new Random(10000);
            int index = 0;

            while (randomWord.Length > 0)
            { // Get a random number between 0 and the length of the word. 
                int next = rand.Next(0, randomWord.Length - 1); // Take the character from the random position 
                                                                //and add to our char array. 
                chars[index] = randomWord[next]; // Remove the character from the word. 
                randomWord = randomWord.Substring(0, next) + randomWord.Substring(next + 1);
                index++;
            }
            return new String(chars);

        }

        /**
        * checkButton_Click
        * Activated when the checkButton Button is
        * clicked. Contains the logic for deciding
        * if the user's answer is correct
        *
        * @param sender References this form when calling other methods
        * @param e The data the is retrieved or manipulated when calling other methods
        */
        private void checkButton_Click(object sender, EventArgs e)
        {
            int x = 0;

            if (textBox1.Text.ToLower().Trim() != wordsArray[x].ToLower().Trim())
                resultsLabel.Text += ("Word " + (x + 1) + " is incorrect.\n"); x++;

            if (textBox2.Text.ToLower().Trim() != wordsArray[x])
                resultsLabel.Text += ("Word " + (x + 1) + " is incorrect.\n"); x++;

            if (textBox3.Text.ToLower().Trim() != wordsArray[x])
                resultsLabel.Text += ("Word " + (x + 1) + " is incorrect.\n"); x++;

            if (textBox4.Text.ToLower().Trim() != wordsArray[x])
                resultsLabel.Text += ("Word " + (x + 1) + " is incorrect.\n"); x++;

            if (textBox5.Text.ToLower().Trim() != wordsArray[x])
                resultsLabel.Text += ("Word " + (x + 1) + " is incorrect.\nTry again!"); x++;

            if (resultsLabel.Text == "")
                resultsLabel.Text = "You solved all the words!";
            checkButton.Enabled = false;

        }
    }
}
