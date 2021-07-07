package Programmers.Level1;

import java.util.Arrays;

public class Level1_12917_문자열내림차순으로배치하기 {

	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));
	}
	
	public static String solution(String s) {
		String answer = "";
		
		char[] arr = new char[s.length()];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = s.charAt(i);
		}
		Arrays.sort(arr);
		
		for(int i = arr.length-1; i >= 0; i--) {
			answer += arr[i];
		}
		
		return answer;
	}

}
