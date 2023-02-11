
/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */
/* Programmer: Anthony Segarra                                                                */
/* Project: Bet On It || Professional Gambler Tracker                                         */
/* Purpose: Display the results of your wagers and final status                               */
/* Location: Remote                                                                           */
/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h> 
#include <stdlib.h>

FILE* fp;       // external textfile (local)
FILE* csit;     // file saving to 

// Prototypes
void printLine(void);
void ReportHeader(void);
void initialStash(double bet, double* stash, double* payoff, double* startingStash);
void addToStash(double bet, double* stash, double* payoff, int* numWon, double* amtWon);
void lossFromStash(double bet, double* stash, double* payoff, int* numLost, double* amtLost);
void printReportFooter(int numWon, double amtWon, int numLost, double amtLost, double startingStash, double payoff, double endingStash);

int main(void) {
    
    // Variables Declared
    char code;
    double bet, payoff, stash, amtWon, amtLost, startingStash, endingStash;
    int numWon, numLost;


    // test and open input file and output file. 
    if (!(fp = fopen("wagers.txt", "r"))) {
        printf("wagers.txt could not be opened for input.");

        exit(1);
    }
    if (!(csit = fopen("csit.txt", "w"))) {
        printf("csit.txt could not be opened for output.");
        fprintf(csit, "csit.txt could not be opened for output.");

        exit(1);
    }

    //initialize variable values 
    bet = payoff = stash = amtWon = amtLost = startingStash = endingStash = 0.0;
    numWon = numLost = 0;
    
    // Print out report header 
    ReportHeader();
    

    // loop through file
    while (!feof(fp)) {
        fscanf(fp, "%c %lf\n", &code, &bet);
        if (code == 'D') // initial deposit 
            initialStash(bet, &stash, &payoff, &startingStash);
        else if (code == 'W') // a win
            addToStash(bet, &stash, &payoff, &numWon, &amtWon);
        else // must have been a loss
            lossFromStash(bet, &stash, &payoff, &numLost, &amtLost);
    }

    // Final calculation of profit or loss
    endingStash = stash - payoff;

    // Print Summary
    printReportFooter(numWon, amtWon, numLost, amtLost, startingStash, payoff, endingStash);

    // close data and output file
    fclose(fp);
    fclose(csit);
return 0;
}


/* Functions */
void printLine(void) {
    printf(" %16s %16s %15s %14s\n", "-----", "-----", "-----", "-----" );
    fprintf(csit, " %16s %16s %15s %14s\n", "-----", "-----", "-----", "-----");
    return;
}

void ReportHeader(void) {
    printf("  %15s %15s %15s %15s\n", "Wager", "Won", "Loss", "Stash");
    fprintf(csit, "  %15s %15s %15s %15s\n", "Wager", "Won", "Loss", "Stash");
    printLine();
    return;
}

void initialStash(double bet, double* stash, double* payoff, double* startingStash) {
    *stash = bet;
    *startingStash = bet;
    printf("Starting Stash %50.2lf\n", *stash);
    fprintf(csit, "Starting Stash %50.2lf\n", *stash);
    return;
}

void addToStash(double bet, double* stash, double* payoff, int* numWon, double* amtWon) {
    *stash += bet;
    *payoff += (bet * 0.1);
    *numWon += 1;
    *amtWon += bet;
    printf("Won! %30.2lf %29.2lf \n", bet, *stash);
    fprintf(csit, "Won! %30.2lf %29.2lf \n", bet, *stash);
    return;

}

void lossFromStash(double bet, double* stash, double* payoff, int* numLost, double* amtLost) {
    *payoff += (bet * 0.05);
    *stash -= bet;
    *numLost += 1;
    *amtLost += bet;
    printf("Lost! %45.2lf %13.2lf \n", bet, *stash);
    fprintf(csit, "Lost! %45.2lf %13.2lf \n", bet, *stash);
    return;

}

void printReportFooter(int numWon, double amtWon, int numLost, double amtLost, double startingStash, double payoff, double endingStash) {
    printf("\n\n\nTotal number Wins: %d\n", numWon);
    fprintf(csit, "\n\n\nTotal number Wins: %d\n", numWon);
    printf("Total amount Won: %5.2lf\n", amtWon);
    fprintf(csit,"Total amount Won: %5.2lf\n", amtWon);
    printf("Total number Losses: %d\n", numLost);
    fprintf(csit, "Total number Losses: %d\n", numLost);
    printf("Total amount Lost: %6.2lf\n", amtLost);
    fprintf(csit,"Total amount Lost: %6.2lf\n", amtLost);

    printf("\n\nStarting Stash: %6.2lf\n", startingStash);
    fprintf(csit, "\n\nStarting Stash: %6.2lf\n", startingStash);
    printf("Total payoff charge: %6.2lf\n", payoff);
    fprintf(csit, "Total payoff charge: %6.2lf\n", payoff);
    printf("Closing Stash: %6.2lf\n", endingStash);
    fprintf(csit, "Closing Stash: %6.2lf\n", endingStash);
}

