/*
* string에 대해 배웠다.
* string을 사용하려면 include를 해야한다
* string은 getline으로 읽어온다.
* getline 전에 cin으로 읽어왔다면 cin.ignore로 그 전에있는 '\n'을 처리해줘야한다.
* string을 index로 접근을 하면 char로 읽는다.
* 연습하자
*/

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
