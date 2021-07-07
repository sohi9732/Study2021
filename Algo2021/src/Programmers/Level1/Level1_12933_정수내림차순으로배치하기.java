package Programmers.Level1;

public class Level1_12933_정수내림차순으로배치하기 {

	public static void main(String[] args) {
		System.out.println(solution(118372));
	}
	
	public static long solution(long n) {
		long answer = 0;
		int[] number = new int[10];
		
		String num = Long.toString(n);
		for(int i = 0; i < num.length(); i++) {
			number[num.charAt(i)-'0']++;
		}
		
		String result = "";
		for(int i = number.length-1; i >= 0; i--) {
			for(int j = 0; j < number[i]; j++) {
				result += Integer.toString(i);
			}
		}
		answer = Long.parseLong(result);
		
		return answer;
	}

}
