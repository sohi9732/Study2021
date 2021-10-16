package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Silver1_21608_상어초등학교 {
	static int[][] like_stdnt;
	static int N;
	static int[][] seats;
	
	static class Block {
		int r;
		int c;
		int blank_cnt;
		int like_cnt;
		public Block(int r, int c, int blank_cnt, int like_cnt) {
			this.r = r;
			this.c = c;
			this.blank_cnt = blank_cnt;
			this.like_cnt = like_cnt;
		}
	}
	
	static class Student {
		int r;
		int c;
		boolean isSeated;
		public Student(int r, int c, boolean isSeated){
			this.r = r;
			this.c = c;
			this.isSeated = isSeated;
		}
	}
	
	static class Cnt {
		int adj_cnt;
		int like_cnt;
		public Cnt(int adj_cnt, int like_cnt) {
			this.adj_cnt = adj_cnt;
			this.like_cnt = like_cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		int N2 = (int) Math.pow(N, 2);
		like_stdnt = new int[N2][5];
		int[][] like_stdnt_index = new int[N2+1][4];
		seats = new int[N][N];
		Student[] stdnt_info = new Student[N2+1];
		
		//좋아하는 학생 목록 입력
		for(int i = 0; i < N2; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				if(i == 0 && j == 0) {
					int first_stdnt = Integer.parseInt(st.nextToken());
					seats[1][1] = first_stdnt;
					stdnt_info[first_stdnt] = new Student(1, 1, true);
					like_stdnt[i][j] = first_stdnt;
				} else {
					like_stdnt[i][j] = Integer.parseInt(st.nextToken());
					if(j != 0) like_stdnt_index[like_stdnt[i][0]][j-1] = like_stdnt[i][j];
				}
			}
		}
		
		Cnt[][] candi_seat = new Cnt[N][N];
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		
		PriorityQueue<Block> queue = new PriorityQueue<>(new Comparator<Block>() {
			@Override
			public int compare(Block o1, Block o2) {
				if(o1.like_cnt == o2.like_cnt) {
					if(o1.blank_cnt == o2.blank_cnt) {
						if(o1.r == o2.r) return o1.c - o2.c;
						return o1.r - o2.r;
					}
					return o2.blank_cnt - o1.blank_cnt;
				}
				return o2.like_cnt - o1.like_cnt;
			}
		});
		
		//자리 앉히기
		for(int i = 1; i < like_stdnt.length; i++) {
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					candi_seat[x][y] = new Cnt(0, 0);
				}
			}
			
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					for(int d = 0; d < 4; d++) {
						int nx = x+dx[d];
						int ny = y+dy[d];
						if(isPossible(nx, ny)) {
							candi_seat[x][y].adj_cnt++;
						}
					}
				}
			}
			
			for(int j = 1; j < like_stdnt[i].length; j++) {
				if(stdnt_info[like_stdnt[i][j]] != null && stdnt_info[like_stdnt[i][j]].isSeated) {
					int x = stdnt_info[like_stdnt[i][j]].r;
					int y = stdnt_info[like_stdnt[i][j]].c;
					for(int d = 0; d < 4; d++) {
						int nx = x+dx[d];
						int ny = y+dy[d];
						if(isPossible(nx, ny)) {
							candi_seat[nx][ny].like_cnt++;
						}
					}
				}
			}
			
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					if(seats[x][y] == 0 && (candi_seat[x][y].adj_cnt != 0 || candi_seat[x][y].like_cnt != 0)) {
						queue.offer(new Block(x, y, candi_seat[x][y].adj_cnt, candi_seat[x][y].like_cnt));
					}
				}
			}
			
			//마지막 한 자리 남았는데 조건에 안 맞아서 큐에 아무것도 없는 경우
			if(queue.size() == 0) {
				for(int x = 0; x < N; x++) {
					for(int y = 0; y < N; y++) {
						if(seats[x][y] == 0) queue.offer(new Block(x, y, 0, 0));
					}
				}
			}
			
			int seat_r = queue.peek().r;
			int seat_c = queue.peek().c;
			
			seats[seat_r][seat_c] = like_stdnt[i][0];
			stdnt_info[like_stdnt[i][0]] = new Student(seat_r, seat_c, true);
			
			queue.clear();
		}
		
		//자리 앉힌 후 만족도 계산
		int satisfy_sum = 0;
		
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				int pow_cnt = 0;
				for(int d = 0; d < 4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(nx>=0 && ny>=0 && nx<N && ny<N) {
						for(int i = 0; i < 4; i++) {
							if(seats[nx][ny] == like_stdnt_index[seats[x][y]][i]) {
								pow_cnt++;
								break;
							}
						}
					}
				}
				
				int satisfy = 0;
				if(pow_cnt != 0) satisfy = (int) Math.pow(10, pow_cnt-1);
				
				satisfy_sum += satisfy;
			}
		}
		
		System.out.println(satisfy_sum);
	}

	private static boolean isPossible(int x, int y) {
		if(x>=0 && y>=0 && x<N && y<N && seats[x][y] == 0) return true;
		return false;
	}

}
