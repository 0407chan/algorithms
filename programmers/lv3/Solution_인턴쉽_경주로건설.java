package lv3;

import java.util.PriorityQueue;

/* 2020-09-09 수요일
 * */
public class Solution_인턴쉽_경주로건설 {
	
	public static PriorityQueue<node> q;
	public static boolean[][] visit;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static int[][] cmap;
	public static int N;
	
	public static class node implements Comparable<node>{
		int i;
		int j;
		int preI;
		int preJ;
		int cost;
		
		public node(int i, int j, int preI, int preJ, int cost) {
			this.i = i;
			this.j = j;
			this.preI = preI;
			this.preJ = preJ;
			this.cost = cost;
		}
		
		public int getI() {
			return i;
		}
		public int getJ() {
			return j;
		}
		
		public int getPreI() {
			return preI;
		}

		public int getPreJ() {
			return preJ;
		}

		public int getCost() {
			return cost;
		}

		@Override
		public int compareTo(node n) {
			if(this.getCost() > n.getCost()) {
	            return 1;
	         }else if(this.getCost() < n.getCost()) {
	            return -1;
	         }
	         return 0;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[i=");
			builder.append(i);
			builder.append(", j=");
			builder.append(j);
			builder.append(", preI=");
			builder.append(preI);
			builder.append(", preJ=");
			builder.append(preJ);
			builder.append(", cost=");
			builder.append(cost);
			builder.append("]");
			return builder.toString();
		}
		
		
	}
	
	public static int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        q = new PriorityQueue<node>();
        visit = new boolean[N][N];
        cmap = new int[N][N];
        visit[0][0] = true;
        q.add(new node(0,0,-1,-1,0));
        answer = bfs(board);
        return answer;
    }
	
	public static int bfs(int[][] map) {
		int ans = 0;
		while(!q.isEmpty()) {
			node curr = q.poll();
			for(int d=0; d<4; d++) {
				int ii= curr.getI() + di[d];
				int jj= curr.getJ() + dj[d];
				if(ii < 0 || jj < 0 || ii >= N || jj >= N || visit[ii][jj] ||map[ii][jj]==1) continue;
				
				// 끝에 도달했으면
				if(ii == N-1 && jj == N-1) {
					if(Math.abs(curr.getPreI() - ii) == 2 || Math.abs(curr.getPreI() - ii) == 0)
						ans = curr.getCost() + 100;
					else if(Math.abs(curr.getPreI() - ii) == 1) 
						ans = curr.getCost() + 600;
					return ans;
				}
				//직선이동일때 preI - ii 해서 2 or -2 or 0나오면 직선 이동한거
				visit[ii][jj] = true;
				int newCost = curr.getCost();
				if(curr.getPreI() == -1 && curr.getPreJ() == -1) {
					cmap[ii][jj]=curr.getCost()+100;
					q.add(new node(ii,jj,0,0,curr.getCost()+100));
					continue;
				}
				if(Math.abs(curr.getPreI() - ii) == 2 || Math.abs(curr.getPreI() - ii) == 0)
					newCost += 100;
				//옆으로 꺾었을때 preI - ii 해서 1 or -1나오면 꺾은거
				else if(Math.abs(curr.getPreI() - ii) == 1) newCost += 600;
				
				cmap[ii][jj] = newCost;
				q.add(new node(ii,jj,curr.getI(),curr.getJ(),newCost));
				
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int map[][] = {{0,0,0,0,0,0,0,1},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,1,0,0},
				{0,0,0,0,1,0,0,0},
				{0,0,0,1,0,0,0,1},
				{0,0,1,0,0,0,1,0},
				{0,1,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,0}};
		
		System.out.println(solution(map));
	}
}
