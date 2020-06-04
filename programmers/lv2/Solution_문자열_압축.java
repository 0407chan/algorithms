package lv2;

public class Solution_문자열_압축 {
	
	public static int solution(String s) {
        int answer = 0;
        if(s.length() == 1 ) return 1;
        
        for(int i=0; i<s.length()/2; ++i) {
        	for(int j=1; j<i+1; ++j) {
        		
        	}
        }
     
        return answer;
    }
	
	public static void main(String[] args) {
		String s= "ababcdcdababcdcd";
		System.out.println(solution(s));
	}
}
