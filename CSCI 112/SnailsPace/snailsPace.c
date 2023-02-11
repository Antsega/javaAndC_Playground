/* * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/* Programmer: Anthony Segarra							 */
/* Project: A SNAIL'S PACE								 */	
/* Purpose: Calculate A Snail's Pace					 */
/* Location: Remote										 */
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/* * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/* Create a Program that will calculate how long it will */
/* take Sam the snail to crawl around the world			 */
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h> 
#include <stdlib.h>

FILE *fp;

int main(void) {

	const earthsCircumference = 24901;
	const mileToFeet = 5280;
	const dayToHour = 24;
	const yearToDay = 365;
	const samAvgSpeed = 1;		/* 1 foot per hour */

	int mileSpeed = samAvgSpeed * mileToFeet;   /* 5,280 hours for 1 mile */
	int worldSpeed = earthsCircumference * mileSpeed; /* total hours to go around the world */
	int hoursToDays = worldSpeed / dayToHour;		  /* Converting hours to days */
	int daysToYears = hoursToDays / yearToDay;		  /* Converting days to years */

	fopen_s(&fp, "csis.txt", "w");		/* after variable declarations*/


	printf("It will take Sam %d years to crawl around the world",daysToYears);
	fprintf(fp, "It will take Sam %d years to crawl around the world", daysToYears);

	fclose(fp);
	return 0;
}

