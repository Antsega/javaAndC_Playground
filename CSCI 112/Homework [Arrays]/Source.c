
#include <stdio.h>
#include <string.h>

#define STRSIZ 25
// variables
int x;

// prototype

int main(void)
{
	typedef struct
	{
		char model[STRSIZ];
		int year;
		int range;
	} Automobile_t; // creates template

	Automobile_t car;			// creates car variable using Automobile template
	strcpy(car.model, "Tesla"); // assigns values to inputs
	car.year = 2017;
	car.range = 335;

	Automobile_t vehicle[500]; // creates 500 options using template Auto
	vehicle[4] = car;		   // creates new variable for 5th element of vehicle array using car values

	// printf("model: %s\n", vehicle[4].model); // prints values
	// printf("year: %d\n", vehicle[4].year);
	// printf("range: %d", vehicle[4].range);

	Automobile_t *p = &vehicle[4];

	// printf("%s\n", p->model);
	// printf("%d\n", p->year);
	// printf("%d", p->range);

	Automobile_t *q = &vehicle[0];

	printf("%s\n", q->model);
	printf("%d\n", q->year);
	printf("%d", q->range);

	return 0;
}
