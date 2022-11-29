package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold4_14499_주사위굴리기 {
	
	static int N, M;
	/*
	 * 0 : 위
	 * 1 : 북
	 * 2 : 동
	 * 3 : 서
	 * 4 : 남
	 * 5 : 아래
	 */
	static int[] dice = new int[6];
	static int[] dice_next = new int[6];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dx = {0, 0, 0, -1, 1};
		int[] dy = {0, 1, -1, 0, 0};
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());

			if(isPossible(x+dx[dir], y+dy[dir])) {
				x += dx[dir];
				y += dy[dir];
				
				if(dir == 1) {
					dice_next[0] = dice[3];
					dice_next[1] = dice[1];
					dice_next[2] = dice[0];
					dice_next[3] = dice[5];
					dice_next[4] = dice[4];
					dice_next[5] = dice[2];
				} else if(dir == 2) {
					dice_next[0] = dice[2];
					dice_next[1] = dice[1];
					dice_next[2] = dice[5];
					dice_next[3] = dice[0];
					dice_next[4] = dice[4];
					dice_next[5] = dice[3];
				} else if(dir == 3) {
					dice_next[0] = dice[4];
					dice_next[1] = dice[0];
					dice_next[2] = dice[2];
					dice_next[3] = dice[3];
					dice_next[4] = dice[5];
					dice_next[5] = dice[1];
				} else if(dir == 4) {
					dice_next[0] = dice[1];
					dice_next[1] = dice[5];
					dice_next[2] = dice[2];
					dice_next[3] = dice[3];
					dice_next[4] = dice[0];
					dice_next[5] = dice[4];
				}
				dice = dice_next.clone();
				
				if(map[x][y] == 0) map[x][y] = dice[5];
				else {
					dice[5] = map[x][y];
					map[x][y] = 0;
				}
				
				sb.append(dice[0]);
			}
		}
		
		for (int i = 0; i < sb.length(); i++) {
			System.out.println(sb.charAt(i));
		}
	}
	
	private static boolean isPossible(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<M) return true;
		return false;
	}

}
