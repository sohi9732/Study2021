package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Gold2_21611_마법사상어와블리자드 {
	
	static int N, M;
	static int[][] map;
	static int[] answer;
	
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	
	static int[] rx = {0, 1, 0, -1};
	static int[] ry = {-1, 0, 1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		answer = new int[4];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sharkX = N/2;
		int sharkY = N/2;
		
		for (int magic = 0; magic < M; magic++) {
			st = new StringTokenizer(in.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			//구슬 파괴
			for (int i = 0; i < s; i++) {
				map[sharkX+dx[d]*(i+1)][sharkY+dy[d]*(i+1)] = 0;
			}
			
			//빈 칸 구슬 이동
			ArrayList<Integer> arrlist = new ArrayList<>();
			boolean xy0 = true;
			int x = sharkX;
			int y = sharkY;
			int count = 1;
			int twice = 0;

			while(xy0) {
				L:for (int i = 0; i < 4; i++) {
					if(twice == 2) {
						count++;
						twice = 0;
					}
					
					for (int cnt = 0; cnt < count; cnt++) {
						x += rx[i];
						y += ry[i];
						
						//빈 칸이 아니라면 구슬 arrlist에 저장
						if(map[x][y] > 0) arrlist.add(map[x][y]);
						
						if(x == 0 && y == 0) {
							xy0 = false;
							break L;
						}
					}
					twice++;
				}
			}
			
			//4개 연속 구슬은 폭발
			boolean noBoom = true;
			for (int i = 0; i < arrlist.size()-3; i++) {
				int color = arrlist.get(i);
				if(arrlist.get(i+1) == color && arrlist.get(i+2) == color && arrlist.get(i+3) == color) {
					int boomCnt = 4;
					while(i+boomCnt < arrlist.size() && arrlist.get(i+boomCnt) == color) {
						boomCnt++;
					}
					
					answer[color] += boomCnt;
					for (int j = 0; j < boomCnt; j++) {
						arrlist.remove(i);
					}
					noBoom = false;
				}
				
				if(arrlist.size() == 0) break;
				
				//더 이상 폭발하는 구슬이 없을 때까지 반복
				if(i >= arrlist.size()-4 && !noBoom) {
					i = -1;
					noBoom = true;
				}
			}
			
			//구슬 변화 단계
			ArrayList<Integer> new_arrlist = new ArrayList<>();
			int arrlist_size = arrlist.size();
			int color = 0;
			int cnt = 0;
			for (int i = 0; i < arrlist_size-1; i++) {
				color = arrlist.get(i);
				cnt++;
				
				int next_color = arrlist.get(i+1);
				if(color != next_color) {
					new_arrlist.add(cnt);
					new_arrlist.add(color);
					cnt = 0;
					if(i == arrlist_size-2) {
						new_arrlist.add(1);
						new_arrlist.add(arrlist.get(arrlist_size-1));
					}
				} else if(color == next_color && i == arrlist_size-2) {
					new_arrlist.add(cnt+1);
					new_arrlist.add(color);
				}
			}
			
			map = new int[N][N];

			xy0 = true;
			x = sharkX;
			y = sharkY;
			count = 1;
			twice = 0;
			int idx = 0;
			int new_arrlist_size = new_arrlist.size();

			while(xy0) {
				L:for (int i = 0; i < 4; i++) {
					if(twice == 2) {
						count++;
						twice = 0;
					}
					
					for (int j = 0; j < count; j++) {
						x += rx[i];
						y += ry[i];
						
						if(idx < new_arrlist_size) {
							map[x][y] = new_arrlist.get(idx);
							idx++;
						}
						
						if(x == 0 && y == 0) {
							xy0 = false;
							break L;
						}
					}
					twice++;
				}
			}
		}
		
		int sum = 0;
		for (int i = 1; i < answer.length; i++) {
			sum += i*answer[i];
		}
		
		System.out.println(sum);
	}

}
