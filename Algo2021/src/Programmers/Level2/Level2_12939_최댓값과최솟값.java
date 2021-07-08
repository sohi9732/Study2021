package Programmers.Level2;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Level2_12939_최댓값과최솟값 {

	public static void main(String[] args) {
		System.out.println(solution("1 2 3 4"));
		System.out.println(solution("-1 -2 -3 -4"));
		System.out.println(solution("-1 -1"));
	}
	
	public static String solution(String s) {
		String answer = "";
		StringTokenizer st = new StringTokenizer(s, " ");
		
		int[] arr = new int[st.countTokens()];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		answer += arr[0];
		answer += " ";
		answer += arr[arr.length-1];
		
		return answer;
	}

}
