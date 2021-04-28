package Programmers;

import java.util.*;

public class Level2_42839_소수찾기 {
	
	static int N;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		System.out.println(solution("17"));
		set = new HashSet<>();
		System.out.println(solution("011"));
	}
	
	public static int solution(String numbers) {
		int answer = 0;
		N = numbers.length();
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			permutation(0, i+1, numbers);
		}
		
		boolean flag;
		for(Integer n : set) {
			if(n > 2) {
				flag = true;
				for(int i = 2; i <= Math.sqrt(n); i++) {
					if(n % i == 0) {
						flag = false;
						break;
					}
				}
				if(flag) answer++;
			} else if(n == 2) answer++;
		}
		
		return answer;
	}
	
	public static void permutation(int cnt, int R, String numbers) {
		if(cnt == R) {
			set.add(Integer.parseInt(new String(sb)));
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			sb.append(numbers.charAt(i));
			isSelected[i] = true;
			permutation(cnt+1, R, numbers);
			sb.deleteCharAt(sb.length()-1);
			isSelected[i] = false;
		}
	}

}
