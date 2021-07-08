package Programmers.Level2;

public class Level2_12924_숫자의표현 {

	public static void main(String[] args) {
		System.out.println(solution(15));
	}
	
	public static int solution(int n) {
		int answer = 0;
		
		for(int i = 1; i < n+1; i++) {
			int min = i;
			int sum = 0;
			boolean flag = true;
			while(flag) {
				sum += min++;
				if(sum > n) flag = false;
				else if(sum == n) answer++;
			}
		}
		
		return answer;
	}

}
