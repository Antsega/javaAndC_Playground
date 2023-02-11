/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */
/* Programmer: Anthony Segarra                                                                */
/* Project: Here Come the Fudge! || How many containers are needed?                           */
/* Purpose: Calculate how many drums and which size we will need for total fudge              */
/* Location: Remote                                                                           */
/* * * * * * * * * * * * * * * * * * * * * * * * * * * *  * * *  * * * * * * * * * * * * * *  */

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h> 
#include <stdlib.h>

FILE *fp;

int main(void) {
    int totalGallons;                       /* Task #1 */

    fopen_s(&fp, "csis.txt", "w");        /* end of variable declarations*/

    /* Displayed Product Start */
    printf("How many gallons were ordered? \n");
    fprintf(fp, "How many gallons were ordered? \n");
    scanf_s("%d", &totalGallons);           /* Task #2 */


    printf("Gallons of fudge ordered: %d \n", totalGallons);
    fprintf(fp, "Gallons of fudge ordered: %d \n", totalGallons);


    int fiftyFiveDrums = (totalGallons / 55);
    printf("The number of 55 gallon drums is: %d \n", fiftyFiveDrums);
    fprintf(fp, "The number of 55 gallon drums is: %d \n", fiftyFiveDrums);
    int leftOverFiftyFive = (totalGallons % 55);        /* Left Over */


    int twentyDrums = (leftOverFiftyFive / 20);
    printf("The number of 20 gallon drums is: %d \n", twentyDrums);
    fprintf(fp, "The number of 20 gallon drums is: %d \n", twentyDrums);
    int leftOverTwenty = (leftOverFiftyFive % 20);      /* Left Over */

    
    int tenDrums = (leftOverTwenty / 10);
    printf("The number of 10 gallon drums is: %d \n", tenDrums);
    fprintf(fp, "The number of 10 gallon drums is: %d \n", tenDrums);
    int leftOverTen = (leftOverTwenty % 10);            /* Left Over */

    int fiveDrums = (leftOverTen / 5);
    printf("The number of 5 gallon drums is: %d \n", fiveDrums);
    fprintf(fp, "The number of 5 gallon drums is: %d \n", fiveDrums);
    int leftOverFiveDrums = (leftOverTen % 5);          /* Left Over */


    int oneDrums = (leftOverFiveDrums / 1);
    printf("The number of 1 gallon drums is: %d \n", oneDrums);
    fprintf(fp, "The number of 1 gallon drums is: %d \n", oneDrums);      /* Task 3 */

/* Displayed Product End */

/* close below */
    fclose(fp);        /* Saved to Disc*/
    return 0;
}