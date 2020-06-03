package lv2;

/* 2020-06-04 목요일
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 * 
 * 시뮬레이션 문제이다
 * 조건에 해당하는 범위가 무엇인지 잘 확인하는게 필요하다.
 * 점수 1~10
 * 보너스 S,D,T
 * 옵션 *, #
 * 각 조건에 해당하는 연산을 해주면 된다. 
 * */
public class Solution_1차_다트게임 {
	public static int solution(String s) {
        int answer = 0;
        int map[] = new int[3];
        int numIndex = 0;
        int charIndex = 0;
        for(int i=0; i<s.length(); ++i) {
        	switch(s.charAt(i)) {
        	case '0':
        		map[numIndex] = 0;
        		numIndex++;
        		break;
        	case '1':
        		if(s.charAt(i+1) == '0') {
        			map[numIndex] = 10;
        			i++;
            		numIndex++;
            		break;
        		}else {
        			map[numIndex] = 1;
            		numIndex++;
            		break;
        		}
        	case '2':
        		map[numIndex] = 2;
        		numIndex++;
        		break;
        	case '3':
        		map[numIndex] = 3;
        		numIndex++;
        		break;
        	case '4':
        		map[numIndex] = 4;
        		numIndex++;
        		break;
        	case '5':
        		map[numIndex] = 5;
        		numIndex++;
        		break;
        	case '6':
        		map[numIndex] = 6;
        		numIndex++;
        		break;
        	case '7':
        		map[numIndex] = 7;
        		numIndex++;
        		break;
        	case '8':
        		map[numIndex] = 8;
        		numIndex++;
        		break;
        	case '9':
        		map[numIndex] = 9;
        		numIndex++;
        		break;
        	case 'S':
        		charIndex++;
        		break;
        	case 'D':
        		map[charIndex] = sqr(2, map[charIndex]);
        		charIndex++;
        		break;
        	case 'T':
        		map[charIndex] = sqr(3, map[charIndex]);
        		charIndex++;
        		break;
        	case '*':
        		if(numIndex == 1) {
        			map[numIndex-1] *= 2;
        		}else {
        			map[numIndex-2] *= 2;
        			map[numIndex-1] *= 2;
        		}
        		break;
        	case '#':
        		map[numIndex-1] *= -1;
        		break;
        	}
        }
        for(int i=0; i<3; i++) {
        	answer += map[i];
        }
        return answer;
    }
	
	public static int sqr(int n, int num) {
		int ans = 1;
		for(int i=0; i<n; i++) {
			ans *= num;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String s = "1D2S#10S";
		System.out.println(solution(s));
	}
}
