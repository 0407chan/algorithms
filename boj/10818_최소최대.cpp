#define _CRT_SECURE_NO_WARNINGS
#include <iostream>

#include <stdio.h>
using namespace std;

int main(void)
{
	int num = 0;
	int cnt = 0;
	int max = -1;
	for (int i = 1; i <= 9; i++)
	{
		scanf("%d", &num);
		if (num > max)
		{
			max = num;
			cnt = i;
		}
	}

	printf("%d\n%d", max, cnt);
	system("pause");
}
