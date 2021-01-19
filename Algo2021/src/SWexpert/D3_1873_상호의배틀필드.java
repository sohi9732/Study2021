package SWexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1873_상호의배틀필드 {
	
	static int H, W;
	static char[][] map;
	static int carX;
	static int carY;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				String s = in.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						carX = i;
						carY = j;
					}
				}
			}
			
			int N = Integer.parseInt(in.readLine());
			String s = in.readLine();
			for (int i = 0; i < N; i++) {
				char input =  s.charAt(i);
				switch (input) {
				case 'U':
					up();
					break;
				case 'D':
					down();
					break;
				case 'L':
					left();
					break;
				case 'R':
					right();
					break;
				case 'S':
					shoot();
					break;
				default:
					break;
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static void up() {
		//전차가 바라보는 방향을 위쪽으로 바꾸고
		map[carX][carY] = '^';
		//한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
		if(isGround(carX-1, carY)) {
			map[carX-1][carY] = '^';
			map[carX][carY] = '.';
			carX -= 1;
		}
	}

	private static void down() {
		//전차가 바라보는 방향을 아래쪽으로 바꾸고
		map[carX][carY] = 'v';
		//한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
		if(isGround(carX+1, carY)) {
			map[carX+1][carY] = 'v';
			map[carX][carY] = '.';
			carX += 1;
		}
	}

	private static void left() {
		//전차가 바라보는 방향을 왼쪽으로 바꾸고
		map[carX][carY] = '<';
		//한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
		if(isGround(carX, carY-1)) {
			map[carX][carY-1] = '<';
			map[carX][carY] = '.';
			carY -= 1;
		}
	}

	private static void right() {
		//전차가 바라보는 방향을 오른쪽으로 바꾸고
		map[carX][carY] = '>';
		//한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
		if(isGround(carX, carY+1)) {
			map[carX][carY+1] = '>';
			map[carX][carY] = '.';
			carY += 1;
		}
	}

	private static boolean isGround(int x, int y) {
		return x>=0 && x<H && y>=0 && y<W && map[x][y] == '.';
	}

	private static void shoot() {
		//전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
		switch(map[carX][carY]) {		
		case '^':
			fire(0);
			break;		
		case 'v':
			fire(1);
			break;		
		case '<':
			fire(2);
			break;		
		case '>':
			fire(3);
			break;		
		default:
			break;
		}
			
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	private static void fire(int dir) {
		int nx = carX + dx[dir];
		int ny = carY + dy[dir];
		while(canGo(nx, ny)) {
			if(map[nx][ny] == '*') { //벽돌이면
				map[nx][ny] = '.'; //평지가 되고
				break; //전진 중지
			}
			nx += dx[dir];
			ny += dy[dir];
		}
	}

	private static boolean canGo(int x, int y) {
		return x>=0 && x<H && y>=0 && y<W && map[x][y] != '#';
	}

}
