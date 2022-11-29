package Baekjoon.Silver;

import java.io.*;
import java.util.*;

public class Silver2_2072_오목 {
	
	static int[][] map = new int[20][20];
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			
			int color = 0;
			if(i%2 == 0) color = 1; //흑돌(1)
			else color = 2; //백돌(2)
			
			//새 돌을 놓고 그 돌에 대한 오목 판단
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());			
			map[x][y] = color;
			
			if(isOmok(x, y)) {
				System.out.println(i+1); //오목이 완성된 경우
				break;
			}
			if(i == N-1) System.out.println(-1); //승패가 갈리지 않는 경우
		}
	}

	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	private static boolean isOmok(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isPossible(nx, ny) && map[x][y] == map[nx][ny]) {
				cnt = 2;
				goStraight(nx, ny, i);
				goBack(x, y, dx[i]*-1, dy[i]*-1);
				if(cnt == 5) return true;
			}
		}
		return false;
	}

	private static void goStraight(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		if(isPossible(nx, ny) && map[x][y] == map[nx][ny]) {
			cnt++;
			goStraight(nx, ny, d);
		}
		return;
	}

	private static void goBack(int x, int y, int dx, int dy) {
		int nx = x + dx;
		int ny = y + dy;
		if(isPossible(nx, ny) && map[x][y] == map[nx][ny]) {
			cnt++;
			goBack(nx, ny, dx, dy);
		}
		return;
	}

	private static boolean isPossible(int x, int y) {
		return x>=0 && x<20 && y>=0 && y<20;
	}

}
