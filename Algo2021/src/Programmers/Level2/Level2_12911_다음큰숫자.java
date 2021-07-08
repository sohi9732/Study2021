package Programmers.Level2;

public class Level2_12911_다음큰숫자 {

	public static void main(String[] args) {
		System.out.println(solution(78));;
		System.out.println(solution(15));;
	}
	
	public static int solution(int n) {
		int answer = n;
		String binary = Integer.toBinaryString(n);
		
		int binaryCnt = 0;
		for(int i = 0; i < binary.length(); i++) {
			if(binary.charAt(i) == '1') binaryCnt++;
		}
		
		boolean flag = false;
		while(!flag) {
			answer++;
			String next = Integer.toBinaryString(answer);
			
			int nextCnt = 0;
			for(int i = 0; i < next.length(); i++) {
				if(next.charAt(i) == '1') nextCnt++;
			}
			
			if(binaryCnt == nextCnt) flag = true;
		}
		
		return answer;
	}

}
