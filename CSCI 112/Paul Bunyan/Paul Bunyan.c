/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */
/* Programmer: Anthony Segarra                                                                */
/* Project: Paul Bunyan || Paul Bunyan Employment                                             */
/* Purpose: Calculate how to keep Paul Employed                                               */
/* Location: Remote                                                                           */
/* * * * * * * * * * * * * * * * * * * * * * * * * * * *  * * *  * * * * * * * * * * * * * *  */

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h> 
#include <stdlib.h>

FILE *fp;

int main(void) {
    double totalTrees = 1000;
    double rate = 0.13;
    int i;


    fopen_s(&fp, "csis.txt", "w");        /* end of variable declarations*/

    /* Displayed Product Start */
    /* Initial Data Start */
    printf("Paul has 1000 trees and cuts at a rate of 13 percent a year here are the results\n\n");
    fprintf(fp, "Paul has 1000 trees and cuts at a rate of 13 percent a year here are the results\n\n");


    for (i = 0; i < 31; i++) {
        printf("year:%d\t \tNumber of Trees Remaining: %.0lf\n", i, totalTrees);
        fprintf(fp, "year:%d\t \tNumber of Trees Remaining: %.0lf\n", i, totalTrees);
        totalTrees -= totalTrees * rate;
        if (totalTrees < 50) {
            break;
        }
    }
    printf("\nIf Paul continues at this rate, his 22nd year he will have less than 50 trees\n");
    fprintf(fp, "\nIf Paul continues at this rate, his 22nd year he will have less than 50 trees\n");
    /* Initial Data End */

    /* Added Seeds Start */
    printf("\nInput how many trees Paul will need to plant per year to stay emplyed for 30 years and still have 50 trees\n");
    fprintf(fp, "\nInput how many trees Paul will need to plant per year to stay emplyed for 30 years and still have 50 trees\n");

    int plantedTrees;
    int n;
    double newTreeCount = 1000;
    double newCountPlusPlanted;

    scanf_s("\n%d", &plantedTrees);

    for (n = 0; n < 100; n++) {
        printf("year:%d\t \tNumber of Trees Remaining: %.0lf\n", n, newTreeCount);
        fprintf(fp, "year:%d\t \tNumber of Trees Remaining: %.0lf\n", n, newTreeCount);
        newTreeCount -= (newTreeCount * rate) - plantedTrees;
        if (newTreeCount < 50) {
            break;
        }
}
    if (n >= 30) {
        printf("\nNice work! He has work for at least 30 years!\n");
        fprintf(fp, "\nNice work! He has work for at least 30 years!\n");
    }
    else printf("\nTry again to keep Paul Employed for 30 years.\n");
    fprintf(fp, "\nTry again to keep Paul Employed for 30 years.\n");

    /* Added Seeds End */
/* Displayed Product End */

/* close below */
    fclose(fp);        /* Saved to Disc*/
    return 0;
}



