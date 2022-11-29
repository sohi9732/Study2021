package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Gold4_17135_캐슬디펜스 {
	
	static int N, M, D;
	static int[][] map;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 0);
		
		System.out.println(max);
	}
	
	static class Kill {
		int x;
		int y;
		public Kill(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] archer = new int[3];
	static boolean[][] flag;
	static int kill;
	static ArrayList<Kill> killList;

	private static void combination(int cnt, int cur) { //궁수 위치 조합
		if(cnt == 3) {
			shoot();
			return;
		}
		
		for(int i = cur; i < M; i++) {
			archer[cnt] = i;
			combination(cnt+1, i+1);
		}
	}

	private static void shoot() { //활 쏘기
		flag = new boolean[N][M];
		kill = 0;
		
		for(int i = 0; i < N; i++) { //적이 N번 내려옴
			killList = new ArrayList<>();
			for(int j = 0; j < archer.length; j++) {
				findEnemy(i, archer[j]);
			}
			for(int j = 0; j < killList.size(); j++) {
				flag[killList.get(j).x][killList.get(j).y] = true;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(flag[i][j]) kill++;
			}
		}
		if(max < kill) max = kill;
	}
	
	static class Candi {
		int row;
		int col;
		int dist;
		public Candi(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}

	private static void findEnemy(int turn, int arch) { //죽일 수 있는 적 찾기
		ArrayList<Candi> candiList = new ArrayList<>();
		
		for(int row = N-turn-1; row >= N-turn-D; row--) {
			for(int col = 0; col < M; col++) {
				if(row >= 0 && map[row][col] == 1 && !flag[row][col] && Math.abs(N-turn-row)+Math.abs(arch-col) <= D) {
					candiList.add(new Candi(row, col, Math.abs(N-turn-row)+Math.abs(arch-col)));
				}
			}
		}
		
		if(candiList.size() == 0) return;
		
		if(candiList.size() > 1) {
			Collections.sort(candiList, new Comparator<Candi>() {
				@Override
				public int compare(Candi o1, Candi o2) {
					if(o1.dist == o2.dist) return o1.col - o2.col;
					return o1.dist - o2.dist;
				}
			});
		}
		
		killList.add(new Kill(candiList.get(0).row, candiList.get(0).col));
	}

}
