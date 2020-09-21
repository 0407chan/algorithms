package lv2;
// https://programmers.co.kr/learn/courses/30/lessons/12985
// 성공

public class Solution_lv2_예상대진표 {
	public static int solution(int n, int a, int b)
    {
        int answer = 0;
        while(true) {
        	if(a == b) break;
        	a = (a+1)/2;
        	b = (b+1)/2;
        	answer++;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 8;
		int a = 4;
		int b = 7;
		System.out.println("정답은 ["+solution(n,a,b)+"]");
	}
	
}
