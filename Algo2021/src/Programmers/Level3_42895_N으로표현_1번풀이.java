package Programmers;

import java.util.*;

/*
 * HashSet형 배열에 N, NN, NNN, ..., NNNNNNNN(최대8개) 저장해두고
 * 배열 인덱스 수만큼 숫자를 사용하여 사칙연산한 결과값 HashSet에 저장
 * 모든 배열 인덱스에 대하여 루프 돌면서 연산할 수 있는 모든 경우의 결과를 구한 뒤
 * 배열의 1인덱스부터 탐색하여 number와 같은 값이 나오면 그 인덱스가 최솟값
 */

public class Level3_42895_N으로표현_1번풀이 {

	public static void main(String[] args) {
		System.out.println(solution(5, 12));
		System.out.println(solution(2, 11));
		System.out.println(solution(5, 31168));
	}
	
	public static int solution(int N, int number) {
		int answer = -1;
		Set<Integer>[] setArr = new Set[9]; //9번 이상 사용하면 어차피 -1
		int n = N;
		
		for(int i = 1; i < 9; i++) {
			setArr[i] = new HashSet<>();
			setArr[i].add(n);
			n = n * 10 + N;
		}
		
		for(int i = 1; i < 9; i++) {
			for(int j = 1; j < i; j++) {
				for(Integer a : setArr[j]) {
					for(Integer b : setArr[i-j]) {
						setArr[i].add(a+b);
						setArr[i].add(a-b);
						setArr[i].add(b-a);
						setArr[i].add(a*b);
						if(b != 0) setArr[i].add(a/b);
						if(a != 0) setArr[i].add(b/a);
					}
				}
			}
		}
		
		for(int i = 1; i < 9; i++) {
			if(setArr[i].contains(number)) {
				answer = i;
				break;
			}
		}
		
		return answer;
	}

}
