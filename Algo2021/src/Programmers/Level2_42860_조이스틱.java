package Programmers;

public class Level2_42860_조이스틱 {

	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));
		System.out.println(solution("JAN"));
	}
	
	public static int solution(String name) {
		int answer = 0;
		int len = name.length();
		int min_move = len-1; //좌우 이동 최댓값(하나씩 오른쪽으로 이동하는 경우)
		
		for(int i = 0; i < len; i++) {
			//조이스틱 최소 상하 이동(알파벳 교체)
			answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
			
			//조이스틱 최소 좌우 이동(커서 이동)
			//다음 알파벳이 A일 때의 최소 좌우 이동 횟수를 비교해야 함
			int next = i+1;
			
			while(next<len && name.charAt(next) == 'A') {
				next++;
			}
			
			min_move = Math.min(min_move, i+len-next+i);
		}
		
		answer += min_move;
		
		return answer;
	}

}
