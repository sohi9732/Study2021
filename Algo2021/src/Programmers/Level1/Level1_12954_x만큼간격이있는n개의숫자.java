package Programmers.Level1;

import java.util.Arrays;

public class Level1_12954_x만큼간격이있는n개의숫자 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(2, 5)));
		System.out.println(Arrays.toString(solution(4, 3)));
		System.out.println(Arrays.toString(solution(-4, 2)));
	}
	
	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		answer[0] = x;
		
		for(int i = 1; i < n; i++) {
			answer[i] = answer[i-1] + x;
		}
		
		return answer;
	}

}
