package Programmers.Level1;

public class Level1_12903_가운데글자가져오기 {

	public static void main(String[] args) {
		System.out.println(solution("abcde"));
		System.out.println(solution("qwer"));
	}
	
	public static String solution(String s) {
		String answer = "";
		int len = s.length();
		
		if(len%2 == 0) answer += s.charAt(len/2-1);
		answer += s.charAt(len/2);
		
		return answer;
	}

}
