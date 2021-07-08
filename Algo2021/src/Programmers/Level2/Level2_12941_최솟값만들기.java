package Programmers.Level2;

import java.util.Arrays;

public class Level2_12941_최솟값만들기 {

	public static void main(String[] args) {
		int[] A1 = {1, 4, 2};
		int[] B1 = {5, 4, 4};
		System.out.println(solution(A1, B1));
		int[] A2 = {1, 2};
		int[] B2 = {3, 4};
		System.out.println(solution(A2, B2));
	}
	
	public static int solution(int []A, int []B) {
		int answer = 0;
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		for(int i = 0; i < A.length; i++) {
			answer += A[i]*B[B.length-1-i];
		}
		
		return answer;
	}

}
