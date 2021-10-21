package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold2_21609_상어중학교 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] flag;
	static int sizeCnt, rainbowCnt;
	static PriorityQueue<XY> xyQueue;
	
	static class XY {
		int x;
		int y;
		int color;
		public XY(int x, int y, int color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
	
	static class BlockGroup {
		int size;
		int rainbowCnt;
		int mainX;
		int mainY;
		PriorityQueue<XY> xyQueue;
		public BlockGroup(int size, int rainbowCnt, int mainX, int mainY, PriorityQueue<XY> xyQueue) {
			this.size = size;
			this.rainbowCnt = rainbowCnt;
			this.mainX = mainX;
			this.mainY = mainY;
			this.xyQueue = xyQueue;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int score = 0;
		
		//map 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean keepGame = true;
		while(keepGame) {
			////////////////// start //////////////////
			ArrayList<BlockGroup> arrlist = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(0 < map[i][j]) { //일반 블록이 적어도 하나 있어야 함
						int color = map[i][j];
						flag = new boolean[N][N];
						sizeCnt = 0;
						rainbowCnt = 0;
						//기준 블록(무지개 블록 제외)
						xyQueue = new PriorityQueue<>(new Comparator<XY>() {
							@Override
							public int compare(XY o1, XY o2) {
								if(o1.color == o2.color) {
									if(o1.x == o2.x) return o1.y - o2.y;
									return o1.x - o2.x;
								} return o2.color - o1.color;
							}
						});
						
						dfs(i, j, color);
						
						if(sizeCnt >= 2) {
							arrlist.add(new BlockGroup(sizeCnt, rainbowCnt, xyQueue.peek().x, xyQueue.peek().y, xyQueue));
						}
					}
				}
			}
			
			if(arrlist.size() == 0) {
				keepGame = false;
				break;
			}
			////////////////// end //////////////////
			
			//1. 크기가 가장 큰 블록 그룹을 찾는다.
			Collections.sort(arrlist, new Comparator<BlockGroup>() {
				@Override
				public int compare(BlockGroup o1, BlockGroup o2) {
					if(o1.size == o2.size) {
						if(o1.rainbowCnt == o2.rainbowCnt) {
							if(o1.mainX == o2.mainX) return o2.mainY - o1.mainY;
							return o2.mainX - o1.mainX;
						} return o2.rainbowCnt - o1.rainbowCnt;
					} return o2.size - o1.size;
				}
			});
			
			//2. 1에서 찾은 블록 그룹의 모든 블록을 제거한다. (제거 블록 : -10)
			BlockGroup removeGroup = arrlist.get(0);
			score += removeGroup.size * removeGroup.size;
			
			int removeCnt = removeGroup.xyQueue.size();
			for(int i = 0; i < removeCnt; i++) {
				map[removeGroup.xyQueue.peek().x][removeGroup.xyQueue.peek().y] = -10;
				removeGroup.xyQueue.poll();
			}
			
			//3. 격자에 중력이 작용한다.
			gravity();
			
			//4. 격자가 90도 반시계 방향으로 회전한다.
			rotate();
			
			//5. 다시 격자에 중력이 작용한다.
			gravity();
		}
		
		System.out.println(score);
	}

	private static void gravity() {
		for (int j = 0; j < N; j++) {
			for (int i = N-2; i >= 0; i--) {
				if(map[i][j] >= 0) {
					int x = i;
					int y = j;
					while(x+1 < N && map[x+1][y] < -1) {
						map[x+1][y] = map[x][y];
						map[x][y] = -10;
						x++;
					}
				}
			}
		}
	}
	
	private static void rotate() {
		int[][] rotateMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				rotateMap[i][j] = map[j][N-i-1];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = rotateMap[i][j];
			}
		}
	}

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void dfs(int x, int y, int color) {
		flag[x][y] = true;
		sizeCnt++;
		xyQueue.offer(new XY(x, y, map[x][y]));
		for(int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(isPossible(nx, ny) && map[nx][ny] > -1) {
				if(map[nx][ny] == 0 || map[nx][ny] == color) {
					if(map[nx][ny] == 0) rainbowCnt++;
					dfs(nx, ny, color);
				}
			}
		}
	}
	
	public static boolean isPossible(int x, int y) {
		if(x>=0 && y>=0 && x<N && y<N && !flag[x][y]) return true;
		return false;
	}

}
