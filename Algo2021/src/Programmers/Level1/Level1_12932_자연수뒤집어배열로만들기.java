package Programmers.Level1;

import java.util.Arrays;

public class Level1_12932_자연수뒤집어배열로만들기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(12345)));
	}
	
	public static int[] solution(long n) {
		String number = Long.toString(n);
		int[] answer = new int[number.length()];
		int index = 0;
		
		for(int i = 0; i < answer.length; i++) {
			answer[i] = number.charAt((answer.length-(i+1)))-'0';
		}
		
		return answer;
	}

}
