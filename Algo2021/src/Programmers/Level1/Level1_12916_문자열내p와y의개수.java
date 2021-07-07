package Programmers.Level1;

public class Level1_12916_문자열내p와y의개수 {

	public static void main(String[] args) {
		System.out.println(solution("pPoooyY"));
		System.out.println(solution("Pyy"));
	}
	
	static boolean solution(String s) {
		boolean answer = true;
		int pCnt = 0;
		int yCnt = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'p' || s.charAt(i) == 'P') pCnt++;
			if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') yCnt++;
		}
		
		if(pCnt != yCnt) answer = false;
		
		return answer;
	}

}
