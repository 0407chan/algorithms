package algorithms;

import java.util.Scanner;

/*
 * 화살표 방향으로만 이동 가능
 * 파란색 칸에서 파란색 화살표 방향으로 이동 가능
 * 파란색 칸을 그냥 지나면 빨간색 칸으로
 * 이동하려는 칸에 말이 있는 경우 이동 불가
 * 시작과 도착칸에 말이 있어도 이동 가능
 * 말이 이동을 마칠 때마다 칸에 적힌 수가 점수에 추가
 * "도착"에 도달하면 더이상 이동 불가.
 * 이동하려는 칸이 "도착"을 넘어가도 도착에서 멈춤.
 * 주사위 10개 미리 알 고 있을 때 얻는 점수의 최대값
 * 
 * 풀이 :
 * 주사위를 n번을 1,2,3,4 번 말이 순서대로 가보면 된다.
 * 1이 n번 다 가는 경우의 수, 1이 n-3번 가고 2가 1번, 3이 1번 4가 1번.
 * 완탐 돌려야되겠는데?
 * 
 * */
public class Main17825_주사위윷놀이 {
	public static int mapStart[]= 
							{0,2,4,6,8,10,
							12,14,16,18,20,
							22,24,26,28,30,
							32,34,36,38,40,
							41};
	public static int[] map10 = {10,13,16,19,25,30,35,40,41};
	public static int[] map20 = {20,22,24,25,30,35,40,41};
	public static int[] map30 = {30,28,27,26,25,30,35,40,41};
	public static boolean visit[];
	public static void main(String[] args) {
		visit = new boolean[42];
		int dol[] = new int[4];
		Scanner sc = new Scanner(System.in);
		int nums[] = new int[10];
		for(int i=0; i<10; i++) {
			nums[i] = sc.nextInt();
		}
		
		solve(nums,0,dol);
	}
	
	private static void solve(int[] nums, int count, int[] dol) {
		if(count > 10) return;
		
		for(int i=0; i<4; i++) {
			
		}
	}

	public static int move(int num) {
		
		return num;
	}
}
