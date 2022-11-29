package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold4_1922_네트워크연결 {
	
	static class Vertex {
		int from;
		int to;
		int weight;
		public Vertex(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int sum = 0;
		parents = new int[N];
		Arrays.fill(parents, -1);
		PriorityQueue<Vertex> queue = new PriorityQueue<>(new Comparator<Vertex>() {
			@Override
			public int compare(Vertex v1, Vertex v2) {
				return v1.weight - v2.weight;
			}
		});
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			queue.offer(new Vertex(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < M; i++) {
			Vertex v = queue.poll();
			if(makeSet(v.from, v.to)) {
				sum += v.weight;
			}
		}
		
		System.out.println(sum);
	}
	
	public static boolean makeSet(int v1, int v2) {
		int root1 = findSet(v1);
		int root2 = findSet(v2);
		
		if(root1 != root2) {
			parents[root2] = root1;
			return true; //네트워크 연결 가능
		}
		return false; //네트워크 연결되어 있음
	}
	
	public static int findSet(int v) {
		if(parents[v] < 0) return v;
		return parents[v] = findSet(parents[v]);
	}

}
