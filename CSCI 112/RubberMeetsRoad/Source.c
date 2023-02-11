/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */
/* Programmer: Anthony Segarra                                                                */
/* Project: Where the Rubber Meets the Road ||                                                */
/* Purpose: Validation of tire code input  && tells where and what is wrong if invalid        */
/* Location: Remote                                                                           */
/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */

// Library
#include <stdio.h>  // gets() function
#include <string.h> // strtok() function
#include <stdlib.h> // atoi() function

// Constants
#define MAX_SIZE 15 // sets the max size for the input array

// Variables start
char tireCodeInput[MAX_SIZE];                                            // array to save input value
int tireWidth;                                                           // tireWidth function
int sideWall;                                                            // sideWall function
int loadIndex;                                                           // loadIndex function
int counter = 0;                                                         // counter for proofing if valid input or not
int rimDiameter;                                                         // rimDiameter function
char *firstLetter;                                                       // stores first char
char *secondLetter;                                                      // stores second char
char *lastLetter;                                                        // stores last char
char *inputLoop;                                                         // loops through input array
char delim[] = "/A BCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; // parameters to initiate a break for strtok

// Prototypes
void promptUserInput(void);
char evaluateFirstCharacter(void);
int tireWidthEvaluation(void);
int sidewallHeightEvaluation(void);
char evaluateSecondCharacter(void);
int rimDiameterEvaluation(void);
char evaluateLastCharacter(void);
int loadIndexEvaluation(void);
char finalTireCodeEvaluation(void);
int main(void)
{

    // Display Start
    promptUserInput(); // example P215/65R15 95H

    evaluateFirstCharacter();  // Pxxx/xxXxx xxX
    evaluateSecondCharacter(); // Xxx/xxRxx xxX
    evaluateLastCharacter();   // Xxx/xxXxx xxH
    // evaluated the original input before splitting the array apart
    tireWidthEvaluation();      // X215/xxXxx xxX
    sidewallHeightEvaluation(); // Xxx/55Xxx xxX
    rimDiameterEvaluation();    // Xxx/xxX15 xxX
    loadIndexEvaluation();      // Xxx/xxXxx 95X
    finalTireCodeEvaluation();
    // Display End
    return 0;
}

// functions expanded
void promptUserInput(void)
{
    printf("Please Input Your Tire's Code\nHere's An Example \"P214/65R15 95H\"\nUse The Same Format: "); // Prompt input
    gets(tireCodeInput);                                                                                  // Saves input
}

char evaluateFirstCharacter(void)
{
    firstLetter = &tireCodeInput[0]; // stores first index value of user input
    if (*firstLetter != 'P')         // if first element is not P
    {
        printf("Invalid Intended use of tire input: \"%c\" . Only accepting value \"P\" at this time\n", *firstLetter); // statement
    }
    else
        counter++; // counter for final evaluation. If true counter = 1;
};

int tireWidthEvaluation(void)
{
    inputLoop = strtok(tireCodeInput, delim); // stores pre forward slash == tire width xxx
    tireWidth = atoi(inputLoop);              // converts to int value
    if (tireWidth < 155)                      // range low end
    {
        printf("tire width value too low, input: \"%d\" . Range needs to be 155 to 305\n", tireWidth);
    }
    else if (tireWidth > 305) // range high end
    {
        printf("tire width value too high, input: \"%d\" . Range needs to be 155 to 305\n", tireWidth);
    }
    else
        counter++; // if true, count = 2;
}

int sidewallHeightEvaluation(void)
{
    inputLoop = strtok(NULL, delim); // continues to evaluate input
    sideWall = atoi(inputLoop);      // stores post forward slash == tire sidewall xx
    if (sideWall < 30)               // low end of range
    {
        printf("side wall value too low, input: \"%d\" . Range needs to be 30 to 70\n", sideWall);
    }
    else if (sideWall > 70) // high end of range
    {
        printf("side wall value too high, input: \"%d\" . Range needs to be 30 to 70\n", sideWall);
    }
    else
        counter++; // count = 3 if true
}

char evaluateSecondCharacter(void)
{
    secondLetter = &tireCodeInput[7]; // stores 7th index of input
    if (*secondLetter == 'R')         // single quotes evaluates a type char
    {
        counter++;            // count = 4 if true
        return *secondLetter; // jumps out of function
    }
    else if (*secondLetter == 'B')
    {
        counter++;            // count = 4 if true
        return *secondLetter; // jumps out of function
    }
    else
    {
        printf("invalid tire construct: \"%c\" only accepting value(s) \"R\" and \"B\" at this time\n", *secondLetter);
    }
}

int rimDiameterEvaluation(void)
{
    inputLoop = strtok(NULL, delim); // stores rimDiameter
    rimDiameter = atoi(inputLoop);   // converts next iteration of loop to type int
    if (rimDiameter < 14)            //  if (outside lower spectrum of range)
    {
        printf("rim diameter value too low, input: \"%d\" . Range needs to be 14 to 22\n", rimDiameter);
    }
    else if (rimDiameter > 22) // if (outside upper spectrum of range)
    {
        printf("rim diameter value too high, input: \"%d\" . Range needs to be 14 to 22\n", rimDiameter);
    }
    else
        counter++; // if inside range count = 5
}

int loadIndexEvaluation(void)
{
    inputLoop = strtok(NULL, delim); // stores loadIndex
    loadIndex = atoi(inputLoop);     // converts next iteration of loop to type int
    if (loadIndex < 50)              //  if (outside lower spectrum of range)
    {
        printf("load index value too low, input: \"%d\" . Range needs to be 50 to 99\n", loadIndex);
    }
    else if (loadIndex > 99) //  if (outside upper spectrum of range)
    {
        printf("load index value too high, input: \"%d\" . Range needs to be 50 to 99\n", loadIndex);
    }
    else
        counter++; // if inside range count = 6
}

char evaluateLastCharacter(void)
{
    lastLetter = &tireCodeInput[13]; // stores last char of input

    if (*lastLetter == 'S')
    {
        counter++;          // count = 7 if true
        return *lastLetter; // jumps out of function
    }
    else if (*lastLetter == 'T')
    {
        counter++;          // count = 7 if true
        return *lastLetter; // jumps out of function
    }
    else if (*lastLetter == 'U')
    {
        counter++;          // count = 7 if true
        return *lastLetter; // jumps out of function
    }
    else if (*lastLetter == 'H')
    {
        counter++;          // count = 7 if true
        return *lastLetter; // jumps out of function
    }
    else if (*lastLetter == 'V')
    {
        counter++;          // count = 7 if true
        return *lastLetter; // jumps out of function
    }
    else
    {
        printf("Speed rating input invalid: \"%c\". Only accepting value(s) \"S\", \"T\" ,\"U\", \"H\", \"V\"\n", *lastLetter);
    }
}

char finalTireCodeEvaluation(void)
{
    if (counter == 7) // if all functions were within range, count = 7.
                      // == evaluates if count is equal to 7
    {
        printf("Valid Tire Input"); // if count is 7 print
    }
}