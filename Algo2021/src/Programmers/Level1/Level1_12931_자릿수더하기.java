package Programmers.Level1;

public class Level1_12931_자릿수더하기 {

	public static void main(String[] args) {
		System.out.println(solution(123));
		System.out.println(solution(987));
	}
	
	public static int solution(int n) {
		int answer = 0;
		
		String num = Integer.toString(n);
		for(int i = 0; i < num.length(); i++) {
			answer += num.charAt(i)-'0';
		}
		
		return answer;
	}

}
