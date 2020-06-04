package lv2;

import java.util.*;

/* 2020-06-04
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 * 
 * bfs
 * 
 * picture를 처음부터 순회하면서 0일때 패스, 숫자일때마다 bfs를 돈다.
 * 돌면서 탐색하는 count를 세주어 counts에 저장해주고
 * 같은 숫자이면서, 방문하지 않았던 곳만 수를 더하면서 탐색한다.
 * 모든 picture를 돌고나서 counts list를 정렬해주고,
 * counts.size()와 counts 맨 뒷 값을 리턴한다.
 * */
public class Solution_카카오프렌즈_컬러링북 {
	public static int[] solution(int m, int n, int[][] picture) {
        
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> q = new LinkedList<int[]>();
        ArrayList<Integer> counts = new ArrayList<Integer>();
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};
        
        for(int i=0 ; i<m; ++i) {
        	for (int j=0; j<n; ++j) {
        		if(picture[i][j]== 0) continue;
        		if(visit[i][j]) continue;
        		q = new LinkedList<int[]>();
        		visit[i][j] = true;
        		q.offer(new int[] {i,j ,picture[i][j]});
        		int cnt = 1;
        		while(!q.isEmpty()) {
        			int[] curr = q.poll();
        			for(int d=0; d<4; ++d) {
        				int ii= curr[0] + di[d];
        				int jj= curr[1] + dj[d];
        				if(ii < 0 || jj < 0 || ii >= m || jj >= n) continue;
        				if(visit[ii][jj] || picture[ii][jj] == 0) continue;
        				if(picture[ii][jj] != curr[2]) continue;
        				
        				visit[ii][jj] = true;
        				q.offer(new int[] {ii,jj, picture[ii][jj]});
        				cnt++;
        			}
        		}
        		counts.add(cnt);
        	}
        }
        
        System.out.println(counts);
        Collections.sort(counts);
        
        
        int[] answer = new int[2];
        answer[0] = counts.size();
        answer[1] = counts.get(counts.size()-1);
        return answer;
    }
	
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int p[][] = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(Arrays.toString(solution(m,n,p)));
	}
}
