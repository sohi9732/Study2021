package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Silver2_1931_회의실배정 {
	
	static class Meeting {
		int start;
		int end;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int max = 0;
		PriorityQueue<Meeting> queue = new PriorityQueue<>(new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				if(o1.end == o2.end) return o1.start - o2.start; //끝나는 시간 같다면 시작 시간 빠른 순 정렬
				return o1.end - o2.end; //끝나는 시간 빠른 순 정렬
			}
		});
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			queue.offer(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int now = queue.poll().end;
		max++;
		
		while(!queue.isEmpty()) {
			Meeting meeting = queue.poll();
			if(meeting.start >= now) {
				max++;
				now = meeting.end;
			}
		}
		
		System.out.println(max);
	}

}
