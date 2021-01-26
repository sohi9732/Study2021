package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Gold5_20056_마법사상어와파이어볼 {

	static class Fireball {
		int r;
		int c;
		int m;
		int s;
		int d;
		public Fireball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	static int N, M, K;
	//static ArrayList<Fireball>[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ArrayList<Fireball>[][] map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) { //ArrayList형 2차원 배열로 초기화
			for (int j = 0; j < N; j++) {
				ArrayList<Fireball> list = new ArrayList<>();
				map[i][j] = list;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			map[x][y].add(new Fireball(x, y, m, s, d));
		}
		
		for (int i = 0; i < K; i++) {
			map = moveFireball(map); //파이어볼 이동
			map = splitFireball(map); //2개 이상의 파이어볼이 있는 칸에 대해
		}
		
		//남아있는 파이어볼 질량의 합
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].size() > 0) {
					for (int k = 0; k < map[i][j].size(); k++) {
						sum += map[i][j].get(k).m;
					}
				}
			}
		}
		
		System.out.println(sum);
	}

	private static ArrayList<Fireball>[][] moveFireball(ArrayList<Fireball>[][] map) {
		ArrayList<Fireball>[][] newMap = new ArrayList[N][N];
		for (int i = 0; i < N; i++) { //ArrayList형 2차원 배열로 초기화
			for (int j = 0; j < N; j++) {
				ArrayList<Fireball> list = new ArrayList<>();
				newMap[i][j] = list;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].size() > 0) {
					for (int k = 0; k < map[i][j].size(); k++) {
						Fireball newFireball = moveThis(map[i][j].get(k));
						newMap[newFireball.r][newFireball.c].add(newFireball);
					}
				}
			}
		}
		return newMap;
	}

	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	private static Fireball moveThis(Fireball fireball) {
		int d = fireball.d;
		int s = fireball.s;
		for (int i = 0; i < s; i++) {
			int nx = fireball.r + dx[d];
			int ny = fireball.c + dy[d];
			
			if(nx < 0) nx = N-1;
			else if(nx == N) nx = 0;
			
			if(ny < 0) ny = N-1;
			else if(ny == N) ny = 0;
			
			fireball.r = nx;
			fireball.c = ny;
		}
		return fireball;
	}
	
	private static ArrayList<Fireball>[][] splitFireball(ArrayList<Fireball>[][] map) {
		ArrayList<Fireball>[][] newMap = new ArrayList[N][N];
		for (int i = 0; i < N; i++) { //ArrayList형 2차원 배열로 초기화
			for (int j = 0; j < N; j++) {
				ArrayList<Fireball> list = new ArrayList<>();
				newMap[i][j] = list;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].size() >= 2) { //파이어볼이 2개 이상일 경우
					int sumM = 0;
					int sumS = 0;
					boolean even = false; //짝수
					boolean odd = false; //홀수
					//같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
					for (int k = 0; k < map[i][j].size(); k++) {
						sumM += map[i][j].get(k).m;
						sumS += map[i][j].get(k).s;
						if(map[i][j].get(k).d%2 == 0) even = true; //짝수
						else odd = true; //홀수
					}
					int newM = sumM/5;
					int newS = sumS/map[i][j].size();
					//모두 짝수나 홀수이면 d = 0, 2, 4, 6
					int newD1 = 0;
					int newD2 = 2;
					int newD3 = 4;
					int newD4 = 6;
					if(even && odd) { //짝수, 홀수가 모두 있으면 d = 1, 3, 5, 7
						newD1 = 1;
						newD2 = 3;
						newD3 = 5;
						newD4 = 7;
					}
					//질량이 0보다 큰 파이어볼은 4개의 파이어볼로 나누어진다.
					if(newM > 0) {
						newMap[i][j].add(new Fireball(i, j, newM, newS, newD1));
						newMap[i][j].add(new Fireball(i, j, newM, newS, newD2));
						newMap[i][j].add(new Fireball(i, j, newM, newS, newD3));
						newMap[i][j].add(new Fireball(i, j, newM, newS, newD4));
					}
				}
				else { //파이어볼이 하나일 경우
					newMap[i][j] = map[i][j];
				}
			}
		}
		
		return newMap;
	}

}