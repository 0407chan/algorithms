package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//각 층이 회전 할 수 있어야하고,
//그걸 N층에 맞게 마음대로 조합해서 
//bfs 돌려가지고
//min값을 찾아내는 문제네
public class Main16985_Maaaaaaaaaze {
	public static int map[][][];
	public static int N,min;
	public static int count[];
	public static int permlist[];
	public static int di[] = {-1,1,0,0,0,0};
	public static int dj[] = { 0,0,-1,1,0,0};
	public static int dk[] = { 0,0,0,0,-1,0};
	public static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 3;
		min = 10000;
		map = new int[N][N][N];
		count = new int[N];
		permlist = new int[N];
		q = new LinkedList<int[]>();
		
		for(int i=0; i<N; i++) {
			permlist[i] = i;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				String s[] = br.readLine().split(" ");
				for(int k=0; k<N; k++) {
					map[i][j][k] = Integer.parseInt(s[k]);
				}
			}
		}
		
		//맨 위를 1번 돌림. 다시 제자리로 돌아오면, 그 다음거 돌림.
		permute(0, N-1);
		if(min== 10000) System.out.println(-1);
		else System.out.println(min);
		
//		for (int i=0; i<5; i++) {
//			for(int j=0; j<N; j++) {
//				for(int k=0; k<N; k++) {
//					System.out.print(map2[i][j][k]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
	}
	
	private static void permute(int l, int r) 
    { 
        if (l == r) { 
            //System.out.println(Arrays.toString(permlist)); 
        	//여기서 bfs 시작
        	int tmap[][][] = new int[N][N][N];
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<N; j++) {
        			for(int k=0; k<N; k++) {
        				tmap[permlist[i]][j][k] = map[i][j][k];
        			}
        		}
        		
        	}
        	boolean visit[][][] = new boolean[N][N][N];
        	
        	while(true) {
        		int a = 0;
        		if(tmap[0][0][0] != 0 && tmap[N-1][N-1][N-1]!=0) {
        			a = bfs(tmap,visit,0,0,  0,  N-1,N-1,N-1);
        			if(a != 0) min = Math.min(a, min);
        		}
        		if(tmap[0][N-1][0] != 0 && tmap[N-1][0][N-1]!=0) {
        			a = bfs(tmap,visit,0,N-1,0,  N-1,  0,N-1);
	        		if(a != 0) min = Math.min(a, min);
	    		}
        		if(tmap[0][0][N-1] != 0 && tmap[N-1][N-1][0]!=0) {
        			a = bfs(tmap,visit,0,0,N-1,  N-1,N-1,  0);
        			if(a != 0) min = Math.min(a, min);
        		}
        		if(tmap[0][N-1][N-1] != 0 && tmap[N-1][0][0]!=0) {
         			a = bfs(tmap,visit,0,N-1,N-1,N-1,  0,  0);
        			if(a != 0) min = Math.min(a, min);
        		}
        		
        		spin(tmap,0);
        		if(check(count)) break;
        	}
        }
        else { 
            for (int i = l; i <= r; i++) { 
                swap(l, i); 
                permute(l + 1, r); 
                swap(l, i); 
            } 
        } 
    } 

	private static boolean check(int[] count) {
		
		for(int i=0;i < count.length; i++) {
			if(count[i]!= 0) return false;
		}
		
		return true;
	}

	private static int bfs(int[][][] tmap, boolean[][][] visit, int si, int sj, int sk, int endi, int endj, int endk) {
		int ans = 0;
		visit[si][sj][sk] = true;
		q.add(new int[] {si,sj,sk,0});
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			for(int d= 0; d<6; d++) {
				//min 값도 가지고 가야함.
				int ii = curr[0] + di[d];
				int jj = curr[1] + dj[d];
				int kk = curr[2] + dk[d];
				if(ii < 0 || ii >= N || jj <0 || jj >= N || kk < 0 || kk >= N || visit[ii][jj][kk]) continue;
				
				if(ii == endi && jj== endj && kk == endk) {
					ans = curr[3] + 1;
					return ans;
				}
				
				if(tmap[ii][jj][kk]==1 && visit[ii][jj][kk] ==false) {
					visit[ii][jj][kk] = true;
					q.add(new int[] {ii,jj,kk,curr[3]+1});
				}
			}
		}
		return ans;
	}

	private static void swap(int l, int i) {
		int temp = permlist[i];
		permlist[i] = permlist[l];
		permlist[l] = temp;
	}

	private static void spin(int[][][] map, int line) {
		if(line >= N) return;
		
		int temp[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				temp[i][j] = map[line][i][j];
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[line][i][j] = temp[N-1-j][i];
			}
		}
		
		count[line]++;
		if(count[line] == 4) {
			count[line] = 0;
			spin(map,line+1);
		}
		
	}
}
