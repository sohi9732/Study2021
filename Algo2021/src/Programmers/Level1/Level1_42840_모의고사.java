package Programmers.Level1;

import java.util.*;

public class Level1_42840_모의고사 {
	
	public static class Student {
		int n;
		int score;
		public Student(int n, int score) {
			this.n = n;
			this.score = score;
		}
	}

	public static void main(String[] args) {
		int[] answers1 = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(solution(answers1)));
		int[] answers2 = {1, 3, 2, 4, 2};
		System.out.println(Arrays.toString(solution(answers2)));
	}
	
	public static int[] solution(int[] answers) {
		int[] student1 = {1, 2, 3, 4, 5};
		int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int cnt1 = 0, cnt2 = 0, cnt3 = 0;
		int score1 = 0, score2 = 0, score3 = 0;
		
		for(int i = 0; i < answers.length; i++) {
			if(cnt1 == student1.length) cnt1 = 0;
			if(cnt2 == student2.length) cnt2 = 0;
			if(cnt3 == student3.length) cnt3 = 0;
			
			if(student1[cnt1] == answers[i]) score1++;
			if(student2[cnt2] == answers[i]) score2++;
			if(student3[cnt3] == answers[i]) score3++;
			
			cnt1++;
			cnt2++;
			cnt3++;
		}
		
		Student[] students = {new Student(1, score1), new Student(2, score2), new Student(3, score3)};
		
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.score - o1.score;
			}
		});
		
		int max = students[0].score;
		int cnt = 0;
		for(int i = 0; i < students.length; i++) {
			if(max == students[i].score) cnt++;
		}
		int[] answer = new int[cnt];
		for(int i = 0; i < students.length; i++) {
			if(max == students[i].score) answer[i] = students[i].n;
		}
		Arrays.sort(answer);
		
		return answer;
	}

}
