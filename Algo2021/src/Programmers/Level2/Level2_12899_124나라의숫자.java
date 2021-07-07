package Programmers.Level2;

import java.util.*;

public class Level2_12899_124나라의숫자 {

	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
	}
	
	public static String solution(int n) {
		String answer = "";
		Stack<Integer> stack = new Stack<>();
		
		n--;
		int N = n/3;
		int R = n%3;
		
		stack.push(R);
		
		while(N > 0) {
			n = N-1;
			N = n/3;
			R = n%3;
			
			stack.push(R);
		}
		
		while(stack.size() > 0) {
			int peek = stack.pop();
			switch(peek) {
				case 0:
					answer += '1';
					break;
				case 1:
					answer += '2';
					break;
				case 2:
					answer += '4';
					break;
				default:
					break;
			}
		}
		
		return answer;
	}

}
