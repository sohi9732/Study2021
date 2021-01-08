package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			in.readLine();
			st = new StringTokenizer(in.readLine(), " ");
			
			//큐에 입력받기
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 0;
			boolean flag = true;
			int num;
			
			//규칙에 따라 암호생성
			while(flag) {
				cnt++;
				if(cnt > 5) cnt = 1;
				
				num = queue.peek() - cnt;
				if(num <= 0) { //0이하 숫자 나오면 반복문 종료
					num = 0;
					flag = false;
				}
				
				queue.offer(num);
				queue.poll();
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}

}
