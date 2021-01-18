package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold4_20057_마법사상어와토네이도 {
	
	static int[][] map;
	static int rest;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int x = N/2;
		int y = N/2;
		
		// 좌, 하, 우, 상
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		
		int count = 1;
		int twice = 2;
		int dir = 0;
		
		while(x != 0 || y != 0) {
			for (int i = 0; i < count; i++) {
				x += dx[dir];
				y += dy[dir];
				storm(x, y, dir);
				if(i == count-1) twice--;
				if(x == 0 & y == 0) break;
			}
			dir++;
			if(dir == 4) dir = 0;
			if(twice == 0) {
				twice = 2;
				count++;
			}
		}
		
		System.out.println(rest);		
	}
	
	// 좌, 하, 우, 상
	static int[][] dx = {{-1, 1, -2, 2, 0, -1, 1, -1, 1, 0},
						 {-1, -1, 0, 0, 2, 0, 0, 1, 1, 1},
						 {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0},
						 {1, 1, 0, 0, -2, 0, 0, -1, -1, -1}};
	static int[][] dy = {{1, 1, 0, 0, -2, 0, 0, -1, -1, -1},
			 			 {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0},
			 			 {-1, -1, 0, 0, 2, 0, 0, 1, 1, 1},
			 			 {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}};
	static int[] per = {1, 1, 2, 2, 5, 7, 7, 10, 10, 0};

	private static void storm(int x, int y, int dir) {
		int sum = 0;
		for (int i = 0; i < per.length; i++) {
			int nx = x+dx[dir][i];
			int ny = y+dy[dir][i];
			if(isPossible(nx, ny)) {
				if(i == per.length-1) { //알파일 경우
					map[nx][ny] += map[x][y]-sum;
				} else {
					map[nx][ny] += map[x][y]*0.01*per[i];
					sum += map[x][y]*0.01*per[i];					
				}
			} else {
				if(i == per.length-1) { //알파일 경우
					rest += map[x][y]-sum;
				} else {
					sum += map[x][y]*0.01*per[i];
					rest += map[x][y]*0.01*per[i];					
				}
			}
		}
		map[x][y] = 0;
		//print();
	}

	private static boolean isPossible(int x, int y) {
		return x>=0 && x<map.length && y>=0 && y<map.length;
	}
	
	/*private static void print() {
		System.out.println("===========================");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("rest : " + rest);
	}*/

}
