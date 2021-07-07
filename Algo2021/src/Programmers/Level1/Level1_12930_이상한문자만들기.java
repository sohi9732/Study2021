package Programmers.Level1;

public class Level1_12930_이상한문자만들기 {

	public static void main(String[] args) {
		System.out.println(solution("try hello world"));
	}
	
	public static String solution(String s) {
		String answer = "";
		
		String upper = s.toUpperCase();
		String lower = s.toLowerCase();
		
		int index = 0;
		for(int i = 0; i < s.length(); i++) {
			if(index%2 == 0) answer += upper.charAt(i);
			else answer += lower.charAt(i);
			index++;
			
			if(s.charAt(i) == ' ') index = 0;
		}
		
		return answer;
	}

}
