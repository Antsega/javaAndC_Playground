/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */
/* Programmer: Anthony Segarra                                                                */
/* Project: Car Happy!                                                                        */
/* Purpose: Create a linked list of Car Information                                           */
/* Location: Remote                                                                           */
/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */

// libraries
#include <stdio.h>  // struct function
#include <string.h> //strcpy function
#include <stdlib.h> //malloc function

// constants
#define MAX_SIZE 20 // array size

// variables
int totalMiles = 0;           // total miles counter
double totalCars = 0;         // counter for cars
double totalPrice = 0;        // total price counter
double totalPriceAverage = 0; // takes average price

// Prototypes
typedef struct carTemplate // creation of node
{
    char model[MAX_SIZE];     // array for car name
    double price;             // price placeholder
    int miles;                // miles placeholder
    struct carTemplate *next; // pointer to next node
} * CAR_T;                    // name of template

CAR_T firstCar, secondCar, thirdCar, fourthCar; // nodes

void link(CAR_T firstCar, CAR_T secondCar, CAR_T thirdCar, CAR_T fourthCar);                                          // connect nodes to eachother aswell as terminate link
void vehicleInfo(CAR_T firstCar, CAR_T secondCar, CAR_T thirdCar, CAR_T fourthCar);                                   // print all desired information
int totalMilesFunction1stCall(CAR_T firstCar, CAR_T secondCar, CAR_T thirdCar, CAR_T fourthCar);                      // total miles calculator
int totalMilesFunction2ndCall(CAR_T firstCar, CAR_T secondCar, CAR_T thirdCar, CAR_T fourthCar);                      // further calls for total miles
double totalPriceAverageFunction(CAR_T firstCar, CAR_T secondCar, CAR_T thirdCar, CAR_T fourthCar, double totalCars); // total price calculator

// main start
int main(void)
{
    firstCar = (CAR_T)malloc(sizeof(struct carTemplate)); // creation of first car node
    strcpy(firstCar->model, "56 Ford");                   // car name
    firstCar->price = 500.00;                             // price of car
    firstCar->miles = 23000;                              // miles driven

    secondCar = (CAR_T)malloc(sizeof(struct carTemplate)); // creation of second car node
    strcpy(secondCar->model, "64 Impala");                 // car name
    secondCar->price = 1800.00;                            // price of car
    secondCar->miles = 12000;                              // miles driven

    thirdCar = (CAR_T)malloc(sizeof(struct carTemplate)); // creation of third car node
    strcpy(thirdCar->model, "57 Ford");                   // car name
    thirdCar->price = 1400.00;                            // price of car
    thirdCar->miles = 22000;                              // miles driven

    fourthCar = (CAR_T)malloc(sizeof(struct carTemplate)); // creation of 4th car node
    strcpy(fourthCar->model, "65 Galaxy");                 // car name
    fourthCar->price = 2600.00;                            // price of car
    fourthCar->miles = 48000;                              // miles driven

    link(firstCar, secondCar, thirdCar, fourthCar); // once all nodes have been established, creation of linked list

    // console output
    vehicleInfo(firstCar, secondCar, thirdCar, fourthCar);               // car, price, miles for four arguments
    totalMilesFunction1stCall(firstCar, secondCar, thirdCar, fourthCar); // call for total miles

    // seperation
    vehicleInfo(firstCar, secondCar, thirdCar, fourthCar);                          // car, price, miles details
    totalMilesFunction2ndCall(firstCar, secondCar, thirdCar, fourthCar);            // 2nd call for total miles
    totalPriceAverageFunction(firstCar, secondCar, thirdCar, fourthCar, totalCars); // total cost average
    return 0;
}

// functions expanded
void link(CAR_T firstCar, CAR_T secondCar, CAR_T thirdCar, CAR_T fourthCar) // connects the link for each node
{
    firstCar->next = secondCar; // link of 1st car to second
    secondCar->next = thirdCar; // link of 2nd car to third
    thirdCar->next = fourthCar; // link of 3rd car to fourth
    fourthCar->next = NULL;     // ending linked list
}

void vehicleInfo(CAR_T firstCar, CAR_T secondCar, CAR_T thirdCar, CAR_T fourthCar) // takes four arguements and prints the name, price and miles
{
    printf("Car: %s\tPrice: %.2lf\t I drove it: %d\n", firstCar->model, firstCar->price, firstCar->miles);        // first car's info
    printf("Car: %s\tPrice: %.2lf\t I drove it: %d\n", secondCar->model, secondCar->price, secondCar->miles);     // second car's info
    printf("Car: %s\tPrice: %.2lf\t I drove it: %d\n", thirdCar->model, thirdCar->price, thirdCar->miles);        // third car's info
    printf("Car: %s\tPrice: %.2lf\t I drove it: %d\n\n\n", fourthCar->model, fourthCar->price, fourthCar->miles); // fourth car's info
}

int totalMilesFunction1stCall(CAR_T firstCar, CAR_T secondCar, CAR_T thirdCar, CAR_T fourthCar) // total miles calculator
{
    totalMiles += firstCar->miles + secondCar->miles + thirdCar->miles + fourthCar->miles; // takes all four inputs and adds them
    printf("The Total Miles: %d\n", totalMiles);                                           // prints total miles
}

int totalMilesFunction2ndCall(CAR_T firstCar, CAR_T secondCar, CAR_T thirdCar, CAR_T fourthCar) // calling this function again doubled the sum of the total, so a second function was needed
{
    totalMiles;                                     // recalling the total no longer required me to re-add the total sum again
    printf("Total Miles Driven: %d\n", totalMiles); // prints total miles
}

double totalPriceAverageFunction(CAR_T firstCar, CAR_T secondCar, CAR_T thirdCar, CAR_T fourthCar, double totalCars) // calculates the average of all four arguments
{
    totalPrice += firstCar->price + secondCar->price + thirdCar->price + fourthCar->price; // collects a total sum
    totalCars += 4;                                                                        // 4 comes from number of cars

    totalPriceAverage = totalPrice / totalCars;                // sum divided by number of cars gets the average
    printf("The average price was: %.2lf", totalPriceAverage); // total price
}
