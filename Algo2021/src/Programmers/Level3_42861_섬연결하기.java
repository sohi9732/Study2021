package Programmers;

import java.util.*;

public class Level3_42861_섬연결하기 {

	static int[] parents;;
	
	public static void main(String[] args) {
		int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
		System.out.println(solution(4, costs));
	}
	
	public static int solution(int n, int[][] costs) {
		int answer = 0;
		parents = new int[n];
		Arrays.fill(parents, -1);
		
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		boolean[] flag = new boolean[costs.length];
		
		for(int i = 0; i < costs.length; i++) {
			if(!flag[i] && makeSet(costs[i][0], costs[i][1])) {
				flag[i] = true;
				answer += costs[i][2];
			}
		}
		
		return answer;
	}
	
	public static boolean makeSet(int n1, int n2) {
		int root1 = findSet(n1);
		int root2 = findSet(n2);
		if(root1 != root2) {
			parents[root2] = root1;
			return true;
		}
		return false;
	}
	
	public static int findSet(int n) {
		if(parents[n] < 0) return n;
		return parents[n] = findSet(parents[n]);
	}

}
