package Programmers.Level1;

public class Level1_12947_하샤드수 {
	
	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(12));
		System.out.println(solution(11));
		System.out.println(solution(13));
	}
	
	public static boolean solution(int x) {
		boolean answer = true;
		int harshad = 0;
		
		String number = Integer.toString(x);
		for(int i = 0; i < number.length(); i++) {
			harshad += number.charAt(i)-'0';
		}
		
		if(x%harshad != 0) answer = false;
		
		return answer;
	}
	
}
