package lv_1;

import java.util.Arrays;

public class Solution_1차_비밀지도 {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map = new int[n][n];
        for(int i=0; i<n; ++i) {
        	int num = arr1[i];
        	int j= n-1;
        	while(true) {
        		if(j < 0) break;
        		
        		if(num%2 == 1) 
        			map[i][j] = 1;
        		num /= 2;
        		j--;
        	}
        	
        	num = arr2[i];
        	j = n-1;
        	while(true) {
        		if(j < 0) break;
        		
        		if(num%2 == 1) 
        			map[i][j] = 1;
        		num /= 2;
        		j--;
        	}
        }
        
        for(int i=0; i<n; ++i) {
        	StringBuilder sb = new StringBuilder();
        	for( int j=0; j<n; ++j) {
        		if(map[i][j]== 0) sb.append(" ");
        		else sb.append("#");
        	}
        	answer[i] = sb.toString();
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 5;
		int[] a1 = {9,20,28,18,11};
		int[] a2 = {30,1,21,17,28};
		System.out.println(Arrays.toString(solution(n,a1,a2)));
	}
}
