package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold3_19237_어른상어 {
	
	static int N, M, K;
	static int[][] map;
	
	static class Shark {
		int num;
		int x;
		int y;
		int dir;
		int[][] priority = new int[5][5];
		boolean alive = true;
		public Shark(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Smell {
		int sharkNum;
		int timeLeft;
		public Smell(int sharkNum, int timeLeft) {
			this.sharkNum = sharkNum;
			this.timeLeft = timeLeft;
		}
	}
	
	static Smell[][] smellMap;
	
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //상어 수
		K = Integer.parseInt(st.nextToken()); //냄새 유지 시간
		map = new int[N][N];
		
		int timeCnt = 0;
		int deadShark = 0;
		
		Shark[] sharks = new Shark[M+1];
		smellMap = new Smell[N][N];
		
		//map 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0) { //상어라면
					sharks[map[i][j]] = new Shark(map[i][j], i, j);
				}
				
				smellMap[i][j] = new Smell(0, 0);
			}
		}
		
		//상어 방향 입력
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= M; i++) {
			sharks[i].dir = Integer.parseInt(st.nextToken());
		}
		
		//각 상어의 방향 우선순위 입력(순서 : 위(1), 아래(2), 좌(3), 우(4))
		for (int i = 1; i <= M; i++) {
			for (int p = 1; p <= 4; p++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int q = 1; q <= 4; q++) {
					sharks[i].priority[p][q] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		//맨 처음 냄새 뿌리기
		for (int i = 1; i <= M; i++) {
			smellMap[sharks[i].x][sharks[i].y].sharkNum = sharks[i].num;
			smellMap[sharks[i].x][sharks[i].y].timeLeft = K;
		}
		
		while(timeCnt <= 1000) {
			timeCnt++;
			
			//모든 상어에 대해 이동
			for (int i = 1; i <= M; i++) {
				if(sharks[i].alive) {
					boolean sharkMoved = false;
					int nextDir = 0;
					//아무 냄새가 없는 칸 탐색
					for (int d = 1; d <= 4; d++) {	
						//방향 우선순위에 따라
						nextDir = sharks[i].priority[sharks[i].dir][d];
						int nx = sharks[i].x+dx[nextDir];
						int ny = sharks[i].y+dy[nextDir];
						if(isPossible(nx, ny) && smellMap[nx][ny].sharkNum == 0) {
							//상어 이동
							map[sharks[i].x][sharks[i].y] = 0;
							sharks[i].x = nx;
							sharks[i].y = ny;
							//방향 전환
							sharks[i].dir = nextDir;
							
							//이미 작은 번호 상어가 움직인 칸이면
							if(map[nx][ny] != 0 && map[nx][ny] < i) {
								sharks[i].alive = false; //쫓겨남
								deadShark++;
							} else map[nx][ny] = i; //작은 번호 상어이면 움직이기 가능
							
							sharkMoved = true;
							break;
						}
					}
					//아무 냄새가 없는 칸이 없다면 자기 냄새가 있는 칸 탐색
					if(!sharkMoved) {
						for (int d = 1; d <= 4; d++) {	
							//방향 우선순위에 따라
							nextDir = sharks[i].priority[sharks[i].dir][d];
							int nx = sharks[i].x+dx[nextDir];
							int ny = sharks[i].y+dy[nextDir];
							if(isPossible(nx, ny) && smellMap[nx][ny].sharkNum == i) {
								//상어 이동
								map[sharks[i].x][sharks[i].y] = 0;
								sharks[i].x = nx;
								sharks[i].y = ny;
								//방향 전환
								sharks[i].dir = nextDir;
								
								//이미 작은 번호 상어가 움직인 칸이면
								if(map[nx][ny] != 0 && map[nx][ny] < i) {
									sharks[i].alive = false; //쫓겨남
									deadShark++;
								} else map[nx][ny] = i; //작은 번호 상어이면 움직이기 가능
								
								sharkMoved = true;
								break;
							}
						}
					}
				}
			}
			
			//이동 후 냄새 뿌리기
			for (int i = 1; i <= M; i++) {
				if(sharks[i].alive) {
					smellMap[sharks[i].x][sharks[i].y].sharkNum = i;
					smellMap[sharks[i].x][sharks[i].y].timeLeft = K;
				}
			}
			
			downSmell(); //냄새 흔적 -1
			
			//printMap(sharks);
			//printSmellMap();
			
			if(deadShark == M-1) break;
		}
		
		if(timeCnt > 1000) System.out.println(-1); //상어 두마리 이상?
		else System.out.println(timeCnt);
	}
	
	private static void downSmell() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 && smellMap[i][j].timeLeft > 0) smellMap[i][j].timeLeft--;
				
				if(smellMap[i][j].timeLeft == 0) {
					smellMap[i][j].sharkNum = 0;
				}
			}
		}
	}

	private static boolean isPossible(int x, int y) {
		if(x>=0 && y>=0 && x<N && y<N) return true;
		return false;
	}
	
	/* 중간 과정 출력 함수
	 * 
	private static void printSmellMap() {
		System.out.println("===== smell map =====");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print("("+smellMap[i][j].sharkNum+","+smellMap[i][j].timeLeft+")");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void printMap(Shark[] sharks) {
		System.out.println("======== map ========");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) System.out.print("("+map[i][j]+",0)");
				else {
					if(sharks[map[i][j]].dir == 1)
						System.out.print("["+map[i][j]+",^]");
					else if(sharks[map[i][j]].dir == 2)
						System.out.print("["+map[i][j]+",v]");
					else if(sharks[map[i][j]].dir == 3)
						System.out.print("["+map[i][j]+",<]");
					else if(sharks[map[i][j]].dir == 4)
						System.out.print("["+map[i][j]+",>]");
				}
			}
			System.out.println();
		}
	}*/

}
