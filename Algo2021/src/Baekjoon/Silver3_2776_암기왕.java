package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * map으로 풀어도 되고
 * binary search로 풀어도 되지만
 * 매번 결과를 System.out.print()로 출력하면 시간 초과!
 * StringBuilder에 저장 후 출력해줘야 한다.
 */

public class Silver3_2776_암기왕 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(in.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();
			int N = Integer.parseInt(in.readLine());
			int[] num1 = new int[N]; //BST
			//Map<Integer, Boolean> map = new HashMap<>(); //Map
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				num1[i] = Integer.parseInt(st.nextToken()); //BST
				//map.put(Integer.parseInt(st.nextToken()), true); //Map
			}
			
			Arrays.sort(num1); //BST
			
			int M = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < M; i++) {
				int key = Integer.parseInt(st.nextToken());
				//BST
				if(Arrays.binarySearch(num1, key) >= 0) sb.append("1");
				else sb.append("0");
				//Map
				/*if(map.containsKey(key)) sb.append("1");
				else sb.append("0");*/
				
				if(i < M-1) sb.append("\n");
			}
			
			System.out.println(sb);
		}
	}
	
}
