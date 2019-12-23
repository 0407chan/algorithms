#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdio.h>
#include <string>
using namespace std;

int main(void)
{
	int n = 0;
	cin >> n;
	cin.ignore(32767, '\n');
	for (int i = 0; i < n; i++)
	{
		string s;
		getline(cin,s);
		int ans = 0;
		int num = 1;
		for (int j = 0; j < s.length(); j++)
		{
			if (s[j] == 'O')
			{
				ans += num;
				num++;
			}
			else
			{
				num = 1;
			}
		}
		cout << ans << endl;
		ans = 0;
	}
	system("pause");
}