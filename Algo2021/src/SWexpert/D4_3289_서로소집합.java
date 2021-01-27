package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_3289_서로소집합 {
	
	static ArrayList<Integer> list;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			parents = new int[N+1];
			Arrays.fill(parents, -1);
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int set = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(set == 0) makeSet(a, b);
				else {
					if(findSet(a) == findSet(b)) list.add(1);
					else list.add(0);
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (int n : list) System.out.print(n);
			System.out.println();
		}
	}

	private static boolean makeSet(int n1, int n2) {
		int root1 = findSet(n1);
		int root2 = findSet(n2);
		if(root1 != root2) {
			parents[root2] = root1;
			return true; //서로 다른 집합이면 합집합
		}
		return false;
	}

	private static int findSet(int n) {
		if(parents[n] < 0) return n;
		return parents[n] = findSet(parents[n]);
	}

}
