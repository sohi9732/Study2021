package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5_5014_스타트링크 {
	
	static int F, S, G, U, D;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new int[F+1];
		
		if(S == G) System.out.println(0);
		else {
			bfs(S);
			
			if(visited[G] == 0) System.out.println("use the stairs");
			else System.out.println(visited[G]);
		}
	}

	private static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(now);
		
		while(!q.isEmpty()) {
			now = q.poll();
			
			if(visited[G] != 0) break;
			
			if(now+U <= F && visited[now+U] == 0 && now+U != S) {
				visited[now+U] = visited[now]+1;
				q.offer(now+U);
			}
			
			if(now-D >= 1 && visited[now-D] == 0 && now-D != S) {
				visited[now-D] = visited[now]+1;
				q.offer(now-D);
			}
		}
	}

}
