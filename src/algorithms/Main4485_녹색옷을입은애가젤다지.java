package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main4485_녹색옷을입은애가젤다지 {
	public static int N;
	public static int[][] map;
	public static int[] di = {-1,1, 0,0};
	public static int[] dj = {0, 0,-1,1};
	
	public static class node implements Comparable<Integer>{
		int i;
		int j;
		int cnt;
		
		public node(int ii, int jj, int cntt){
			i = ii;
			j = jj;
			cnt = cntt;
		}

		@Override
		public int compareTo(Integer o) {
			return Integer.compare(cnt,o);
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 0;
//		while(true) {
//			N = Integer.parseInt(br.readLine());
//			if(N== 0) break;
			tc++;
			map = new int[N][N];
			PriorityQueue<int[]> q = new PriorityQueue<>();
			int ans[][] = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String s[] = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			q.add(new int[] {4,2,3});
			q.add(new int[] {3,2,3});
			q.add(new int[] {2,2,3});
			q.add(new int[] {1,2,3});
			for(int i=0; i<q.size();i ++) {
				System.out.println(q.poll());
			}
			
			System.out.println("Problem "+tc+": "+ans[N-1][N-1]);
//		}
	}
	
}
