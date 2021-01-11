package Samsung;

import java.io.*;
import java.util.*;

/** 지도 회전하는 부분 복습 필요 **/
public class Gold4_20058_마법사상어와파이어스톰 {

	static int[][] map;
	static boolean[][] isVisited;
	static int L, size, cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		size = (int)Math.pow(2, N);
		
		map = new int[size][size];
		
		for (int i = 0; i < size; i++) { //얼음판 입력
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine(), " ");
		boolean[][] flag;

		while(Q-- > 0) { //파이어스톰 단계별 Q번 실행
			L = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
			//얼음판 돌리기
			for (int i = 0; i < size; i += L) {
				for (int j = 0; j < size; j += L) {
					rotate(i, j);
				}
			}
			//녹일 수 있는 얼음칸 찾기
			flag = new boolean[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(findMelt(i, j)) { //녹일 수 있는 칸이면
						flag[i][j] = true; //녹일 수 있다고 표시
					}
				}
			}
			//얼음 녹이기
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(flag[i][j] && map[i][j]>0) {
						map[i][j]--;
					}
				}
			}
		}
		
		int sum = 0; //남아있는 얼음의 합
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum += map[i][j];
			}
		}
		
		//가장 큰 얼음 덩어리 크기 찾기
		isVisited = new boolean[size][size];
		int[] ice = new int[size*size];
		int index = 0;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(map[i][j]>0) {
					cnt = 0;
					dfs(i, j);
					ice[index] = cnt;
					index++;
				}
			}
		}
		
		Arrays.sort(ice);
		
		System.out.println(sum);
		System.out.println(ice[ice.length-1]);
	}
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	private static void dfs(int x, int y) {
		isVisited[x][y] = true;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isPossible(nx, ny)) {
				dfs(nx, ny);
			}
		}
	}
	
	private static boolean isPossible(int x, int y) {
		if(x>=0 && x<size && y>=0 && y<size && map[x][y]>0 && !isVisited[x][y]) return true; //인접 얼음덩어리임
		return false;
	}
	
	private static boolean findMelt(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(canMelt(nx, ny)) { //녹일 수 있으면
				cnt++;
			}
		}
		if(cnt < 3) return true;
		return false;
	}
	
	private static boolean canMelt(int x, int y) {
		if(x>=0 && x<size && y>=0 && y<size && map[x][y]>0) return true; //녹일 수 있음
		return false;
	}

	private static void rotate(int x, int y) {
		int[][] temp = new int[L][L];
		//임시배열에 값 옮기기
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				temp[i][j] = map[x+L-1-j][y+i];
			}
		}
		//회전 결과 기존 배열에 업데이트
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				map[x+i][y+j] = temp[i][j];
			}
		}
	}

}
