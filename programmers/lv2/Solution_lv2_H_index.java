package lv2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42747
// 

public class Solution_lv2_H_index {
	public static int solution(int[] citations) {
		int ans = 0;
		
		Arrays.sort(citations);
		
        return ans;
    }
	
	public static void main(String[] args) {
		int[] citations = {3,0,6,1,5};
		System.out.println("정답은 ["+solution(citations)+"]");
	}
}
