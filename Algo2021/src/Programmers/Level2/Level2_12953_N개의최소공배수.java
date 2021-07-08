package Programmers.Level2;

import java.util.Arrays;

public class Level2_12953_N개의최소공배수 {

	public static void main(String[] args) {
		int[] arr1 = {2, 6, 8, 14};
		System.out.println(solution(arr1));
		int[] arr2 = {1, 2, 3};
		System.out.println(solution(arr2));

	}
	
	public static int solution(int[] arr) {
		int answer = 0;
		
		Arrays.sort(arr);
		int max = arr[arr.length-1];
		int multi = 1;
		
		boolean flag = true;
		while(flag) {
			int LCM = max*multi;
			for(int i = 0; i < arr.length; i++) {
				if(LCM%arr[i] != 0) {
					flag = false;
					break;
				}
			}
			
			if(!flag) {
				multi++;
				flag = true;
			} else {
				answer = LCM;
				break;
			}
		}
		
		return answer;
	}

}
