package Programmers.Level2;

import java.util.Arrays;

public class Level2_12949_행렬의곱셈 {

	public static void main(String[] args) {
		int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
		int[][] arr2 = {{3, 3}, {3, 3}};
		int[][] answer = solution(arr1, arr2);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(Arrays.toString(answer[i]));
		}
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int N = arr1.length;
		int M = arr2[0].length;
		int K = arr1[0].length;
		int[][] answer = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < K; k++) {
					answer[i][j] += arr1[i][k]*arr2[k][j];
				}
			}
		}
		
		return answer;
	}

}
