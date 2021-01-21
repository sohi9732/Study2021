package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D4_1861_정사각형방 {
	
	static int N, cnt;
	static int[][] map;
	static boolean[][] flag;
	static class Route {
		int start;
		int size;
		public Route(int start, int size) {
			this.start = start;
			this.size = size;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			flag = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			PriorityQueue<Route> queue = new PriorityQueue<>(new Comparator<Route>() {
				
				@Override
				public int compare(Route o1, Route o2) {
					if(o1.size == o2.size) 
						return o1.start - o2.start;
					return o2.size - o1.size;
				}
				
			});
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 0;
					dfs(i, j);
					queue.offer(new Route(map[i][j], cnt));
				}
			}
			
			System.out.println("#" + test_case + " " + queue.peek().start + " " + queue.peek().size);
		}
	}
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	private static void dfs(int x, int y) {
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isPossible(nx, ny) && map[x][y]+1 == map[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}

	private static boolean isPossible(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}

}
