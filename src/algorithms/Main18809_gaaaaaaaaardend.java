package algorithms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/** 심을 수 있는 땅에 초록색이랑 빨강색 투하.
 * 땅 조합하고, 그 안에서 배양액 중복 조합으로 투하?
 * 
 * */

public class Main18809_gaaaaaaaaardend {
	static int N,M,G,R,MAX, landIndex, numLand;
	static int[][] map;
	static int[] goodland;
	static ArrayList<int[]> a;
	static Queue<int[]> q;
	static int[][] visit;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/main18809.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		N = Integer.parseInt(s[0]); 
		M = Integer.parseInt(s[1]);
		G = Integer.parseInt(s[2]); 
		R = Integer.parseInt(s[3]);
		map = new int[N][M];
		visit = new int[N][M];
		q = new LinkedList<>();
		landIndex = 0;
		numLand = 0;
		a = new ArrayList<>();
		// 0 호수
		// 1 배양액 못 뿌림
		// 2 배양액 뿌림
		// 3 G
		// 4 R
		// 5 꽃핌
		for(int i=0; i<N; ++i) {
			for(int j=0; j<M-1; ++j) {
				map[i][j] = br.read()-'0';
				br.read();
				if(map[i][j] == 2) {
					a.add(new int[] {i,j});
				}
			}
			map[i][M-1] = Integer.parseInt(br.readLine());
			if(map[i][M-1] == 2) {
				a.add(new int[] {i,M-1});
			}
		}
		
		permute(0, a.size()-1);
		System.out.println(MAX);
	}
	
	
	
	private static void permute(int l, int r) 
    { 
        if (l == r) { 
        	
//            for(int i=0; i<a.size(); i++) {
//            	System.out.println(Arrays.toString(a.get(i)));
//            }
            int tmap[][] = new int[N][M];
            numLand = 0;
            for(int i=0; i<N; i++) {
            	for(int j=0; j<M; j++) {
            		if(map[i][j] == 2) numLand++;
            		tmap[i][j] = map[i][j];
            	}
            }
            visit = new int[N][M];
            q = new LinkedList<>();
            setWater(tmap);
            int tcnt = bfs(tmap);
            
            MAX = Math.max(MAX, tcnt);
        }
        else { 
            for (int i = l; i <= r; i++) { 
                swap(l, i); 
                permute(l + 1, r); 
                swap(l, i); 
            } 
        } 
    }


	private static int bfs(int[][] tmap) {
		int cnt = 0;
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			if(tmap[curr[0]][curr[1]]== 5) continue;
			for (int d =0; d<4; d++) {
				int ii = curr[0] + di[d];
				int jj= curr[1] + dj[d];
				if(ii < 0 || jj< 0|| ii >= N|| jj >= M)continue;
				if(tmap[ii][jj] == 0 || tmap[ii][jj] == 5) continue;
				if(curr[2] == 3 && tmap[ii][jj] == 3) continue;
				if(curr[2] == 4 && tmap[ii][jj] == 4) continue;
				
				if(visit[ii][jj] == 0) {
					visit[ii][jj] = visit[curr[0]][curr[1]]+1;
					q.add(new int[] {ii,jj,curr[2],curr[3]+1});
					if(curr[2] == 3) {
						tmap[ii][jj] = 3;
					}else if(curr[2] == 4) {
						tmap[ii][jj] = 4;
					}
				}else if( visit[ii][jj] == curr[3]+1) {
					if((curr[2] == 3 && tmap[ii][jj] == 4)|| (curr[2] == 4 && tmap[ii][jj] ==3)) {
						tmap[ii][jj] = 5;
						visit[ii][jj] = visit[curr[0]][curr[1]]+1;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}



	private static void setWater(int[][] tmap) {
		int tG = G; // 3
		int tR = R; // 4
		for(int i=0; i<a.size(); i++) {
			if(tR == 0 && tG == 0) break;
			int curr[] = a.get(i);
			visit[curr[0]][curr[1]] = 1;
			if(tG > 0) {
				tmap[curr[0]][curr[1]] = 3;
				q.offer(new int[] {curr[0],curr[1],3,1});
				tG--;
			}else if (tR > 0) {
				tmap[curr[0]][curr[1]] = 4;
				q.offer(new int[] {curr[0],curr[1],4,1});
				tR--;
			}
			if(q.size() == numLand) break;
		}
	}



	private static void swap(int l, int i) {
		int[] temp = a.get(i);
		a.set(i, a.get(l));
		a.set(l, temp);
	}
}
