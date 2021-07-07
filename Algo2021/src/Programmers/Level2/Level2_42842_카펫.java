package Programmers.Level2;

import java.util.Arrays;

public class Level2_42842_카펫 {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(solution(10, 2)));
		System.out.println(Arrays.toString(solution(8, 1)));
		System.out.println(Arrays.toString(solution(24, 24)));
	}
	
	public static int[] solution(int brown, int yellow) {
		int height = 0;
		int width = 0;
		
		brown -= 4;
		brown /= 2;
		
		for(int i = 1; i <= brown; i++) {
			height = i;
			width = brown-i;
			if(height*width == yellow) break;
		}
		
		int[] answer = {width+2, height+2};
		
		return answer;
	}

}
