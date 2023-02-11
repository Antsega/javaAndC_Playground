/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */
/* Programmer: Anthony Segarra                                                                */
/* Project: Train Maker                                                                       */
/* Purpose: Process train data and compile the information                                    */
/* Location: Remote                                                                           */
/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */

// Libraries
#include <stdlib.h> //atoi function
#include <string.h> // strtok function
#include <stdio.h>  // recognizes FILE typedef

// Constants
#define MAX_LENGTH 256           // array size
#define LOCOMOTIVE_PRODUCES 1000 // one engine produces 1000 horsepower
#define ROUND_UP 0.5             // a constant that we will add to round up to the nearest whole number

// Variables
FILE *fp;                                                                                                       // defines text file pointer
char buffer[MAX_LENGTH];                                                                                        // array for fgets
char delim[] = " ";                                                                                             // decides when strtok will seperate from the original string
char *trainName, *trainType, *trainWeight, *trainLength, *trainHorsepower, *numberOfTrains;                     // arrays to save individual values, creating them as pointers allow them to be changed
int overallLengthCounter = 0, numberOfTrainsCounter = 0, lengthOfTrainsCounter = 0, totalHorsePowerCounter = 0; // counters
double trainWeightCounter = 0;                                                                                  // counters
double trainWeightFloat, numberOfTrainsFloat, horsepowerfloat;                                                  // convert int to float
int numberOfTrainsInt, trainLengthInt, totalHorsepowerInt;                                                      // atoi conversions
double horsepowerRequried;                                                                                      // horespower function
double requiredEngine;                                                                                          // engineCalc function

// Prototypes
int whileLoop(void);
int totalLengthOfTrains(int numberOfTrainsInt, int trainLengthInt);
int totalHorsepowerRequired(double numberOfTrainsFloat, double horsepowerfloat);
double engineCalculator(double horsepowerRequried);

int main(void)
{
    // test and opens input file
    if (!(fp = fopen("traindata.txt", "r"))) // if cannot find the local file
    {
        printf("wagers.txt could not be opened for input."); // state
        exit(1);                                             // exit program
    }

    // Display start
    printf("\nCurrent Train Cars\n");                                                      // Header
    whileLoop();                                                                           // array loop
    printf("\nThere are %d cars in the train\n", numberOfTrainsCounter);                   // prints total # of cars
    printf("The total length of the train is: %d\n", overallLengthCounter);                // prints total length
    printf("The total horsepower needed to pull this train: %.0lf\n", horsepowerRequried); // prints required horsepower, reason for .0 is to display it as an int but keep it a float to round
    engineCalculator(horsepowerRequried);                                                  // prints required engines
    // Display End

    fclose(fp); // closes file
    return 0;   // exists program
}

// Functions expanded
int whileLoop(void) // loop that saves each segment of the original array into seperate pieces everytime there is a space " "
{
    while (fgets(buffer, MAX_LENGTH, fp)) // fgets reads from text file line by line
    {
        // create array of file contents
        trainName = strtok(buffer, delim); // saves name

        trainType = strtok(NULL, delim); // saves type

        trainWeight = strtok(NULL, delim);      // saves weight
        trainWeightFloat = atoi(trainWeight);   // converts to int
        trainWeightCounter += trainWeightFloat; // total weight

        trainLength = strtok(NULL, delim);       // saves length
        int trainLengthInt = atoi(trainLength);  // converts to int
        lengthOfTrainsCounter += trainLengthInt; // total number of trains

        trainHorsepower = strtok(NULL, delim);        // saves horsepower
        totalHorsepowerInt = atoi(trainHorsepower);   // converts to int
        double horsepowerfloat = totalHorsepowerInt;  // converts to float
        totalHorsePowerCounter += totalHorsepowerInt; // saves total horsepower

        numberOfTrains = strtok(NULL, delim);           // saves number of trains
        int numberOfTrainsInt = atoi(numberOfTrains);   // converts to int
        double numberOfTrainsFloat = numberOfTrainsInt; // converts to double
        numberOfTrainsCounter += numberOfTrainsInt;     // saves total trainCount

        totalLengthOfTrains(numberOfTrainsInt, trainLengthInt);        // saves overall length
        totalHorsepowerRequired(numberOfTrainsFloat, horsepowerfloat); // save overall horsepower

        printf("%s\t\tWeight: %.2lf\tLength: %d\tHorsepower: %s\tNumber of trains: %d\n", trainName, trainWeightFloat, trainLengthInt, trainHorsepower, numberOfTrainsInt);
    }
};

int totalLengthOfTrains(int numberOfTrainsInt, int trainLengthInt) // combines length every iteration
{
    overallLengthCounter += (numberOfTrainsInt * trainLengthInt); // multiplies cars length by number of cars and saves the total
};

int totalHorsepowerRequired(double numberOfTrainsFloat, double horsepowerfloat) // combines horsepower every iteration
{
    horsepowerRequried += (numberOfTrainsFloat * horsepowerfloat); // multiplies number of cars by horsepower and saves the total
};

double engineCalculator(double horsepowerRequried) // takes total horsepower and finds out how many engines will be needed
{
    requiredEngine = ((horsepowerRequried / LOCOMOTIVE_PRODUCES) + ROUND_UP);           // (total horsepower(HP) / amount of HP a single engine produces) + ability to round up
    printf("The number of engines needed to pull the train is: %.0lf", requiredEngine); // .0lf prints the float without a decimal value, to apear as an int
};