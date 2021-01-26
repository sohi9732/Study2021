package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int answer = 1;
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				st.nextToken();
				if(st.countTokens() == 3) {
					st.nextToken();
					st.nextToken();
					st.nextToken();
				}
				else {
					char ch = st.nextToken().charAt(0);
					if(!Character.isDigit(ch)) {
						answer = 0;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}

}
