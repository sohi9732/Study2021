package Programmers;

public class Level3_42884_단속카메라 {

	public static void main(String[] args) {
		int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
		System.out.println(solution(routes));
	}
	
	public static int solution(int[][] routes) {
		int answer = 0;
		int N = routes.length;
		boolean[] flag = new boolean[N];
		
		boolean keep = true;
		while(keep) {
			int firstOut = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) { //가장 먼저 나가는 차 찾기
				if(!flag[i] && routes[i][1] <= firstOut) 
					firstOut = routes[i][1];
			}
			
			for(int i = 0; i < N; i++) {
				if(routes[i][0] <= firstOut && firstOut <= routes[i][1])
					flag[i] = true; //카메라 설치하기
			}
			answer++;
			
			keep = false;
			for(int i = 0; i < N; i++) {
				if(!flag[i]) //아직 카메라가 안 지나간 차가 있으면
					keep = true;
			}
		}
		
		return answer;
	}

}
