package Programmers.Level3;

import java.util.*;

public class Level3_43164_여행경로 {
	
	static ArrayList<String> answerList;

	public static void main(String[] args) {
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		System.out.println(Arrays.toString(solution(tickets1)));
		String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		System.out.println(Arrays.toString(solution(tickets2)));
	}
	
	public static String[] solution(String[][] tickets) {
		String[] answer = {};
		answerList = new ArrayList<>();
		boolean[] visited = new boolean[tickets.length]; //사용 체크
		
		dfs(tickets, visited, 0, "ICN", "ICN");
		Collections.sort(answerList);
		answer = answerList.get(0).split(" ");
		
		return answer;
	}
	
	public static void dfs(String[][] tickets, boolean[] visited, int cnt, String start, String route) {
		if(cnt == tickets.length) {
			answerList.add(route);
			return;
		}
		
		for(int i = 0; i < tickets.length; i++) {
			if(!visited[i] && tickets[i][0].equals(start)) {
				visited[i] = true;
				dfs(tickets, visited, cnt+1, tickets[i][1], route+" "+tickets[i][1]);
				visited[i] = false;
			}
		}
	}

}