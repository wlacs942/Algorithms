// This program prompts the user for 5 test scores as integers greater than or equal to 0 and less than or equal to 100.
// It ensures that the user entries are valid and stores the 5 test scores in an array.
// It uses the bubble sort to sort the scores in ascending order and calculates the letter grade for each test.
// It displays the letter grade of each scsore as well as the overall average of the 5 test scores.
//
// Grade scale is:  Score         Letter Grade
// 					      >= 90 			        A
//                >= 80 and < 90 			B
// 				        >= 70 and < 80 			C
// 				        >= 60 and < 70 			D
// 				        >= 0  and < 60 			F

#include <iostream>			// Must be included in any program that uses the cout object
#include <iomanip>			// Library for manipulating output
#include <string>			  // Required for the string class
#include <stdlib.h>			// atoi and atof 

using namespace std;

// Function Prototypes 
double calcAverage(int testScore[], int& sum, double& average);
void validateUserInput(string& userEntry);
void determineGrade(int testScore[], char grade[]);
void bubbleSort (int testScore[]);
void displayTestScores(int testScore[], char grade[], int sum, double average);

int main()
{
	// declare Array to hold test scores 
	int testScore[5];
	
	// declare Array to hold grades 
	char grade[5];
	
	// Initializations and declarations 
	string userEntry; 
	int i = 0; 
	double average;
	int sum;
	
	while(i < 5)
	{
		// Lets the user input each test score one by one 
		cout << "Enter score " << (i + 1) << ": " << endl;
		getline(cin, userEntry);
		validateUserInput(userEntry); // Calls validateUserInput function 
		int userEntryInt = atoi(userEntry.c_str()); // Converts userEntry string to userEntryInt integer 
		testScore[i] = userEntryInt; // Scores each score in an array called testScore 
		i++;
	}
	
	bubbleSort(testScore);	// Calls bubbleSort function 
	calcAverage(testScore, sum, average); // Calls calcAverage function 
	determineGrade(testScore, grade); // Calls determineGrade function
	displayTestScores(testScore, grade, sum, average); // Calls displayTestScores function  

	system("pause");
	return 0;
} // End of main 

// ********************************************************
// The calcAverage function computes the average of the   *
// five test scores and takes an array of type int as a   *
// parameter and returns the average.                     *
// ********************************************************
double calcAverage(int testScore[], int& sum, double& average)
{	
	for(int i = 0; i < 5; i++)
	{
		// Adds all the test scores 
		sum = sum + testScore[i];
	}
	average = sum / 5.0;
	
//	cout << "The average is ";
//	cout << setprecision(2) << fixed;
//	cout << average << endl;
	
	return average;
} // end of calcAverage

// ********************************************************
// The validateUserInput function ensures user entries    *
// are integers greater than or equal to zero and less    *
// than or equal to 100.                                  *
// ********************************************************
void validateUserInput(string& userEntry)
{
	int counter = 0; 
	int userEntryLength = userEntry.length();
	
	while(counter < userEntryLength || userEntryLength == 0)
	{
		int userEntryInt = atoi(userEntry.c_str());
		
		if(!isdigit(userEntry[counter]))
		{
			cout << "That is not an integer X such that : 0 <= X <= 100, try again." << endl;
			getline(cin, userEntry);
			userEntryLength = userEntry.length();
			counter = 0;
		}
		
		else if(userEntryInt < 0 || userEntryInt > 100)
		{
			cout << "That is not an integer X such that : 0 <= X <= 100, try again." << endl;
			getline(cin, userEntry);
			userEntryLength = userEntry.length();
			counter = 0;
		}
		
		else
		{
			counter++;
		}
	}
} // end of validateUserInput function 

// ********************************************************
// The determineGrade function computes the average       *
// of the five test scores and takes an int array with    *
// the test scores and a char array to store the          *
// corresponding letter grades.                           *
// ********************************************************
void determineGrade (int testScore[], char grade[])
{
	for(int i = 0; i < 5; i++)
	{
		// When the test score is 90 or above, the letter grade is an A 
		if(testScore[i] >= 90)
		{
			grade[i] = 'A';
		}
		// When the test score is 80 or above but less than 90, the letter grade is a B 
		if(testScore[i] >= 80 && testScore[i] < 90)
		{
			grade[i] = 'B';
		}
		// when the test score is 70 or above but less than 80, the letter grade is a C
		if(testScore[i] >= 70 && testScore[i] < 80)
		{
			grade[i] = 'C';
		}
		// When the test score is 60 or above, but less than 70, the letter grade is a D 
		if(testScore[i] >= 60 && testScore[i] < 70)
		{
			grade[i] = 'D';
		}
		// When the test score is less 60, the letter grade is a D 
		if(testScore[i] < 60)
		{
			grade[i] = 'F';
		}
	}
} // End of determineGraade function 

// ********************************************************
// The bubbleSort function sorts the values (test scores) *
// stored in the array in ascending order.                *
// ********************************************************
void bubbleSort (int testScore[])
{
	int temp = 0;
	
	for(int i = 0; i < 5; i++)
	{
		for(int j = 1; j < 5; j++)
		{
			// Swaps numbers to display them in ascending order 
			if(testScore[j-1] > testScore[j])
			{
				temp = testScore[j-1];
				testScore[j-1] = testScore[j];
				testScore[j] = temp;
			}
		}
	}
} // End of bubbleSort

// ********************************************************
// The displayTestScores function displays each test      *
// score and its corresponding letter as well as the      *
// overall average.                                       *
// ********************************************************

void displayTestScores(int testScore[], char grade[], int sum, double average)
{
	// Displays scores and letter grades 
	cout << "Score LetterGrade" << endl;
	
	for(int i = 0; i < 5; i++)
	{
		// setw(4) gives 4 spaces between test scores and grades 
		cout << setw(4) << testScore[i] << setw(4) << grade[i] << endl;
	}
	cout << "The average is ";
	cout << setprecision(2) << fixed; // displays two digits after decimal point 
	cout << average << endl;
} // End of displayTestScores function 
