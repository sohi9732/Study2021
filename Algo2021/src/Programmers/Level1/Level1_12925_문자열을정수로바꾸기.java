package Programmers.Level1;

public class Level1_12925_문자열을정수로바꾸기 {

	public static void main(String[] args) {
		System.out.println(solution("1234"));
		System.out.println(solution("-1234"));
	}
	
	public static int solution(String s) {
		int answer = 0;
		
		if(s.charAt(0) == '+') answer = Integer.parseInt(s.substring(1));
		else if(s.charAt(0) == '-') answer = -1 * Integer.parseInt(s.substring(1));
		else answer = Integer.parseInt(s);
		
		return answer;
	}

}
