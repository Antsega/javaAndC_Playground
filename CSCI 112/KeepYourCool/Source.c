/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * *  */
/* Programmer: Anthony Segarra										   */
/* Project: Keep Your Cool											   */
/* Purpose: When given Ramona's temp what is the temp in Big Bear?     */
/* Location: Remote                                                    */
/* * * * * * * * * * * * * * * * * * * * * * * * * * * *  * * *  * * * */

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h> 
#include <stdlib.h>
#include <math.h>

FILE *fp;

int main(void) {
	double ramonaTempInput;
	int romonaElevInput;
	int bigBearElev;


	fopen_s(&fp, "csis.txt", "w");        /* end of variable declarations*/
	
	/* Displayed Product Start */

	printf("Enter the current temperature in Ramona in celsius degrees: ");
	fprintf(fp, "Enter the current temperature in Ramona in celsius degrees: ");
	scanf_s("%lf", &ramonaTempInput);
	fscanf_s(fp, "%lf", &ramonaTempInput);
	

	printf("Enter your current elevation in Ramona in feet: ");
	fprintf(fp, "Enter your current elevation in Ramona in feet: ");
	scanf_s("%d", &romonaElevInput);
	fscanf_s(fp, "%d", &romonaElevInput);

	printf("Also, the desired elevation in Big Bear in feet: ");
	fprintf(fp, "Also, the desired elevation in Big Bear in feet: ");
	scanf_s("%d", &bigBearElev);
	fscanf_s(fp, "%d", &bigBearElev);
	
	double convertedTemp = ((ramonaTempInput * 9) / 5) + 32;	/* Convert Celcius to Feh*/
	double elevationDifference = (bigBearElev - romonaElevInput) ;	/* Difference in Elevation */
	double divideByThousand = elevationDifference / 1000;
	double perThousand = (divideByThousand * 5.38);
	float temp_after_elevation = convertedTemp - perThousand;

	printf("The temperature in farhenheit at %d feet is: %.1f",bigBearElev, temp_after_elevation);
	fprintf(fp, "The temperature in farhenheit at %d feet is: %.1f", bigBearElev, temp_after_elevation);
	/* Displayed Product End */

	/* close below */
	fclose(fp);		/* Saved to Disc*/
	return 0;
}