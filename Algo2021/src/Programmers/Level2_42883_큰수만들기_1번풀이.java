package Programmers;

/*
 * 배열의 인덱스 이용
 */

public class Level2_42883_큰수만들기_1번풀이 {

	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
	}
	
	public static String solution(String number, int k) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		int pick = number.length() - k; //뽑아야 될 개수
		
		while(pick > 0) {
			int max = -1;
			for(int i = idx; i < number.length() - pick + 1; i++) {
				if(max < number.charAt(i)-'0') {
					max = number.charAt(i)-'0';
					idx = i;
				}
			}
			sb.append(max);
			pick--;
			idx++;
		}
		
		answer = sb.toString();
		return answer;
	}

}
