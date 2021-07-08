package Programmers.Level1;

public class Level1_12934_정수제곱근판별 {

	public static void main(String[] args) {
		System.out.println(solution(121));
		System.out.println(solution(3));
	}
	
	public static long solution(long n) {
		long answer = 0;
		
		int floor_sqrt = (int)Math.floor(Math.sqrt(n));
		if(Math.pow(floor_sqrt, 2) == n) answer = (long)Math.pow(floor_sqrt+1, 2);
		else answer = -1;
		
		return answer;
	}

}
