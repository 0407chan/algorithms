#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdio.h>
using namespace std;

int main(void)
{

	int a = 0;
	scanf("%d", &a);
	float *nums = new float[a];
	int num = 0;
	int max = -1;
	for (int i = 0; i < a; i++)
	{
		scanf("%d", &num);
		nums[i] = num;
		if (max < num)
		{
			max = num;
		}
	}

	float ans = 0;
	for (int i = 0; i < a; i++)
	{
		ans += nums[i] / max * 100;
	}
	printf("%.2f", ans/a);
	system("pause");
}
