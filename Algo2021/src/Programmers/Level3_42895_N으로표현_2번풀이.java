package Programmers;

/*
 * DFS
 */

public class Level3_42895_N으로표현_2번풀이 {

	static int n;
	static int target;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		System.out.println(solution(5, 12));
		answer = Integer.MAX_VALUE;
		System.out.println(solution(2, 11));
		answer = Integer.MAX_VALUE;
		System.out.println(solution(5, 31168));
	}
	
	public static int solution(int N, int number) {
		n = N;
		target = number;
		
		dfs(0, 0);
		
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}
	
	public static void dfs(int cnt, int prev) {
		if(cnt > 8) {
			answer = -1;
			return;
		}
		
		if(prev == target) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		int N = n;
		for(int i = 0; i < 8 - cnt; i++) {
			dfs(cnt+i+1, prev+N);
			dfs(cnt+i+1, prev-N);
			dfs(cnt+i+1, prev/N);
			dfs(cnt+i+1, prev*N);
			
			N = N * 10 + n;
		}
	}

}
