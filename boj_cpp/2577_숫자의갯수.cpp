#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdio.h>
using namespace std;

static int nums[10];
int main(void)
{
	int num = 1;
	int a = 0;
	for (int i = 0; i < 3; i++)
	{
		scanf("%d", &a);
		num *= a;
	}

	while (true)
	{
		if (num == 0) break;
		nums[num % 10]++;
		num /= 10;
	}

	for (int i = 0; i < 10; i++)
	{
		printf("%d\n", nums[i]);
	}

	system("pause");
}
