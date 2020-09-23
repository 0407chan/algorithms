package lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// https://programmers.co.kr/learn/courses/30/lessons/42578
// 성공

public class Solution_lv2_위장 {
	public static int solution(String[][] clothes) {
        Map<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
        for(int i=0; i<clothes.length; i++) {
        	ArrayList<String> temp = new ArrayList<String>();
        	temp = m.get(clothes[i][1]);
        	if(temp == null) {
        		temp = new ArrayList<String>();
        	}
        	temp.add(clothes[i][0]);
        	m.put(clothes[i][1],temp);
        }
        int mul = 1;
        
        for (Entry<String, ArrayList<String>> entry : m.entrySet()) {
            ArrayList<String> value = entry.getValue();
            mul *= (value.size()+1);
        }
        return mul-1;
    }
	
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
//		String[][] clothes = {{"11", "1"},{"12", "1"}, {"21", "2"},{"22", "2"},{"23", "2"}, {"31", "3"},{"32", "3"}};
		System.out.println("정답은 ["+solution(clothes)+"]");
	}
}
