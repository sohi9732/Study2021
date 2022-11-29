package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_2606_바이러스 {
	
	static int N, M, cnt;
	static boolean[][] map;
	static boolean[] flag;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		map = new boolean[N][N];
		flag = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int to = Integer.parseInt(st.nextToken())-1;
			int from = Integer.parseInt(st.nextToken())-1;
			map[to][from] = true;
			map[from][to] = true;
		}
		
		flag[0] = true;
		for (int i = 0; i < N; i++) {
			if(map[0][i] && !flag[i]) {
				cnt++;
				flag[i] = true;
				dfs(i);
			}
		}
		
		System.out.println(cnt);
	}

	private static void dfs(int v) {
		for (int i = 0; i < N; i++) {
			if(map[v][i] && !flag[i]) {
				cnt++;
				flag[i] = true;
				dfs(i);
			}
		}
	}

}
