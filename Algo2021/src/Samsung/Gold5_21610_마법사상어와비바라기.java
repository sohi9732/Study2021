package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5_21610_마법사상어와비바라기 {
	
	static int N, M;
	static int[][] A;
	
	static class Cloud {
		int x;
		int y;
		public Cloud(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Cloud> queue = new LinkedList<>();
		queue.offer(new Cloud(N-1, 0));
		queue.offer(new Cloud(N-1, 1));
		queue.offer(new Cloud(N-2, 0));
		queue.offer(new Cloud(N-2, 1));
		
		for (int move = 0; move < M; move++) {
			st = new StringTokenizer(in.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int size = queue.size();
			
			//1. 모든 구름이 d방향으로 s칸 이동
			for (int i = 0; i < size; i++) {
				int cloudX = queue.peek().x;
				int cloudY = queue.peek().y;
				queue.poll();
				for (int k = 0; k < s; k++) {
					cloudX += dx[d];
					if(cloudX < 0) cloudX = N-1;
					if(cloudX >= N) cloudX = 0;
					cloudY += dy[d];
					if(cloudY < 0) cloudY = N-1;
					if(cloudY >= N) cloudY = 0;
				}
				queue.offer(new Cloud(cloudX, cloudY));
			}
			
			//2. 구름에서 비를 내려 물의 양 +1
			boolean[][] clouded = new boolean[N][N];
			while(!queue.isEmpty()) {
				A[queue.peek().x][queue.peek().y]++;
				//구름이 사라진 칸(=물이 증가한 칸) 표시
				clouded[queue.peek().x][queue.peek().y] = true;
				//3. 구름이 사라진다.
				queue.poll();
			}
			
			//4. 물이 증가한 칸에 물복사버그 마법 시전
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(clouded[i][j]) {
						for (int k = 0; k < 4; k++) {
							int nx = i+ddx[k];
							int ny = j+ddy[k];
							if(isPossible(nx, ny) && A[nx][ny] > 0) {
								A[i][j]++;
							}
						}
					}
				}
			}
			
			//5. 물의 양이 2 이상인 칸에 구름 생기고 물의 양 -2 (3번에서 구름 사라진 칸 제외)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!clouded[i][j] && A[i][j] >= 2) {
						queue.offer(new Cloud(i, j));
						A[i][j] -= 2;
					}
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += A[i][j];
			}
		}
		
		System.out.println(sum);
	}

	static int[] ddx = {-1, -1, 1, 1};
	static int[] ddy = {-1, 1, -1, 1};
	
	private static boolean isPossible(int x, int y) {
		if(x>=0 && y>=0 && x<N && y<N) return true;
		return false;
	}

}
