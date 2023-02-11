/* * * * * * * * * * * * * * * * * * * * * * * * * * *  * *  * *  * * * * * * * * * * * * *   */
/* Programmer: Anthony Segarra                                                                */
/* Project: Cars For Sale || What it's worth                                                  */
/* Purpose: Calculate the 2008 Average Retail Price from the 2004 Average Retail Price        */
/* Location: Remote                                                                           */
/* * * * * * * * * * * * * * * * * * * * * * * * * * * *  * * *  * * * * * * * * * * * * * *  */

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h> 
#include <stdlib.h>

FILE *fp;

int main(void) {
    double novaRate = 335;
    double challengerRate = 302;
    double cudaRate = 291;
    double mustangRate = 201;
    double gtoRate = 251;
    const percentConvertor = 100;

/* Nova */
    double nova2004 = 2500.00;
    double novaConverging = ((novaRate / percentConvertor) * nova2004);
    double nova2008 = novaConverging + nova2004;
/* Challenger */
    double challenger2004 = 44200;
    double challengerConverging = ((challengerRate / percentConvertor) * challenger2004);
    double challenger2008 = challengerConverging + challenger2004;
/* Cuda */
    double cuda2004 = 7400;
    double cudaConverging = ((cudaRate / percentConvertor) * cuda2004);
    double cuda2008 = cudaConverging + cuda2004;
/* Mustang */
    double mustang2004 = 55000.00;
    double mustangConverging = ((mustangRate / percentConvertor) * mustang2004);
    double mustang2008 = mustangConverging + mustang2004;
/* GTO */
    double gto2004 = 29000.00;
    double gtoConverging = ((gtoRate / percentConvertor) * gto2004);
    double gto2008 = gtoConverging + gto2004;

    fopen_s(&fp, "csis.txt", "w");        /* end of variable declarations*/

        /* Displayed Product Start */

    printf("Car           2004 Value          2008 Value\n");
    fprintf(fp, "Car           2004 Value          2008 Value\n");
    printf("---------------------------------------------\n");
    fprintf(fp, "---------------------------------------------\n");
    
    printf("Nova       :   %.2lf          :  %.2lf\n", nova2004, nova2008);
    fprintf(fp, "Nova       :   %.2lf          :  %.2lf\n", nova2004, nova2008);

    printf("Challenger :  %.2lf          : %.2lf\n", challenger2004, challenger2008);
    fprintf(fp, "Challenger :  %.2lf          : %.2lf\n", challenger2004, challenger2008);

    printf("Cuda       :   %.2lf          :  %.2lf\n", cuda2004, cuda2008);
    fprintf(fp, "Cuda       :   %.2lf          :  %.2lf\n", cuda2004, cuda2008);

    printf("Mustang    :  %.2lf          : %.2lf\n", mustang2004, mustang2008);
    fprintf(fp, "Mustang    :  %.2lf          : %.2lf\n", mustang2004, mustang2008);

    printf("GTO        :  %.2lf          : %.2lf\n", gto2004, gto2008);
    fprintf(fp, "GTO        :  %.2lf          : %.2lf\n", gto2004, gto2008);

    /* Displayed Product End */

/* close below */
    fclose(fp);        /* Saved to Disc*/
    return 0;
}
