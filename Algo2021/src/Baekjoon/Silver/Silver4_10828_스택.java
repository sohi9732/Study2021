package Baekjoon.Silver;

import java.io.*;
import java.util.*;

public class Silver4_10828_스택 {
	
	static int[] stack = new int[10001];
	static int top = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			switch (st.nextToken()) {
			case "push":
				push(st.nextToken());
				break;
			case "pop":
				pop();
				break;
			case "size":
				size();
				break;
			case "empty":
				if(empty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "top":
				top();
				break;
			default:
				break;
			}
		}
	}

	private static void push(String n) {
		int num = Integer.parseInt(n);
		stack[++top] = num;
	}

	private static void pop() {
		if(empty()) System.out.println(-1);
		else {
			System.out.println(stack[top]);
			stack[top--] = 0;			
		}
	}

	private static void size() {
		System.out.println(top+1);
	}

	private static boolean empty() {
		if(top == -1) return true;
		else return false;
	}

	private static void top() {
		if(empty()) System.out.println(-1);
		else System.out.println(stack[top]);
	}
	
}
