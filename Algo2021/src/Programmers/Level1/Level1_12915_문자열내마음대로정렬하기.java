package Programmers.Level1;

import java.util.Arrays;
import java.util.Comparator;

public class Level1_12915_문자열내마음대로정렬하기 {

	public static void main(String[] args) {
		String[] strings1 = {"sun", "bed", "car"};
		System.out.println(Arrays.toString(solution(strings1, 1)));
		String[] strings2 = {"abce", "abcd", "cdx"};
		System.out.println(Arrays.toString(solution(strings2, 2)));
	}
	
	public static String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(n) == o2.charAt(n)) {
					for(int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
						if(o1.charAt(i) != o2.charAt(i)) return o1.charAt(i) - o2.charAt(i);
					}
				}
				return o1.charAt(n) - o2.charAt(n);
			}
		});
		answer = strings;
		
		return answer;
	}

}
