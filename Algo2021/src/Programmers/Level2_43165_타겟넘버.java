package Programmers;

public class Level2_43165_타겟넘버 {

	static int N, targetNum, answer;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		System.out.println(solution(numbers, 3));
	}
	
	public static int solution(int[] numbers, int target) {
		targetNum = target;
		
		N = numbers.length;
		isSelected = new boolean[N];
		generateSubset(0, numbers);
		
		return answer;
	}
	
	public static void generateSubset(int cnt, int[] numbers) {
		if(cnt == N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) sum += numbers[i];
				else sum -= numbers[i];
			}
			if(sum == targetNum) answer++;
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt+1, numbers);
		
		isSelected[cnt] = false;
		generateSubset(cnt+1, numbers);
	}

}
