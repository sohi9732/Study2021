package Basic;

/*	[SWexpert] D4_3289_서로소집합
 
	초기에 {1}, {2}, ... {n} 이 각각 n개의 집합을 이루고 있다.
	여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
	연산을 수행하는 프로그램을 작성하시오.
	
	[입력]
	첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
	각 테스트 케이스의 첫째 줄에 n(1≤n≤1,000,000), m(1≤m≤100,000)이 주어진다.
	m은 입력으로 주어지는 연산의 개수이다.
	다음 m개의 줄에는 각각의 연산이 주어진다.
	합집합은 0 a b의 형태로 입력이 주어진다.
	이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다.
	두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다.
	이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
	a와 b는 n 이하의 자연수이며 같을 수도 있다.
	
	[출력]
	각 테스트 케이스마다 1로 시작하는 입력에 대해서 같은 집합에 속해있다면 1을, 아니면 0을 순서대로 한줄에 연속하여 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Union_Find {

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

/* 입력
1
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
*/

/* 출력
#1 001
*/
