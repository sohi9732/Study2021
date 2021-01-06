package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_Ladder1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int[][] ladder = new int[100][100];
			int x = 0, y = 0;
			in.readLine();
			
			//입력
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(ladder[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			
			//첫째줄에 도달할 때까지
			while (x > 0) {
				x -= 1;
				//왼쪽
				if(y-1 >=0 && ladder[x][y-1] == 1) {
					do {
						y -= 1;
					} while (y-1 >= 0 && ladder[x][y-1] == 1);
				}
				//오른쪽
				else if(y+1 < 100 && ladder[x][y+1] == 1) {
					do {
						y += 1;
					} while (y+1 < 100 && ladder[x][y+1] == 1);
				}
			}
			
			System.out.println("#" + test_case + " " + y);
		}
	}

}
