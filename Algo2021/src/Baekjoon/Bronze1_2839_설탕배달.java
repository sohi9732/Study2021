package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze1_2839_설탕배달 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		if(N%5 == 0) { //5의 배수일 경우
			System.out.println(N/5);
		} else { //5의 배수가 아닐 경우
			int five = N/5;
			boolean flag = false; //N킬로그램 만들었는지 여부
			
			while(!flag) {
				int rest = N - 5*five;
				
				if(rest%3 == 0) { //나머지가 3의 배수이면
					System.out.println(five+rest/3);
					break;
				} else {
					five--;
				}
				
				if(five < 0) {
					flag = true;
					break;
				}
			}
			
			if(flag) System.out.println(-1);
		}
	}

}
