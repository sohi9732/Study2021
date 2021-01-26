package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1233_사칙연산유효성검사 {
	
	static class Node {
		int index;
		char op;
		int num;
		int left;
		int right;
		public Node(int index, char op, int left, int right) {
			this.index = index;
			this.op = op;
			this.left = left;
			this.right = right;
		}
		public Node(int index, int num) {
			this.index = index;
			this.num = num;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int answer = 1;
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			
			Node[] arr = new Node[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int index = Integer.parseInt(st.nextToken())-1;
				if(st.countTokens() == 3) {
					char op = st.nextToken().charAt(0);
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					arr[i] = new Node(index, op, left, right);
				}
				else {
					char ch = st.nextToken().charAt(0);
					if(Character.isDigit(ch)) {
						int num = ch-'0';
						arr[i] = new Node(index, num);
					}
					else {
						answer = 0;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}

}
