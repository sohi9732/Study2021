package Programmers;

import java.util.*;

public class Level2_42747_HIndex {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}
	
	public static int solution(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);
		int[] cnt = new int[citations[citations.length-1]+1];
		for(int i = 0; i < citations.length; i++) {
			cnt[citations[i]]++;
		}
		
		for(int i = cnt.length-1; i >= 0; i--) {
			int h = i;
			int up = 0;
			for(int j = i; j < cnt.length; j++) {
				up += cnt[j];
			}
			if(h <= up) {
				answer = h;
				break;
			}
		}
		
		return answer;
	}

}
