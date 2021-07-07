package Programmers.Level1;

public class Level1_12919_서울에서김서방찾기 {

	public static void main(String[] args) {
		String[] seoul = {"Jane", "Kim"};
		System.out.println(solution(seoul));
	}
	
	public static String solution(String[] seoul) {
		String answer = "김서방은 ";
		
		for(int i = 0; i < seoul.length; i++) {
			if(seoul[i].equals("Kim")) answer += i + "에 있다";
		}
		
		return answer;
	}

}
