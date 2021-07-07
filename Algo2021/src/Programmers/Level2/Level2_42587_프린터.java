package Programmers.Level2;

import java.util.*;

public class Level2_42587_프린터 {

	static class Print {
		int priority;
		int index;
		public Print(int priority, int index) {
			this.priority = priority;
			this.index = index;
		}
	}
	
	public static void main(String[] args) {
		int[] priorities1 = {2, 1, 3, 2};
		System.out.println(solution(priorities1, 2));
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		System.out.println(solution(priorities2, 0));
	}
	
	public static int solution(int[] priorities, int location) {
		int answer = 1;
		int[] count = new int[10];
		
		Queue<Print> queue = new LinkedList<>();
		
		for(int i = 0; i < priorities.length; i++) {
			queue.offer(new Print(priorities[i], i));
			count[priorities[i]]++;
		}
		
		L:for(int i = 9; i > 0; i--) {
			while(count[i] > 0) {
				if(queue.peek().priority == i) { //최고 우선순위일 경우
					if(queue.peek().index == location) break L;
					queue.poll();
					answer++;
					count[i]--;
				} else { //뒤로 보내기
					queue.offer(queue.peek());
					queue.poll();
				}
			}
		}
		
		return answer;
	}

}
