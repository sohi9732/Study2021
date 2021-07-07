package Programmers.Level2;

import java.util.Arrays;

public class Level2_42584_주식가격 {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(solution(prices)));
	}
	
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for(int i = 0; i < prices.length-1; i++) {
			int cnt = 0;
			for(int j = i+1; j < prices.length; j++) {
				if(prices[i] > prices[j]) {
					cnt++;
					break;
				}
				else cnt++;
			}
			answer[i] = cnt;
		}
		
		return answer;
	}

}
