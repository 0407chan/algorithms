package lv2;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/60058
// 

public class Solution_lv2_괄호변환 {
	public static String solution(String p) {
		if(p.length()==0) return "";
		String u = "";
		String v = "";
		int cnt = 0;
		
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == '(') cnt++;
			else if(p.charAt(i)== ')') cnt--;
			
			if(i > 0 && cnt ==0 ) {
				u = p.substring(0,i+1);
				v = p.substring(i+1);
				break;
			}
		}
		
		if(isPerfect(u)) {
			return u + solution(v);
		}else {
			StringBuilder sb = new StringBuilder();
			String newV = solution(v);
			String newU = u.substring(1,u.length()-1);
			newU = oppositeString(newU);
			sb.append("(").append(newV).append(")").append(newU);
			return sb.toString();
		}
    }
	
	private static String oppositeString(String newU) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<newU.length(); i++) {
			char curr = newU.charAt(i);
			if(curr == '(') sb.append(')');
			else sb.append('(');
		}
		return sb.toString();
	}

	private static boolean isPerfect(String u) {
		Stack<Character> s = new Stack<Character>();
		for(int i=0; i<u.length(); i++) {
			char curr = u.charAt(i);
			if(curr == '(') {
				s.push(curr);
			}else if(curr == ')') {
				if(s.size() == 0) return false;
				s.pop();
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String p = ")(";
		System.out.println("정답은 ["+solution(p)+"]");
	}
}
