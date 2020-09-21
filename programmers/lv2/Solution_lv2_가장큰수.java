package lv2;

import java.util.*;

public class Solution_lv2_가장큰수 {
	public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        ArrayList<String> a = new ArrayList<String>();
        for(int i=0; i<numbers.length; i++) {
        	a.add(numbers[i]+"");
        }
        System.out.println("정렬 전 "+a);
        Collections.sort(a, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				System.out.println(arg0+" "+arg1);
				int i = 0;
				int j = 0;
				while(true) {
					
					if(arg0.length()== arg1.length() && arg0.length()== i) {
						return 0;
					}
					if(arg0.length() == i) i--;
					if(arg1.length() == j) j--;
					
					if(i < j) {
						if(arg0.charAt(0) < arg1.charAt(j)) {
							return -1;
						}else if(arg0.charAt(0) > arg1.charAt(j)){
							return 1;
						}else
							return 0;
					}
					else if(i > j) {
						if(arg0.charAt(i) > arg1.charAt(0)) {
							return 1;
						}else if(arg0.charAt(i) < arg1.charAt(0)) {
							return -1;
						}else
							return 0;
					}
					
					if(arg0.charAt(i) == arg1.charAt(j)) {
						i++;
						j++;
						continue;
					}else if(arg0.charAt(i) < arg1.charAt(j)) {
						return -1;
					}else if(arg0.charAt(i) > arg1.charAt(j)) 
						return 1;
				}
			}
		});
        System.out.println("정렬 후 "+a);
        for(int i=a.size()-1; i>=0 ; i--) {
        	answer.append(a.get(i));
        }
        if(Integer.parseInt(answer.toString()) == 0) {
        	return "0";
        }
        
        return answer.toString();
    }
	public static void main(String[] args) {
		//int[] numbers = {10,11,12,13,14,15,1111,1001,1999,100,1,1130,2,102};
//		int[] numbers = {5,55,505,5005,5003,5007,507,503,57,53,7,3};
		int[] numbers = {200,20,2};
		System.out.println(solution(numbers));
	}
	
}
