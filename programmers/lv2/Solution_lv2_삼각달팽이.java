package lv2;

import java.util.Arrays;

// 2020-09-24
// https://programmers.co.kr/learn/courses/30/lessons/68645
// 성공

public class Solution_lv2_삼각달팽이 {
	public static int[] di = {1,0,-1};
	public static int[] dj = {0,1,-1};
	public static int[] solution(int n) {
        
        int map[][] = new int[n][n];
        int total = (1+n)*n / 2 ;
        int[] answer = new int[total];
        boolean[][] visit = new boolean[n][n];
        
        int i= -1;
        int j= 0;
        int curr = 1;
        int dir = 0;
        while(true) {
        	if(total < curr) break;
        	i += di[dir];
        	j += dj[dir];
        	if(i >= n || j >= n || i < 0 || j < 0 || visit[i][j]) {
        		i -= di[dir];
            	j -= dj[dir];
        		dir++;
        		if(dir > 2) dir = 0;
        		continue;
        	}
        	visit[i][j] = true;
        	map[i][j] = curr;
        	curr++;
        }
        curr = 0;
        for(int ii=0; ii<n; ii++) {
        	for (int jj=0; jj<n; jj++) {
        		if(map[ii][jj] == 0 )continue;
        		answer[curr++] = map[ii][jj];
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		int n = 4;
		System.out.println("정답은 ["+Arrays.toString(solution(n))+"]");
	}
}
