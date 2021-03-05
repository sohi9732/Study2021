package Basic;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation1_BooleanArrayTest {

	static int N, R;
	static int[] input, number;
	static boolean[] isSelected;
	static int totalCnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		number = new int[R];

		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		permutation(0);
		System.out.println("총 경우의 수 : " + totalCnt);
	}

	private static void permutation(int cnt) { //cnt : 순열을 뽑는 자리
		if(cnt == R) { //기저조건
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			number[cnt] = input[i];
			isSelected[i] = true;
			permutation(cnt+1); //다음 자리의 순열 뽑기
			isSelected[i] = false;
		}
	}

}
