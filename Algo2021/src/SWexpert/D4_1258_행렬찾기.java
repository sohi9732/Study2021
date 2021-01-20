package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D4_1258_행렬찾기 {
	
	static int N, row, cnt;
	static int[][] map;
	static boolean[][] flag;
	static class Matrix {
		int row;
		int col;
		int size;
		public Matrix(int row, int col, int size) {
			this.row = row;
			this.col = col;
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
			
			PriorityQueue<Matrix> queue = new PriorityQueue<>(new Comparator<Matrix>() {
				
				@Override
				public int compare(Matrix o1, Matrix o2) {
					if(o1.size == o2.size)
						return o1.row - o2.row;
					return o1.size - o2.size;
				}
				
			});
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] != 0 && !flag[i][j]) {
						row = 0;
						cnt = 0;
						dfs(i, j);
						queue.offer(new Matrix(row-i, cnt/(row-i), cnt));
					}
				}
			}
			
			System.out.print("#" + test_case + " " + queue.size());
			while(!queue.isEmpty()) {
				int row = queue.peek().row;
				int col = queue.peek().col;
				System.out.print(" " + row + " " + col);
				queue.poll();
			}
			System.out.println();
		}
	}
	
	// 하, 우, 상, 좌
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	private static void dfs(int x, int y) {
		flag[x][y] = true;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isPossible(nx, ny)) {
				dfs(nx, ny);
			}
			else if(isRow(nx, ny)) {
				row = nx;
			}
		}
	}

	private static boolean isPossible(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N && !flag[x][y] && map[x][y]!=0;
	}

	private static boolean isRow(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N && !flag[x][y] && map[x][y]==0 && row==0;
	}

}
