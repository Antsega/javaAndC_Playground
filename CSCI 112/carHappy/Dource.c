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

// structs
struct carTemplate // struct define
{
    char model[MAX_SIZE];     // array for car name
    double price;             // price placeholder
    int miles;                // miles placeholder
    struct carTemplate *next; // pointer to next node
    struct carTemplate *prev; // pointer to previous node
    struct carTemplate *end;  // pointer to previous node
};

// variables

// prototypes
void Link(struct carTemplate *linked, struct carTemplate *prev, struct carTemplate *next, struct carTemplate *end);

// main
int main(void)
{
    struct carTemplate carOne;
    carOne.miles = 2;
    carOne.next = NULL;
    carOne.prev = NULL;

    struct carTemplate carTwo;
    carTwo.miles = 4;
    carTwo.next = NULL;
    carTwo.prev = NULL;

    struct carTemplate carThree;
    carThree.miles = 6;
    carThree.next = NULL;
    carThree.prev = NULL;

    struct carTemplate carFour;
    carThree.miles = 8;
    carThree.next = NULL;
    carThree.prev = NULL;

    Link(&carTwo, &carOne, &carThree, &carFour);

    int cnt = 0;
    for (struct carTemplate *i = &carOne; i != NULL; i = i->next)
    {
        printf("Item %d value is %d\n", cnt, i->miles);
        cnt++;
    }

    return 0;
}

void Link(struct carTemplate *linked, struct carTemplate *prev, struct carTemplate *next, struct carTemplate *end)
{
    linked->prev = prev;
    linked->next = next;
    linked->end = end;
    prev->next = linked;
    next->prev = linked;
}