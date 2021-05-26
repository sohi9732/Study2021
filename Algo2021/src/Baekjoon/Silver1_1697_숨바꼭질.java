package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_1697_숨바꼭질 {
	
	static int N, K;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		
		if(N == K) System.out.println(0);
		else {
			bfs(N);
			System.out.println(visited[K]);
		}
	}

	private static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(now);
		
		while(!q.isEmpty()) {
			now = q.poll();
			
			if(visited[K] != 0) break;
			
			if(now-1 >= 0 && visited[now-1] == 0) {
				visited[now-1] = visited[now]+1;
				q.offer(now-1);
			}
			
			if(now+1 < 100001 && visited[now+1] == 0) {
				visited[now+1] = visited[now]+1;
				q.offer(now+1);
			}
			
			if(now*2 < 100001 && visited[now*2] == 0) {
				visited[now*2] = visited[now]+1;
				q.offer(now*2);
			}
		}
	}

}
