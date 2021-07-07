package Programmers.Level1;

import java.util.Arrays;

public class Level1_12950_행렬의덧셈 {

	public static void main(String[] args) {
		int[][] arr1 = {{1, 2}, {2, 3}};
		int[][] arr2 = {{3, 4}, {5, 6}};
		int[][] answer1 = solution(arr1, arr2);
		for (int i = 0; i < answer1.length; i++) {
			System.out.print(Arrays.toString(answer1[i]));
		}
		System.out.println();
		int[][] brr1 = {{1}, {2}};
		int[][] brr2 = {{3}, {4}};
		int[][] answer2 = solution(brr1, brr2);
		for (int i = 0; i < answer1.length; i++) {
			System.out.print(Arrays.toString(answer2[i]));
		}
		System.out.println();
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int N = arr1.length;
		int M = arr1[0].length;
		int[][] answer = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		
		return answer;
	}

}
