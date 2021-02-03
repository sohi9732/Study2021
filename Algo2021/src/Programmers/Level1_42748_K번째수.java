package Programmers;

import java.util.*;

public class Level1_42748_K번째수 {
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer = solution(array, commands);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int index;
		
		for(int i = 0; i < commands.length; i++) {
			index = 0;
			int[] tmp = new int[commands[i][1]-commands[i][0]+1];
			for(int j = commands[i][0]-1; j < commands[i][1]; j++) {
				tmp[index++] = array[j];
			}
			Arrays.sort(tmp);
			answer[i] = tmp[commands[i][2]-1];
		}
		
		return answer;
	}

}
