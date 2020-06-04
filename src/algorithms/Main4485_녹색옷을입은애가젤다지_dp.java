package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main4485_녹색옷을입은애가젤다지_dp {
	public static int N,ans,min,fullcount;
	public static boolean[][] visit;
	public static int[][] map;
	public static int[] di = {-1,1, 0,0};
	public static int[] dj = {0, 0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N== 0) break;
			tc++;
			min = (N*2-1)*9+1;
			fullcount = (N*2-1);
			ans = 0;
			visit = new boolean[N][N];
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String s[] = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			visit[0][0] = true;
			dfs(0,0,map[0][0], 0);
			
			System.out.println("Problem "+tc+": "+min);
		}
	}
	
	private static void dfs(int si, int sj, int sum, int count) {
		if(sum > min) return;
		if(count >= fullcount) return;
		int[] curr = {si,sj};
		
		for(int d=0; d<4; d++) {
			int ii = curr[0] +di[d];
			int jj = curr[1] +dj[d];
			if(ii <0 || ii >= N || jj <0 || jj >= N || visit[ii][jj]) continue;
			if(count == fullcount-1) {
				if(ii != N-1 || jj != N-1) return;
			}
			
			if(ii == N-1 && jj== N-1) {
				sum += map[ii][jj];
				if(sum < min) {
					min = sum;
					return;
				}
			}
			visit[ii][jj] = true;
			dfs(ii,jj,sum+map[ii][jj],count+1);
			visit[ii][jj] = false;
		}
	}
}
