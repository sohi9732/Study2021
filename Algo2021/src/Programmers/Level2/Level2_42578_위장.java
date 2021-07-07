package Programmers.Level2;

import java.util.*;

public class Level2_42578_위장 {

	public static void main(String[] args) {
		String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes1));
		String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution(clothes2));
	}
	
	public static int solution(String[][] clothes) {
		int answer = 1;
		
		HashMap<String, Integer> map = new HashMap<>();
		for(String[] cloth : clothes) {
			if(map.containsKey(cloth[1])) {
				int cnt = map.get(cloth[1]);
				map.put(cloth[1], cnt+1);
			}
			else map.put(cloth[1], 1);
		}
		
		Integer[] input = map.values().toArray(new Integer[map.size()]);
		for(int i = 0; i < input.length; i++) {
			answer *= input[i]+1;
		}
		
		return answer-1;
	}

}
