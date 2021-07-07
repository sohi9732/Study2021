package Programmers.Level1;

public class Level1_12901_2016년 {

	public static void main(String[] args) {
		System.out.println(solution(5, 24));
	}
	
	public static String solution(int a, int b) {
		String answer = "";
		
		int[] monLen = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int day = 0;
		
		for(int i = 0; i < a-1; i++) {
			day += monLen[i];
		}
		day = (day+b) % 7;
		
		switch(day) {
			case 0:
				answer = "THU";
				break;
			case 1:
				answer = "FRI";
				break;
			case 2:
				answer = "SAT";
				break;
			case 3:
				answer = "SUN";
				break;
			case 4:
				answer = "MON";
				break;
			case 5:
				answer = "TUE";
				break;
			case 6:
				answer = "WED";
				break;
		}
		
		return answer;
	}

}
