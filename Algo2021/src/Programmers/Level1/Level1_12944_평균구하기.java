package Programmers.Level1;

public class Level1_12944_평균구하기 {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4};
		System.out.println(solution(arr1));
		int[] arr2 = {5, 5};
		System.out.println(solution(arr2));
	}
	
	public static double solution(int[] arr) {
		double answer = 0;
		
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		
		return answer/arr.length;
	}

}
