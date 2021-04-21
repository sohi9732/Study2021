package Kakao;

public class Internship2020_키패드누르기 {

	public static void main(String[] args) {
		int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		System.out.println(solution(numbers1, "right"));
		int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		System.out.println(solution(numbers2, "left"));
		int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		System.out.println(solution(numbers3, "right"));
	}
	
	public static String solution(int[] numbers, String hand) {
		String answer = "";
		
		int[] lefthand = {3, 0};
		int[] righthand = {3, 2};
		
		int[] x = {3, 0, 0, 0, 1, 1, 1, 2, 2, 2};
		int[] y = {1, 0, 1, 2, 0, 1, 2, 0, 1, 2};
		
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) { //왼손 사용
				answer += "L";
				lefthand[0] = x[numbers[i]];
				lefthand[1] = y[numbers[i]];
			} else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) { //오른손 사용
				answer += "R";
				righthand[0] = x[numbers[i]];
				righthand[1] = y[numbers[i]];
			} else { //2, 5, 8, 0
				int leftMove = Math.abs(x[numbers[i]]-lefthand[0]) + Math.abs(y[numbers[i]]-lefthand[1]);
				int rightMove = Math.abs(x[numbers[i]]-righthand[0]) + Math.abs(y[numbers[i]]-righthand[1]);
				
				if(leftMove == rightMove) { //거리가 같다면
					if(hand.equals("left")) {
						answer += "L";
						lefthand[0] = x[numbers[i]];
						lefthand[1] = y[numbers[i]];
					} else if(hand.equals("right")) {
						answer += "R";
						righthand[0] = x[numbers[i]];
						righthand[1] = y[numbers[i]];
					}
				} else if(leftMove < rightMove) { //왼손이 가깝다면
					answer += "L";
					lefthand[0] = x[numbers[i]];
					lefthand[1] = y[numbers[i]];
				} else if(leftMove > rightMove) { //오른손이 가깝다면
					answer += "R";
					righthand[0] = x[numbers[i]];
					righthand[1] = y[numbers[i]];
				}
			}
		}
		
		return answer;
	}

}
