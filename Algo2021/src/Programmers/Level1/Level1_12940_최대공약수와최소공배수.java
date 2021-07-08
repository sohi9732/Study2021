package Programmers.Level1;

import java.util.Arrays;

public class Level1_12940_최대공약수와최소공배수 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, 12)));
		System.out.println(Arrays.toString(solution(2, 5)));
	}
	
	public static int[] solution(int n, int m) {
		int[] answer = new int[2];
		
		if(m < n) {
			int tmp = m;
			m = n;
			n = tmp;
		}
		
		for(int i = n; i > 0; i--) {
			if(n%i == 0 && m%i == 0) {
				answer[0] = i;
				break;
			}
		}
		
		int a = n/answer[0];
		int b = m/answer[0];
		answer[1] = answer[0]*a*b;
		
		return answer;
	}

}
