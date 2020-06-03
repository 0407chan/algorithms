#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdio.h>
using namespace std;

int main(void)
{
	int nums[8];
	int num = 0;
	bool asc = true;
	bool desc = true;

	for (int i = 0; i < 8; i++) {
		scanf("%d", &num);
		nums[i] = num;
		if (nums[i] == i + 1 && asc)
		{
			asc = true;
		}
		else
		{
			asc = false;
		}

		if (nums[i] == 8-i && desc)
		{
			desc = true;
		}
		else
		{
			desc = false;
		}

	}

	
	if (asc && !desc)
	{
		printf("ascending");
	}
	else if (!asc && desc)
	{
		printf("descending");
	}
	else
	{
		printf("mixed");
	}

}
