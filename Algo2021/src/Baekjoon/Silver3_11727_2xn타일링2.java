package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver3_11727_2xn타일링2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
		}
		
		System.out.println(dp[n]);
	}

}
