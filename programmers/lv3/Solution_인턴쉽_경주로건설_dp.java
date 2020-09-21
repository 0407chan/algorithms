package lv3;

import java.util.*;

/* 2020-09-09 수요일
 * */
public class Solution_인턴쉽_경주로건설_dp {
	
	public static boolean[][] visit;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static int[][] dp;
	public static int N,min;
	public static Queue<int[]> q;

	
	public static int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        min = Integer.MAX_VALUE;
        q = new LinkedList<int[]>();
        visit = new boolean[N][N];
        dp = new int[N][N];
        visit[0][0] = true;
        q.add(new int[]{0,0,-1,-1,0});

        bfs(board);
        answer = min;
        return answer;
    }
	
	public static void bfs(int[][] map) {
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0; d<4; d++) {
				int ii= curr[0] + di[d];
				int jj= curr[1] + dj[d];
				if(ii < 0 || jj < 0 || ii >= N || jj >= N || map[ii][jj]==1) continue;
				
				// 끝에 도달했으면
				if(ii == N-1 && jj == N-1) {
					if(Math.abs(curr[2] - ii) == 2 || Math.abs(curr[2] - ii) == 0) {
						min = Math.min(min, curr[4]+100);
					}else {
						min = Math.min(min, curr[4]+600);
					}
				}
				
				if(Math.abs(curr[2] - ii) == 2 || Math.abs(curr[2] - ii) == 0) {
					if(dp[ii][jj] > 0 && curr[4]+100 > dp[ii][jj]) continue;
				}else {
					if(dp[ii][jj] > 0 && curr[4]+600 > dp[ii][jj]) continue;
				}
				
				//직선이동일때 preI - ii 해서 2 or -2 or 0나오면 직선 이동한거
				visit[ii][jj] = true;
				int newCost = curr[4];
				
				if(curr[2] == -1 && curr[3] == -1) {
					dp[ii][jj]=curr[4]+100;
					q.add(new int[] {ii,jj,0,0,curr[4]+100});
					continue;
				}
				
				if(Math.abs(curr[2] - ii) == 2 || Math.abs(curr[2] - ii) == 0) {
					newCost += 100;
					if(dp[ii][jj] == 0 || dp[ii][jj] >= newCost) {
						dp[ii][jj] = newCost;
						q.add(new int[] {ii,jj,curr[0],curr[1],newCost});
					}
				}
				//옆으로 꺾었을때 preI - ii 해서 1 or -1나오면 꺾은거
				else if(Math.abs(curr[2] - ii) == 1) {
					newCost += 600;
					if(dp[ii][jj] == 0 || dp[ii][jj] >= newCost) {
						dp[ii][jj] = newCost;
						q.add(new int[] {ii,jj,curr[0],curr[1],newCost});
					}
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		int map[][] = {{0,0,0,0,0,0,0,1},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,1,0,0},
				{0,0,0,0,1,0,0,0},
				{0,0,0,1,0,0,0,1},
				{0,0,1,0,0,0,1,0},
				{0,1,0,0,0,1,0,0},
				{1,0,0,0,0,0,0,0}};
		
		System.out.println(solution(map));
	}
}
