package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main7576_토마토 {
	public static int N,M,ans;
	public static boolean[][] visit;
	public static Queue<int[]> q;
	public static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String init[] = br.readLine().split(" ");
		
		M = Integer.parseInt(init[0]);
		N = Integer.parseInt(init[1]);
		q = new LinkedList<>();
		visit = new boolean[N][M];
		ans = 0;
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String s[] = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j] == 1) {
					q.add(new int[] {i,j});
				}
			}
		}
		bfs();
		if(!check()) {
			ans = -1;
		}else {
			ans--;
		}
		System.out.println(ans);
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int[] di = {-1,1, 0,0};
			int[] dj = {0, 0,-1,1};
			for(int d=0; d<4; d++) {
				int ii = curr[0] +di[d];
				int jj = curr[1] +dj[d];
				if(ii <0 || ii >= N || jj <0 || jj >= M) continue;
				if(map[ii][jj] == -1 || map[ii][jj] >= 1 ) continue;
				
				map[ii][jj] = map[curr[0]][curr[1]] + 1;
				q.add(new int[] {ii,jj});
			}
		}
	}
	private static boolean check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] > ans) {
					ans = map[i][j];
				}
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
