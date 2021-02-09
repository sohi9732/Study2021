package Programmers;

import java.util.*;

public class Level3_43105_정수삼각형 {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}
	
	public static int solution(int[][] triangle) {
		int answer = 0;
		int[][] sum = new int[triangle.length][triangle.length];
		sum[0][0] = triangle[0][0];
		sum[1][0] = triangle[0][0] + triangle[1][0];
		sum[1][1] = triangle[0][0] + triangle[1][1];
		
		for(int i = 2; i < triangle.length; i++) {
			for(int j = 0; j < triangle[i].length; j++) {
				if(j == 0) {
					sum[i][j] = sum[i-1][j] + triangle[i][j];
				} else if(j == triangle[i].length-1) {
					sum[i][j] = sum[i-1][j-1] + triangle[i][j];
				} else {
					int max = Math.max(sum[i-1][j-1], sum[i-1][j]);
					sum[i][j] = max + triangle[i][j];
				}
			}
		}
		
		Arrays.sort(sum[sum.length-1]);
		answer = sum[sum.length-1][sum[sum.length-1].length-1];
		
		return answer;
	}

}
