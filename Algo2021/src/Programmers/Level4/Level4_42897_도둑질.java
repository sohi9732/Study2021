package Programmers.Level4;

public class Level4_42897_도둑질 {

	public static void main(String[] args) {
		int[] money = {1, 2, 3, 1};
		System.out.println(solution(money));
	}
	
	public static int solution(int[] money) {
		int answer = 0;
		int[] dp = new int[money.length];
		
		dp[0] = dp[1] = money[0]; //첫번째 집 선택 + 두번째 집 비선택
		for(int i = 2; i < money.length-1; i++) { //마지막 집 비선택
			dp[i] = Math.max(dp[i-2]+money[i], dp[i-1]);
		}
		answer = dp[money.length-2];
		
		dp[0] = 0; //첫번째 집 비선택
		dp[1] = money[1]; //두번째 집 선택
		for(int i = 2; i < money.length; i++) {
			dp[i] = Math.max(dp[i-2]+money[i], dp[i-1]);
		}
		answer = Math.max(answer, dp[money.length-1]);
		
		return answer;
	}

}
