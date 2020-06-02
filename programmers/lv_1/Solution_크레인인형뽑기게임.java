package lv_1;

import java.util.Arrays;
import java.util.Stack;

/* 2020-06-02 화요일
 * https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
 * 
 * stack을 이용해 새로 들어오는 것과, 가장 마지막에 넣은 것을 비교해서 answer를 2씩 추가해주고 pop해준다.
 * 
 * 관건은 map에서 1번 줄에서 가장 밑에 있는 인형에 바로 도달 하는 것이다.
 * 이걸 0이 아닌 것을 계속 찾아 내려 가면 효율성에 문제가 생길 수 있다.
 * 그래서 초반에 map에 board를 쭉 탐색하면서 각 줄에 첫번째에 있는 위치를 저장해두고 접근해서 바로바로 가게 하자
 * */

public class Solution_크레인인형뽑기게임 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> s = new Stack<Integer>();
        int map[] = new int[N];
        Arrays.fill(map, N);
        for(int j=0; j<N; ++j) {
        	for (int i=0; i<N; ++i) {
        		if(board[i][j] != 0) {
        			map[j] = i;
        			break;
        		}
        	}
        }
        
        for(int i=0; i<moves.length; ++i) {
        	int ii = map[moves[i]-1];
        	int jj = moves[i]-1;
        	
        	if(ii >= N) continue;
        	if(s.size() == 0) {
        		s.add(board[ii][jj]);
        		map[moves[i]-1]++;
            	board[ii][jj]=0;
    	    	continue;
        	}
        	
        	if(board[ii][jj] == s.peek()) {
        		answer+= 2;
        		s.pop();
        	}else {
	        	s.push(board[ii][jj]);
        	}
        	map[moves[i]-1]++;
        	board[ii][jj]=0;
        }
        return answer;
    }
    
    public static void main(String[] args) {
      int[][] b = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
      int[] m = {1,5,3,5,1,2,1,4};
      
      System.out.println(solution(b,m));
   }
}