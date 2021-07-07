package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class Level1_12910_나누어떨어지는숫자배열 {

	public static void main(String[] args) {
		int[] arr1 = {5, 9, 7, 10};
		System.out.println(Arrays.toString(solution(arr1, 5)));
		int[] arr2 = {2, 36, 1, 3};
		System.out.println(Arrays.toString(solution(arr2, 1)));
		int[] arr3 = {3, 2, 6};
		System.out.println(Arrays.toString(solution(arr3, 10)));
	}
	
	public static int[] solution(int[] arr, int divisor) {
		ArrayList<Integer> arrlist = new ArrayList<>();
		
		for(int i : arr) {
			if(i%divisor == 0) arrlist.add(i);
		}
		
		if(arrlist.size() == 0) {
			int[] answer = new int[1];
			answer[0] = -1;
			return answer;
		} else {
			int[] answer = new int[arrlist.size()];
			for(int i = 0; i < answer.length; i++) {
				answer[i] = arrlist.get(i);
			}
			Arrays.sort(answer);
			return answer;
		}
	}

}
