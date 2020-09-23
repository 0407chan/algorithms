package lv2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42885
// 성공

public class Solution_lv2_구명보트 {
	public static int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        int end = people.length-1;
        Arrays.sort(people);
        while(true) {
        	if(end < start) break;
        	if(start == end) {
        		answer++;
        		break;
        	}
        	if(people[start] + people[end] <= limit) {
        		start++;
        		end--;
        		answer++;
        	}
        	else {
        		end--;
        		answer++;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] p = {10,10,10,90,90,90};
		int l = 100;
		System.out.println("정답은 ["+solution(p,l)+"]");
	}
}
