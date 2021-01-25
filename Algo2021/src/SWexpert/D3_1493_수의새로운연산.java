package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1493_수의새로운연산 {
	
	static int cnt, point, x, y, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			if(p > q) {
				int tmp = p;
				p = q;
				q = tmp;
			}
			
			answer = 0;
			int px = 0, py = 0, qx = 0, qy = 0;
			cnt = 1;
			point = 0;
			x = 0;
			y = 0;
			for (int i = 0; i < cnt; i++) {
				x = 1+i;
				y = cnt-i;
				point++;
				
				if(point == p) {
					px = x;
					py = y;
				}
				if(point == q) {
					qx = x;
					qy = y;
					break;
				}
				
				if(i == cnt-1) {
					i = -1;
					cnt++;
				}
			}
			
			int pqx = px + qx;
			int pqy = py + qy;
			
			cnt = 1;
			point = 0;
			x = 0;
			y = 0;
			for (int i = 0; i < cnt; i++) {
				x = 1+i;
				y = cnt-i;
				point++;
				
				if(x == pqx && y == pqy) {
					answer = point;
					break;
				}
				
				if(i == cnt-1) {
					i = -1;
					cnt++;
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}

}
