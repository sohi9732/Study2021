package Programmers;

public class Level3_43163_단어변환 {

	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution("hit", "cog", words1));
		String[] words2 = {"hot", "dot", "dog", "lot", "log"};
		System.out.println(solution("hit", "cog", words2));
	}
	
	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		boolean possible = false;
		
		for(String word : words) { //target이 있는지 확인
			if(target.equals(word)) possible = true;
		}
		if(!possible) return answer; //target이 없으면 0 return
		
		boolean[] flag = new boolean[words.length];
		dfs(begin, target, words, flag, 0);
		answer = min;
		
		return answer;
	}
	
	public static void dfs(String begin, String target, String[] words, boolean[] flag, int count) {
		int[] diff = new int[words.length];
		for(int i = 0; i < words.length; i++) {
			String word = words[i];
			int len = word.length();
			int cnt = 0;
			for(int j = 0; j < len; j++) {
				if(!flag[i] && begin.charAt(j) != word.charAt(j)) cnt++;
			}
			diff[i] = cnt;	
		}
		
		for(int i = 0; i < diff.length; i++) {
			if(diff[i] == 1 && !words[i].equals(target)) {
				flag[i] = true;
				dfs(words[i], target, words, flag, count+1);
			}
			else if(diff[i] == 1 && words[i].equals(target)) {
				if(min > count) min = count+1;
			}
		}
	}
	
}
