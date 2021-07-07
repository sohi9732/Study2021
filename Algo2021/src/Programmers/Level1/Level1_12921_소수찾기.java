package Programmers.Level1;

public class Level1_12921_소수찾기 {

	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(5));
	}
	
	public static int solution(int n) {
		int answer = 1;
		boolean flag = false;
		
		for(int i = 3; i < n+1; i = i+2) {
			flag = true;
			for(int j = 3; j <= Math.sqrt(i); j = j+2) {
				if(i%j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) answer++;
		}
		
		return answer;
	}

}
