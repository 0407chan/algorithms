package lv2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42842
// 성공

public class Solution_lv2_카펫 {
	public static int[] solution(int brown, int yellow) {
        int term = (int) Math.sqrt((brown+4)*(brown+4) /4 - 4 * (brown + yellow));
        int w = ((brown + 4) / 2 + term) / 2;
        int h = ((brown + 4) / 2 - term) / 2;
        
        return new int[]{w,h};
    }
	
	public static void main(String[] args) {
		int b = 10;
		int y = 2;
		
		System.out.println("정답은 ["+Arrays.toString(solution(b,y))+"]");
	}
}
