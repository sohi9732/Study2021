package Baekjoon;

import java.io.*;
import java.util.*;

public class Silver1_2667_단지번호붙이기 {
	
	static int[][] map;
	static int[] apt;
	static int N, size;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		apt = new int[N*N];
		
		//지도 입력받기
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) { //단지 시작점 찾기
					cnt++;
					size = 0;
					dfs(i, j);
					//단지 한 개 찾기 dfs 종료 후 단지 크기 저장
					apt[cnt] = size;
				}
			}
		}
		
		System.out.println(cnt); //총 단지 수
		//각 단지내 집 수 오름차순 정렬 후 출력
		Arrays.sort(apt);
		for (int i = 0; i < apt.length; i++) {
			if(apt[i] != 0) System.out.println(apt[i]);
		}
	}
	
					// 우    하   좌   상
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void dfs(int x, int y) {
		map[x][y] *= -1; //방문지점 음수로 변경
		size++;
		
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(isPossible(nx, ny)) dfs(nx, ny);
		}
	}
	
	public static boolean isPossible(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<N && map[x][y] == 1) return true;
		return false;
	}

}
