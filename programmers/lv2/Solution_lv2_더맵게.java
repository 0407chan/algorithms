package lv2;

import java.util.PriorityQueue;

/* 2020-06-24
 * 제일 작은거 2개를 스코필 지수 계산 방법으로 계속 계산하면서 체크하면 된다.
 * 제일 작은거를 찾기위해 우선순위 큐를 이용했다
 * */

public class Solution_lv2_더맵게 {
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; ++i) {
        	q.add(scoville[i]);
        }
        while(q.peek()<K && q.size() >1) {
        	int num1 = q.poll();
        	int num2 = q.poll();
        	
        	q.add(num1+num2*2);
        	
        	answer++;
        }
        
        if(q.size() <=1 && q.peek() < K) 
        	answer = -1;
        
        return answer;
    }
	public static void main(String[] args) {
		int[] scoville = {1,1,1,1};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
}
