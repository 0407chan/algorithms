package lv1;

import java.util.*;

// 2020-09-24
// https://programmers.co.kr/learn/courses/30/lessons/68644
// 성공

public class Solution_lv1_두개뽑아서더하기 {
	public static int[] solution(int[] numbers) {
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        Map<Integer, Boolean> m = new HashMap<Integer, Boolean>();
        
        for(int i=0; i<numbers.length; i++) {
        	for(int j=0; j<numbers.length; j++) {
        		if(i==j)continue;
        		int sum = numbers[i] + numbers[j];
        		if(m.get(sum)==null) {
        			m.put(sum,true);
        			a.add(sum);
        		}
        	}
        }
        Collections.sort(a);
        int[] ans = new int[a.size()];
        for(int i=0; i<a.size(); i++) {
        	ans[i] = a.get(i);
        }
        
        return ans;
    }

	public static void main(String[] args) {
		int[] numbers = {5,0,2,7};
		System.out.println("정답은 ["+Arrays.toString(solution(numbers))+"]");
	}
}
