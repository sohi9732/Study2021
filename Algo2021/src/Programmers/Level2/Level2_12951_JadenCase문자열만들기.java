package Programmers.Level2;

public class Level2_12951_JadenCase문자열만들기 {

	public static void main(String[] args) {
		System.out.println(solution("3people unFollowed me"));
		System.out.println(solution("for the last week"));
	}
	
	public static String solution(String s) {
		String answer = "";
		String[] str = s.split(" ");
		
		for(int i = 0; i < str.length; i++) {
			String word = "";
			if(str[i].length() > 0) {
				word = str[i].substring(0, 1).toUpperCase();
				if(str[i].length() > 1) word += str[i].substring(1).toLowerCase();
			}
			answer += word;
			if(i != str.length-1) answer += " ";
		}
		if(s.charAt(s.length()-1) == ' ') answer += " ";
		
		return answer;
	}

}
