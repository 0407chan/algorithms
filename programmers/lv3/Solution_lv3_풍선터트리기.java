package lv3;

import java.util.Arrays;

// 2020-09-24 목요일
// https://programmers.co.kr/learn/courses/30/lessons/68646
// 

public class Solution_lv3_풍선터트리기 {
	
	public static int solution(int[] a) {
        int answer = 0;
        if(a.length <= 3) return a.length;
        return answer;
    }

	public static void main(String[] args) {
//		int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		int[] a = {9,-1,-5};
		System.out.println("정답은 ["+solution(a)+"]");
	}
}
