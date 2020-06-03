package algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution9282_초콜릿과건포도 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			Map<String, Integer> map = new HashMap<>();
			int choco[][] = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					choco[i][j] = sc.nextInt();
				}
			}
			
			solve(0,N+1,0,M+1,choco,map);
			
			for (int[] is : choco) {
				System.out.println(Arrays.toString(is));
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}

	private static int solve(int cs, int ce, int rs, int re, int[][] choco, Map<String, Integer> map) {
		if(Math.abs(cs-ce)==1 && Math.abs(rs-re)==1) {
			return choco[cs][rs];
		}
		
		
		return re;
	}
}
