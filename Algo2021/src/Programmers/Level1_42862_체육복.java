package Programmers;

public class Level1_42862_체육복 {

	public static void main(String[] args) {
		int[] lost1 = {2, 4};
		int[] reserve1 = {1, 3, 5};
		System.out.println(solution(5, lost1, reserve1));
		int[] lost2 = {2, 4};
		int[] reserve2 = {3};
		System.out.println(solution(5, lost2, reserve2));
		int[] lost3 = {3};
		int[] reserve3 = {1};
		System.out.println(solution(3, lost3, reserve3));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] students = new int[n+1];
		
		for(int i = 0; i < students.length; i++) { //체육복 1개로 초기화
			students[i] = 1;
		}
		
		for(int i = 0; i < reserve.length; i++) { //여벌 있는 사람
			students[reserve[i]]++;
		}
		
		for(int i = 0; i < lost.length; i++) { //잃어버린 사람
			students[lost[i]]--;
		}
		
		//체육복 빌려주기
		for(int i = 1; i < students.length; i++) {
			if(students[i] == 0) {
				if(i+1 < students.length && students[i+1] == 2) {
					students[i]++;
					students[i+1]--;
				}
				else if(i-1 > 0 && students[i-1] == 2) {
					students[i]++;
					students[i-1]--;
				}
			}
		}
		
		for(int i = 1; i < students.length; i++) {
			if(students[i] > 0) answer++;
		}
		
		return answer;
	}

}
