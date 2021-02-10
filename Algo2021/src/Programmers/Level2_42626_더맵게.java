package Programmers;

import java.util.*;

public class Level2_42626_더맵게 {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		System.out.println(solution(scoville, 7));
	}
	
	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		//초기 오름차순 정렬
		for(int i = 0; i < scoville.length; i++) {
			queue.offer(scoville[i]);
		}
		
		int cnt = 0;
		boolean cant = false;
		while(queue.peek() < K) { //가장 작은 값이 K이상일 때까지
			if(queue.size() == 1) {
				cant = true;
				break;
			}
			int a = queue.poll();
			int b = queue.poll();
			queue.offer(a+(b*2));
			cnt++;
		}
		answer = cant ? -1 : cnt;
		
		return answer;
	}

}
