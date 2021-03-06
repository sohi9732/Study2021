package Programmers;

import java.util.*;

public class Level2_42586_기능개발 {

	public static void main(String[] args) {
		int[] progresses1 = {93, 30, 55};
		int[] speeds1 = {1, 30, 5};
		System.out.println(Arrays.toString(solution(progresses1, speeds1)));
		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution(progresses2, speeds2)));
	}
	
	public static Integer[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> progress = new ArrayList<>();
		ArrayList<Integer> speed = new ArrayList<>();
		
		for(int i = 0; i < progresses.length; i++) {
			progress.add(progresses[i]);
			speed.add(speeds[i]);
		}
		
		while(!progress.isEmpty()) {
			int size = progress.size();
			for(int i = 0; i < size; i++) {
				progress.set(i, progress.get(i)+speed.get(i));
			}
			
			int cnt = 0;
			while(!progress.isEmpty() && progress.get(0) >= 100) {
				progress.remove(0);
				speed.remove(0);
				cnt++;
			}
			if(cnt != 0) result.add(cnt);
		}
		
		Integer[] answer = new Integer[result.size()];
		answer = result.toArray(answer);
		
		return answer;
	}

}
