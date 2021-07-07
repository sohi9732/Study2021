package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class Level1_12935_제일작은수제거하기 {

	public static void main(String[] args) {
		int[] arr1 = {4, 3, 2, 1};
		System.out.println(Arrays.toString(solution(arr1)));
		int[] arr2 = {10};
		System.out.println(Arrays.toString(solution(arr2)));
	}
	
	public static Integer[] solution(int[] arr) {
		ArrayList<Integer> arrlist = new ArrayList<>();
		int min = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != min) arrlist.add(arr[i]);
		}
		
		if(arrlist.size() == 0) arrlist.add(-1);
		Integer[] answer = arrlist.toArray(new Integer[arrlist.size()]);
		
		return answer;
	}

}
