package Baekjoon.Silver;

import java.io.*;
import java.util.*;

public class Silver2_1912_연속합 {

	static int[] arr;
	static int[] memo;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		arr = new int[n];
		memo = new int[n];		

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		memo[0] = arr[0];
		max = arr[0];
		
		dp(n-1);
		
		System.out.println(max);
	}
	
	public static int dp(int n) {
		if(memo[n] == 0 && n>0) {
			memo[n] = Math.max(dp(n-1)+arr[n], arr[n]);
			max = Math.max(memo[n], max);
		}
		
		return memo[n];
	}

}
