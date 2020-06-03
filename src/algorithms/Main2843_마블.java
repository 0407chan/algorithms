package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2843_마블 {
	public static int node[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		node = new int[N+1];
		String s[] = br.readLine().split(" ");
		
		for(int i=0; i<=N; i++) {
			node[i] = i;
		}
		for(int i=0; i<N; i++) {
			union(i+1,Integer.parseInt(s[i]));
		}
		System.out.println(Arrays.toString(node));
		int Q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<Q; i++) {
			String ss[] = br.readLine().split(" ");
			int state = Integer.parseInt(ss[0]);
			int curr = Integer.parseInt(ss[1]);
			if(state==2) {
				node[curr] = -1;
				continue;
			}
		}
		System.out.println(sb.toString());
		
	}
	
	private static int find(int x) {
		if(node[x]==x){
			return x;
		}else {
			return node[x] = find(node[x]);
		}
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		node[y] = x;
	}
}
