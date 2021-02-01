package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_1260_DFS와BFS {
	
	static int N, M, V;
	static boolean[][] adj;
	static boolean[] dfs, bfs;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken())-1;
		adj = new boolean[N][N];
		dfs = new boolean[N];
		bfs = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int to = Integer.parseInt(st.nextToken())-1;
			int from = Integer.parseInt(st.nextToken())-1;
			adj[to][from] = true;
			adj[from][to] = true;
		}
		
		//DFS
		dfs[V] = true;
		System.out.print(V+1);
		for (int i = 0; i < N; i++) {
			if(adj[V][i] && !dfs[i]) {
				dfs[i] = true;
				System.out.print(" " + (i+1));
				dfs(i);
			}
		}
		System.out.println();
		
		//BFS
		bfs(V);
	}

	private static void dfs(int v) {
		for (int i = 0; i < N; i++) {
			if(adj[v][i] && !dfs[i]) {
				dfs[i] = true;
				System.out.print(" " + (i+1));
				dfs(i);
			}
		}
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		bfs[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print((v+1) + " ");
			for (int i = 0; i < N; i++) {
				if(adj[v][i] && !bfs[i]) {
					bfs[i] = true;
					q.offer(i);
				}
			}
		}
	}

}
