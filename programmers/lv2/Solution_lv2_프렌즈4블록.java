package lv2;
// https://programmers.co.kr/learn/courses/30/lessons/17679
// 성공

import java.util.ArrayList;

public class Solution_lv2_프렌즈4블록 {
	public static int cnt;
	public static int solution(int m, int n, String[] board) {
        cnt = 0;
        char[][] map = new char[m][n];
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[i].length(); j++) {
        		map[i][j] = board[i].charAt(j);
        	}
        }
        
        ArrayList<int[]> four_blocks = new ArrayList<int[]>();
        
        while(true) {
        	four_blocks = check4Blocks(m,n,map);
        	if(four_blocks.size() == 0) break;
            deleteBlocks(four_blocks,map);
            pushDownMap(m,n,map);
        }
        
        return cnt;
    }
	
	private static void pushDownMap(int m, int n, char[][] map) {
		for(int i=0; i<n; i++){
			int curr = -1;
			for(int j=m-1; j>=0; j--) {
				if(curr == -1 && map[j][i] == '-') {
					curr = j;
				}else if (curr > 0 && map[j][i] != '-') {
					char temp = map[j][i];
					map[j][i] = map[curr][i];
					map[curr][i] = temp;
					j = curr;
					curr = -1;
				}
			}
		}
	}

	private static void deleteBlocks(ArrayList<int[]> four_blocks, char[][] map) {
		for(int i=0; i<four_blocks.size(); i++) {
			int ci = four_blocks.get(i)[0];
			int cj = four_blocks.get(i)[1];
			if(map[ci][cj] != '-') {
				map[ci][cj] = '-';
				cnt++;
			}
			if(map[ci+1][cj] != '-') {
				map[ci+1][cj] = '-';
				cnt++;
			}
			if(map[ci][cj+1] != '-') {
				map[ci][cj+1] = '-';
				cnt++;
			}
			if(map[ci+1][cj+1] != '-') {
				map[ci+1][cj+1] = '-';
				cnt++;
			}
		}
	}

	private static ArrayList<int[]> check4Blocks(int m, int n, char[][] map) {
		ArrayList<int[]> temp = new ArrayList<int[]>();
		for(int i=0; i<m-1; i++) {
        	for(int j=0 ; j<n-1; j++) {
        		if(map[i][j] == '-') continue;
        		if(map[i][j] == map[i+1][j] && 
        			map[i][j] == map[i][j+1]&&
        			map[i][j] == map[i+1][j+1]) {
        			temp.add(new int[] {i,j});
        		}
        	}
        }
		return temp;
	}

	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		String[] board = {"TTTANT", 
						  "RRFACC", 
						  "RRRFCC", 
						  "TRRRAA",
						  "TTMMMF",
						  "TMMTTJ"}; 
		System.out.println("정답은 ["+solution(m,n,board)+"]");
	}
	
}
