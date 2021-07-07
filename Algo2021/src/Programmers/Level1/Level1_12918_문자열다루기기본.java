package Programmers.Level1;

public class Level1_12918_문자열다루기기본 {

	public static void main(String[] args) {
		System.out.println(solution("a234"));
		System.out.println(solution("1234"));
	}
	
	public static boolean solution(String s) {
		boolean answer = true;
		
		if(s.length() != 4 && s.length() != 6) {
			answer = false;
			return answer;
		} else {
			for(int i = 0; i < s.length(); i++) {
				if(!Character.isDigit(s.charAt(i))) answer = false;
			}
			return answer;
		}
	}

}
