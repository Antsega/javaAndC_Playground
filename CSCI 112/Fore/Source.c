/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */
/* Programmer: Anthony Segarra                                                                */
/* Project: Fore! || Track											                          */
/* Purpose: Display the results of your golf game in comparison to par                        */
/* Location: Remote                                                                           */
/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */


#define _CRT_SECURE_NO_WARNINGS // Ignores the compilers suggestions when calling scaf_s


// Librarys
#include <stdio.h>	 // input and output operations
#include <stdlib.h>	 // library for memory managment
#include <string.h>	 //	manipulation for strings and arrays
#include <conio.h>	 // specifically for the clear function
#include <stdbool.h> // boolean library

// Constants

#define TOTAL_PAR				// Par score or standard stroke count

// Global Variables for Functions
int strokeArr[9];
int scoreToPar[9] = { 4, 5, 4, 5, 4, 3, 4, 3, 4 }; // Par per hole in order
char strokeCount[25];							 // Placeholder for golfer's stroke count
int holeCount = 1;								 // Keeps track of which hole the golfer is on / recording for
int sum = 0;									 // Initial sum
int par = 36;									 // Score to par
char* term;										 // Par score
int parCounter = 0;								 // Par counter
int birdiesCounter = 0;							 // Birdies counter
int bogeyCounter = 0;							 // Bogey counter
// Function prototypes

void golferScoreCountPrompt(void);
int printSum(int sum);
bool inputToAsciiValue(char* x);
char golfScoreTitle(void);
int scoreCard(void);
int groupingScoreCalculator(void);

// Main start
int main(void)
{
	int holeNumber[9] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // Number of holes
	char* birdie = "birdie";						 // Under birdie!//
	char* par = "par";								 // Par is even
	char* bogey = "bogey";							 // Bogey is over

	golferScoreCountPrompt();
	system("cls"); // Clears console of all inputs
	golfScoreTitle();
	scoreCard();
	return 0;
}

// End of Main

// Functions expanded
void golferScoreCountPrompt(void) // Asks golfer for scores below
{
	for (holeCount = 1; holeCount < 10; holeCount++)
	{																 // loop starting at hole 1 and ending at hole 9
		printf("Please enter score on hole number %d: ", holeCount); // requests score, starting at hole 1
		scanf("%s", &strokeCount);									 // saves input as string
		while (!inputToAsciiValue(strokeCount))						 // if not a number execute function
		{
			printf("Please enter a correct number for hole %d:", holeCount); // reprompts for a number until correct
			scanf("%s", &strokeCount);										 // saves number still as string value
		}
		int strokeCountNum = atoi(strokeCount); // saves string strokeCount to integer strokeCountNum

		sum += strokeCountNum;					   // incrementing sum by strokeCountNum
		strokeArr[holeCount - 1] = strokeCountNum; // Creates array for stroke values
	}
}

int printSum(int sum) // Print sum
{
	printf("\n\nPar is: %d - total score was: %d\n\n", par, sum); // compares par to sum
}

bool inputToAsciiValue(char* x) // Insures only numbers 1 to 10 are entered
{
	for (int i = 0; i < strlen(x); i++)
	{

		int xAscii = (int)x[i]; // converts input to Ascii value

		if (xAscii < 48 || xAscii > 57) // range of Ascii value to accept
		{
			return false; // if out of range
		}
	}
	return true; // otherwise
}

char golfScoreTitle(void) // Title for golf card
{
	char* groupOfTabs = "-  -  -  -  -";   // spacing
	char* title = "Golf Score Calculator"; // string
	printf("\n %s %s %s\n\n", groupOfTabs, title, groupOfTabs);
};

int scoreCard(void) // Returns scores and compares to Par
{
	for (int j = 0; j < 9; j++)
	{

		if (strokeArr[j] > scoreToPar[j])
		{
			term = "Bogey!"; // if golfer score > par
			bogeyCounter += 1;
		}
		else if (strokeArr[j] < scoreToPar[j])
		{
			term = "Birdie!"; // score < par
			birdiesCounter += 1;
		}
		else
		{
			term = "Par"; // score == par
			parCounter += 1;
		}
		printf("The score on hole # %d was: %d \t Par is: %d - %s \n", j + 1, strokeArr[j], scoreToPar[j], term);
	}
	printSum(sum);
	printf("Number of pars: %d\n", parCounter);
	printf("Number of birdies: %d\n", birdiesCounter);
	printf("Number of bogey: %d\n", bogeyCounter);
}
