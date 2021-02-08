package Programmers;

import java.util.*;

public class Level2_42746_가장큰수 {

	public static void main(String[] args) {
		int[] numbers1 = {6, 10, 2};
		System.out.println(solution(numbers1));
		int[] numbers2 = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers2));
	}
	
	public static String solution(int[] numbers) {
		String answer = "";
		String[] array = new String[numbers.length];
		
		for(int i = 0; i < numbers.length; i++) {
			array[i] = Integer.toString(numbers[i]);
		}
		
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
			}
		});
		
		for(int i = 0; i < array.length; i++) {
			answer += array[i];
		}
		
		if(answer.charAt(0) == '0') answer = "0";
		
		return answer;
	}

}
