import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution1249_보급로 {
	public static int map[][];
	public static PriorityQueue<node> q;
	public static boolean[][] visit;
	public static int N;
	public static int di[] = {-1,1,0,0};
	public static int dj[] = {0,0,-1,1};
	
	public static class node implements Comparable<node>{
		int i;
		int j;
		int cost;
		
		public int getI() {
			return i;
		}

		public int getJ() {
			return j;
		}

		public node(int i, int j, int cost) {
			super();
			this.i = i;
			this.j = j;
			this.cost = cost;
		}

		public int getCost() {
			return cost;
		}

		@Override
		public int compareTo(node o) {
			if(this.getCost() > o.getCost()) {
				return 1;
			}else if(this.getCost() < o.getCost()) {
				return -1;
			}
			return 0;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/input1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; ++tc) {
			int ans = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean [N][N];
			q = new PriorityQueue<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-1; j ++) {
					map[i][j] = br.read()-'0';
				}
				map[i][N-1] = Integer.parseInt(br.readLine());
			}
			
			visit[0][0] = true;
			q.offer(new node(0,0,map[0][0]));
			ans = bfs();
					
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static int bfs() {
		int ans = 0;
		while(!q.isEmpty()) {
			node curr = q.poll();
			for(int d=0; d<4; d++) {
				int ii = curr.getI() + di[d];
				int jj = curr.getJ() + dj[d];
				if(ii<0 || jj<0|| ii>=N|| jj>= N|| visit[ii][jj]) continue;
				
				if(ii == N-1 && jj == N-1) {
					return curr.getCost() + map[N-1][N-1];
				}
				
				visit[ii][jj] = true;
				q.offer(new node(ii,jj,curr.getCost()+map[ii][jj]));
			}
		}
		return ans;
		
	}
}
