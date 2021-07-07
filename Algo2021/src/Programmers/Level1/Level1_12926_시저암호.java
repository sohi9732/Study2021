package Programmers.Level1;

public class Level1_12926_시저암호 {

	public static void main(String[] args) {
		System.out.println(solution("AB", 1));
		System.out.println(solution("z", 1));
		System.out.println(solution("a B z", 4));
	}
	
	public static String solution(String s, int n) {
		String answer = "";
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') answer += " ";
			else {
				char letter = s.charAt(i);
				for(int j = 0; j < n; j++) {
					letter++;
					if(letter == '{') letter = 'a';
					else if(letter == '[') letter = 'A';
				}
				answer += letter;
			}
		}
		
		return answer;
	}

}
