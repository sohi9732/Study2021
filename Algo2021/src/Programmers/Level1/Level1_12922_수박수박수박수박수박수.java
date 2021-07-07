package Programmers.Level1;

public class Level1_12922_수박수박수박수박수박수 {

	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(4));
	}
	
	public static String solution(int n) {
		String answer = "";
		
		for(int i = 0; i < n; i++) {
			if(i%2 == 0) answer += "수";
			else answer += "박";
		}
		
		return answer;
	}

}
