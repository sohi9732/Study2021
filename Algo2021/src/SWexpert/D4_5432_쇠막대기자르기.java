package SWexpert;

import java.io.*;
import java.util.*;

public class D4_5432_쇠막대기자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int sum = 0;
			String s = in.readLine();
			char[] arr = new char[s.length()];
			arr = s.toCharArray();
			Stack<Character> stack = new Stack<Character>();
			
			for(int i = 0; i < arr.length; i++) {
				//')'일 경우
				if(arr[i] == ')') {
					stack.pop();
					//"()"(=레이저)일 경우
					if(arr[i-1] == '(') sum += stack.size();
					else sum++;
				}
				//'('일 경우
				else stack.push(arr[i]);
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}

}
