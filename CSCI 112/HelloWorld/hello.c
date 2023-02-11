#include <stdio.h>
#include <string.h>

int main(void)
{
	int ary[4] = {1, 2, 3, 4};
	int *p = ary + 3;
	printf("%d\n", p[-2]);
}
