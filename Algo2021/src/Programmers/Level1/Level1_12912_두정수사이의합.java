package Programmers.Level1;

public class Level1_12912_두정수사이의합 {

	public static void main(String[] args) {
		System.out.println(solution(3, 5));
		System.out.println(solution(3, 3));
		System.out.println(solution(5, 3));
	}
	
	public static long solution(int a, int b) {
		long answer = 0;
		
		if(a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		for(int i = a; i < b+1; i++) {
			answer += i;
		}
		
		return answer;
	}

}
