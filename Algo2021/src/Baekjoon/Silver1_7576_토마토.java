package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_7576_토마토 {
	
	static class Tomato {
		int x;
		int y;
		public Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M, cnt;
	static int[][] box;
	static boolean[][] flag;
	static Queue<Tomato> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		flag = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) queue.offer(new Tomato(i, j));
			}
		}
		
		if(queue.size() == N*M) System.out.println(0); //저장될 때부터 모든 토마토가 익어있는 상태이면
		else { //토마토 익히기
			ripeTomato();
		}
		
		boolean canRipe = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					canRipe = false;
					break;
				}
			}
		}
		if(canRipe && cnt != 0) System.out.println(cnt-1);
		else System.out.println(-1);
		
	}

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	private static void ripeTomato() {
		int size = queue.size();
		while(size-- > 0) {
			Tomato tomato = queue.poll();
			flag[tomato.x][tomato.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = tomato.x + dx[i];
				int ny = tomato.y + dy[i];
				if(isPossible(nx, ny)) {
					queue.offer(new Tomato(nx, ny));
					box[nx][ny] = 1;
					flag[nx][ny] = true;
				}
			}
			if(size == 0) {
				cnt++;
				size = queue.size();
			}
		}
	}

	private static boolean isPossible(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M && box[x][y] == 0 && !flag[x][y];
	}

}
