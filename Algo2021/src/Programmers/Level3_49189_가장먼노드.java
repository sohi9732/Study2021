package Programmers;

import java.util.*;

public class Level3_49189_가장먼노드 {
	
	static boolean[][] adj;
	static boolean[] flag;

	public static void main(String[] args) {
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(6, vertex));
	}
	
	public static int solution(int n, int[][] edge) {
		int answer = 0;
		adj = new boolean[n][n];
		flag = new boolean[n];
		
		for(int i = 0; i < edge.length; i++) {
			adj[edge[i][0]-1][edge[i][1]-1] = true;
			adj[edge[i][1]-1][edge[i][0]-1] = true;
		}
		
		answer = bfs(n);
		
		return answer;
	}
	
	public static int bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		flag[0] = true;
		
		int origin_size = queue.size();
		int size = queue.size();
		
		while(size-- > 0) {
			for(int i = 0; i < n; i++) {
				if(adj[queue.peek()][i] && !flag[i]) {
					queue.offer(i);
					flag[i] = true;
				}
			}
			queue.poll();
			if(size == 0) {
				size = queue.size();
				if(queue.size() != 0) origin_size = queue.size();
			}
		}
		
		return origin_size;
	}

}
