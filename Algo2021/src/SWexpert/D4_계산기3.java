package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class D4_계산기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int result = 0;
			int length = Integer.parseInt(in.readLine());
			String s = in.readLine();
			
			Queue<Character> queue = new LinkedList<Character>();
			Stack<Character> stack = new Stack<Character>();
			
			for (int i = 0; i < length; i++) {
				if(s.charAt(i) == '+') {
					if(stack.peek() == '*') {
						//연속 곱셈일 경우 계속 빼준다
						while(stack.peek() == '*') {
							queue.offer(stack.pop());
						}
					}
					else if(stack.peek() == '+') {
						queue.offer(stack.pop());
					}
					stack.push(s.charAt(i));
				} else if(s.charAt(i) == '*') {
					stack.push(s.charAt(i));
				} else if(s.charAt(i) == '(') {
					stack.push(s.charAt(i));
				} else if(s.charAt(i) == ')') {
					//'(' 나올 때까지 스택에서 pop해서 큐에 offer
					while(stack.peek() != '(') {
						queue.offer(stack.pop());
					}
					stack.pop(); //마지막에 '(' pop 해주기
					if(stack.isEmpty()) break;
				} else { //숫자일 경우
					queue.offer(s.charAt(i));
				}
			}
			
			/*while(!queue.isEmpty()) {
				System.out.print(queue.poll());
			}
			System.out.println();*/
			
			Stack<Integer> calculate = new Stack<Integer>();
			while(!queue.isEmpty()) {
				if(queue.peek() == '+') {
					queue.poll();
					// 스택의 숫자 두 개를 pop해서 더해준 값을 스택에 넣어준다
					int a = calculate.pop();
					int b = calculate.pop();
					calculate.push(a+b);
				} 
				else if(queue.peek() == '*') {
					queue.poll();
					// 스택의 숫자 두 개를 pop해서 곱해준 값을 스택에 넣어준다
					int a = calculate.pop();
					int b = calculate.pop();
					calculate.push(a*b);
				} 
				else {
					calculate.push(queue.poll() - '0');
				}
			}
			//스택에 남아 있는 값이 정답
			result = calculate.pop();
			
			System.out.println("#" + test_case + " " + result);
		}
	}

}
