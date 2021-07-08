package Programmers.Level2;

public class Level2_12945_피보나치수 {

	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(5));
	}
	
	public static int solution(int n) {
		int answer = 0;
		int[] fibo = new int[n+1];
		
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i = 2; i < n+1; i++) {
			fibo[i] = (fibo[i-1]+fibo[i-2])%1234567;
		}
		
		answer = fibo[n];
		return answer;
	}

}
