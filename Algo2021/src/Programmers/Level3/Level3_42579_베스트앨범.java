package Programmers.Level3;

import java.util.*;

public class Level3_42579_베스트앨범 {
	
	static class Play {
		int index;
		int play;
		public Play(int index, int play) {
			this.index = index;
			this.play = play;
		}
	}
	
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		System.out.println(Arrays.toString(solution(genres, plays)));
	}

	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, ArrayList<Play>> maplist = new HashMap<String, ArrayList<Play>>();
		
		for(int i = 0; i < genres.length; i++) {
			if(map.containsKey(genres[i])) map.put(genres[i], map.get(genres[i])+plays[i]);
			else map.put(genres[i], plays[i]);
			
			ArrayList<Play> list = new ArrayList<>();
			if(maplist.containsKey(genres[i])) {
				list = maplist.get(genres[i]);
				list.add(new Play(i, plays[i]));
			} else list.add(new Play(i, plays[i]));
			
			Collections.sort(list, new Comparator<Play>() {
				@Override
				public int compare(Play o1, Play o2) {
					if(o1.play == o2.play) return o1.index - o2.index;
					return o2.play - o1.play;
				}
			});
			
			maplist.put(genres[i], list);
		}
		
		List<String> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> (map.get(o2) - map.get(o1)));
		
		int size = map.size()*2;
		ArrayList<Integer> answerList = new ArrayList<>();
		int cnt = 0;
		
		for(String key : keySetList) {
			answerList.add(maplist.get(key).get(0).index);
			if(maplist.get(key).size() > 1) answerList.add(maplist.get(key).get(1).index);
		}
		
		int answerSize = answerList.size();
		int[] answer  = new int[answerSize];
		for(int i = 0; i < answerSize; i++) {
			answer[i] = answerList.get(i).intValue();
		}
		
		return answer;
	}
	
}
