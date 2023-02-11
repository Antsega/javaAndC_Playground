/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */
/* Programmer: Anthony Segarra                                                                */
/* Project: Speedy || Consequences for Speeding                                               */
/* Purpose: Calculate the consequences for speeding post citation                             */
/* Location: Remote                                                                           */
/* * * * * * * * * * * * * * * * * * * * * * * * * * * *  * * *  * * * * * * * * * * * * * *  */

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h> 
#include <stdlib.h>

FILE *fp;

int main(void) {
    int speedLimit;
    int clockedSpeed;
    int totalTickets;


    fopen_s(&fp, "csis.txt", "w");        /* end of variable declarations*/

    /* Displayed Product Start */

    printf("Enter the speed limit: ");
    fprintf(fp, "Enter the speed limit: ");
    scanf_s("%d", &speedLimit);

    printf("\nEnter clocked speed: ");
    fprintf(fp, "\nEnter clocked speed: ");
    scanf_s("%d", &clockedSpeed);

    printf("\nHow many tickets have you\nrecieved in the last year? ");
    fprintf(fp, "\nHow many tickets have you\nrecieved in the last year? ");
    scanf_s("%d", &totalTickets);


    /* Start of fee calculations */
    if (clockedSpeed < speedLimit) {
        printf("\nYou are free of charges\n");
        fprintf(fp, "\nYou are free of charges\n");
    }
    else if ((clockedSpeed - speedLimit) <= 15) {
        float fee = 238; /* 0 to 15 over */
        printf("\nYou are fined: %.2f\nNo suspension neccesary.\n", fee);
        fprintf(fp, "\nYou are fined: %.2f\nNo suspension neccesary.\n", fee);
    }

    else if ((clockedSpeed - speedLimit) <= 25) {
        float fee = 367; /* 16 to 25 */
        printf("\nYou are fined: %.2f\nNo suspension neccesary.\n", fee);
        fprintf(fp, "\nYou are fined: %.2f\nNo suspension necessary.\n", fee);
    }
    else if ((clockedSpeed - speedLimit) <= 100) {
        float fee = 490; /* 26 to 100 */
        printf("\nYou are fined: %.2f\n", fee);
        fprintf(fp, "\nYou are fined: %.2f\n", fee);
        if (totalTickets > 1) {                                         /* Suspension starts at 26 - 100 */
            printf("Your license is suspended for 6 months\n");
            fprintf(fp, "\nYour license is suspended for 6 months\n");
        }
        else if (totalTickets <= 1) {
            printf("No suspension necessary\n");
            fprintf(fp, "No suspension necessary\n");
        }                                                              /* Suspension End */
    }
    else if ((clockedSpeed - speedLimit) > 100) {
        float fee = 900; /* 100 over */
        printf("\nYou are fined: %.2f\n", fee);
        fprintf(fp, "\nYou are fined: %.2f\n", fee);
        if (totalTickets > 1) {                                         /* Suspension start */
            printf("Your license is suspended for 6 months\n");
            fprintf(fp, "Your license is suspended for 6 months\n");
        }
        else if (totalTickets <= 1) {
            printf("No suspension necessary\n");
            fprintf(fp, "No suspension necessary\n");
        }                                                               /* Suspension End */
    }

    /* End of fee calculations */



/* Displayed Product End */

/* close below */
    fclose(fp);        /* Saved to Disc*/
    return 0;
}