package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_4408_자기방으로돌아가기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(in.readLine());
			int[] corridor = new int[200];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(from%2 == 0) from = from/2-1;
				else from /= 2;
				if(to%2 == 0) to = to/2-1;
				else to /= 2;
				
				if(from>to) {
					int tmp = from;
					from = to;
					to = tmp;
				}
				
				for (int index = from; index <= to; index++) {
					corridor[index]++;
				}
			}
			
			Arrays.sort(corridor);
			int time = corridor[corridor.length-1];
			
			System.out.println("#" + test_case + " " + time);
		}
	}

}
