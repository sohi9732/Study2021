package Kakao;

import java.util.*;

/** DFS로 하면 시간초과 **/
public class Internship2020_경주로건설 {
	
	static class xy {
		int bx;
		int by;
        int x;
        int y;
        int cost;
		public xy(int bx, int by, int x, int y, int cost) {
			this.bx = bx;
			this.by = by;
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
    }
    static int size;
    static Queue<xy> queue;
    static boolean[][] flag;
    static int answer;

	public static void main(String[] args) {
		int[][] board1 = {{0,0,0},{0,0,0},{0,0,0}};
		System.out.println(solution(board1));
		int[][] board2 = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		System.out.println(solution(board2));
		int[][] board3 = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		System.out.println(solution(board3));
		int[][] board4 = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		System.out.println(solution(board4));
	}
	
	static public int solution(int[][] board) {
        size = board.length;
        queue = new LinkedList<>();
        flag = new boolean[size][size];
        answer = Integer.MAX_VALUE;
        
        board[0][0] = -1;
        queue.offer(new xy(0, 0, 0, 0, 0));
        bfs(board);
        
        return answer;
    }
    
	// 우, 하, 좌, 상
	static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static public void bfs(int[][] board) {
    	while(!queue.isEmpty()) {
    		xy q = queue.poll();
    		int bx = q.bx;
    		int by = q.by;
    		int x = q.x;
    		int y = q.y;
    		
    		if(x == size-1 && y == size-1) {
        		if(q.cost < answer) answer = q.cost;
        	}
    		
    		for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(isPossible(nx, ny, board)) {
					int cost = 0;
					
					if(bx == nx || by == ny) cost = q.cost + 100;
					else cost = q.cost + 600;
					
					if(board[nx][ny] == 0 || board[nx][ny] >= cost) {
						board[nx][ny] = cost;
						queue.offer(new xy(x, y, nx, ny, cost));
					}
				}
			}
    	}
    }
    
    static public boolean isPossible(int x, int y, int[][] board) {
        return x>=0 && x<size && y>=0 && y<size && board[x][y] != 1 && board[x][y] != -1;
    }

}
