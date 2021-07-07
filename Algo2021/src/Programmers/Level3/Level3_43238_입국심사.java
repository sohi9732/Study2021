package Programmers.Level3;

public class Level3_43238_입국심사 {

	public static void main(String[] args) {
		int[] times = {7, 10};
		System.out.println(solution(6, times));
	}
	
	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		long left = 0; //최소
		long mid = 0; //중간값
		long right = 0; //최대
		
		for(int time : times) { //최댓값 찾기
			right = Math.max(right, time);
		}
		
		right *= n; //최댓값 * 사람 수(최대로 걸리는 시간)
		
		//이분탐색
		while(left <= right) {
			mid = (left+right)/2;
			long count = 0; //심사할 수 있는 사람 수
			
			for(int time : times) {
				count += mid/time;
			}
			
			if(count < n) { //더 검사해야 함
				left = mid + 1;
			} else { //검사 가능, 작은 범위에서 이분탐색해서 최소시간 찾기
				if(mid < answer) { //최소시간 갱신
					answer = mid;
				}
				right = mid - 1;
			}
		}
		
		return answer;
	}

}