package Programmers.Level2;

import java.util.*;

public class Level2_42885_구명보트 {

	public static void main(String[] args) {
		int[] people1 = {70, 50, 80, 50};
		System.out.println(solution(people1, 100));
		int[] people2 = {70, 80, 50};
		System.out.println(solution(people2, 100));
	}
	
	public static int solution(int[] people, int limit) {
		int answer = 0;
		int cnt = 1;
		
		Arrays.sort(people);
		
		int i = 0;
		while(i < people.length-(i+cnt)) {
			if(people[i]+people[people.length-(i+cnt)] <= limit) {
				answer++;
				i++;
			} else {
				cnt++;
				answer++;
			}
		}
		if(i == people.length-(i+cnt)) answer++;
		
		return answer;
	}

}
