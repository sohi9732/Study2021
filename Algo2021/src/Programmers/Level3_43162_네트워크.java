package Programmers;

public class Level3_43162_네트워크 {
	
	static boolean[] flag;
	static boolean[][] adj;

	public static void main(String[] args) {
		int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(3, computers1));
		int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(solution(3, computers2));
	}
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		flag = new boolean[n];
		adj = new boolean[n][n];
		boolean loop = true;
		
		while(loop) {
			loop = false;
			for(int i = 0; i < n; i++) {
				if(!flag[i]) {
					loop = true;
					flag[i] = true;
					dfs(i, n, computers);
					answer++;
				}
			}
		}
		
		return answer;
	}
	
	public static void dfs(int start, int n, int[][] computers) {
		for(int i = 0; i < n; i++) {
			if(start != i && !adj[start][i] && computers[start][i] == 1) {
				adj[start][i] = true;
				adj[i][start] = true;
				flag[i] = true;
				dfs(i, n, computers);
			}
		}
	}

}
