package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class Level1_12906_같은숫자는싫어 {

	public static void main(String[] args) {
		int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
		System.out.println(Arrays.toString(solution(arr1)));
		int[] arr2 = {4, 4, 4, 3, 3};
		System.out.println(Arrays.toString(solution(arr2)));
	}
	
	public static int[] solution(int []arr) {
		ArrayList<Integer> arrlist = new ArrayList<>();
		int before = arr[0];
		
		arrlist.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] == before) continue;
			before = arr[i];
			arrlist.add(arr[i]);
		}
		
		int[] answer = new int[arrlist.size()];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = arrlist.get(i);
		}
		
		return answer;
	}

}
