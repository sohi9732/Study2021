package Samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Silver1_20055_컨베이어벨트위의로봇 {
	
	static class Block {
		boolean robot;
		int weight;
		public Block(boolean robot, int weight) {
			this.robot = robot;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Block> belt = new ArrayList<>();
		int zero_cnt = 0;
		int step = 0;
		
		//컨베이어 벨트 입력
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < 2*N; i++) {
			belt.add(new Block(false, Integer.parseInt(st.nextToken())));
		}
		
		while(zero_cnt < K) {
			step++;
			
			//step1
			if(belt.get(N-1).robot) belt.get(N-1).robot = false;
			belt.add(0, belt.get(belt.size()-1));
			belt.remove(belt.size()-1);
			
			//step2
			if(step != 1) {
				if(belt.get(N-1).robot) belt.get(N-1).robot = false;
				for(int i = N-1; i > 0; i--) {
					if(belt.get(i-1).robot && !belt.get(i).robot && belt.get(i).weight >= 1) {
						belt.get(i).robot = true;
						belt.get(i-1).robot = false;
						belt.get(i).weight--;
						if(belt.get(i).weight == 0) zero_cnt++;
					}
				}
			}
			
			//step3
			if(belt.get(0).weight > 0) {
				belt.get(0).robot = true;
				belt.get(0).weight--;
				if(belt.get(0).weight == 0) zero_cnt++;
			}
		}
		
		System.out.println(step);
	}

}
