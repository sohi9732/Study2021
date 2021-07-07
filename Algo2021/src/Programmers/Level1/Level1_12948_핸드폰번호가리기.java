package Programmers.Level1;

public class Level1_12948_핸드폰번호가리기 {

	public static void main(String[] args) {
		System.out.println(solution("01033334444"));
		System.out.println(solution("027778888"));
	}
	
	public static String solution(String phone_number) {
		String answer = "";
		
		for(int i = 0; i < phone_number.length()-4; i++) {
			answer += "*";
		}
		
		for(int i = phone_number.length()-4; i < phone_number.length(); i++) {
			answer += phone_number.charAt(i);
		}
		
		return answer;
	}

}
