package Programmers.Level3;

public class Level3_42898_등굣길 {

	static int[][] map;
	
	public static void main(String[] args) {
		int[][] puddles = {{2, 2}};
		System.out.println(solution(4, 3, puddles));
	}
	
	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		
		map = new int[n][m];
		
		//맵 초기화
		map[0][0] = 1;
		for(int i = 0; i < puddles.length; i++) {
			map[puddles[i][1]-1][puddles[i][0]-1] = -1;
		}
		
		int[] dx = {0, 1};
		int[] dy = {1, 0};
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] != -1) {
					for(int k = 0; k < 2; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if(isPossible(x, y, m, n)) {
							map[x][y] += map[i][j] % 1000000007;
						}
					}
				}
			}
		}
		
		answer = map[n-1][m-1] % 1000000007;
		
		return answer;
	}
	
	public static boolean isPossible(int x, int y, int m, int n) {
		return x>=0 && x<n && y>=0 && y<m && map[x][y] != -1;
	}

}
