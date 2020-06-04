package algorithms;

import java.util.Scanner;

public class Main2798_블랙잭 {
	public static int ans,min;
	public static boolean visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ans = 0;
		min = Integer.MAX_VALUE;
		int N = sc.nextInt();
		int sum = sc.nextInt();
		int nums[] = new int[N];
		visit = new boolean[N];
		for(int i=0 ; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		solve(nums,0,0,sum);
		System.out.println(ans);
	}

	private static void solve(int[] nums, int count, int num,int sum) {
		if(count > 3 || num > sum) return;
		if(ans == sum) return;
		if(count == 3 ) {
			if(num <= ans) return;
			if(min > Math.abs(num-sum)) {
				min = Math.abs(num-sum);
				ans = num;
			}
		}
		
		for(int i=0; i<nums.length; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			++count;
			solve(nums,count,num+nums[i],sum);
			count--;
			visit[i] = false;
		}
	}
}
