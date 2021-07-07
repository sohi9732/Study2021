package Programmers.Level3;

import java.util.*;

public class Level3_42627_디스크컨트롤러 {

	static class Job {
		int start;
		int time;
		public Job(int start, int time) {
			this.start = start;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution(jobs));
	}
	
	public static int solution(int[][] jobs) {
		int answer = 0;
		int cur = 0;
		int sum = 0;
		
		//대기큐에 요청시간 오름차순 정렬
		PriorityQueue<Job> qWait = new PriorityQueue<>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.start - o2.start;
			}
		});
		
		for(int i = 0; i < jobs.length; i++) {
			qWait.offer(new Job(jobs[i][0], jobs[i][1]));
		}
		
		//작업큐에 소요시간 오름차순 정렬
		PriorityQueue<Job> qRun = new PriorityQueue<>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.time - o2.time;
			}
		});
		
		while(!qWait.isEmpty() || !qRun.isEmpty()) {
			while(!qWait.isEmpty() && qWait.peek().start <= cur) {
				qRun.offer(qWait.peek());
				qWait.poll();
			}
			
			if(!qRun.isEmpty()) {
				cur += qRun.peek().time;
				sum += cur - qRun.peek().start;
				qRun.poll();
			} else cur++;
		}
		
		answer = sum / jobs.length;
		return answer;
	}

}
