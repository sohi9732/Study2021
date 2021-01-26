package Kakao;

import java.util.*;

public class Internship2020_보석쇼핑 {

	public static void main(String[] args) {
		int[] answer = new int[1];
		String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		answer = solution(gems1);
		System.out.println(Arrays.toString(answer));
		String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
		answer = solution(gems2);
		System.out.println(Arrays.toString(answer));
		String[] gems3 = {"XYZ", "XYZ", "XYZ"};
		answer = solution(gems3);
		System.out.println(Arrays.toString(answer));
		String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		answer = solution(gems4);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(String[] gems) {
		int[] answer = {1, gems.length};
		
        //보석 종류 개수 구하기
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < gems.length; i++) map.put(gems[i],0);
		int cnt = map.size();
		
		int start = 0, end = 0;
		int size = Integer.MAX_VALUE;
		
		int min = 0;
        int max = 0;
        int nowSize = 0;
        int nowStart = 0;
        int nowEnd = 0;
		int cIndex = 0;
		
		while (true) {
            if(cIndex >= cnt) {
                int nowGem = map.get(gems[min]);
                map.put(gems[min], --nowGem);
                if(nowGem ==0) cIndex--;
                min++;
            }
            else if(max == gems.length) {
                break;
            }
            else {
                int nowGem = map.get(gems[max]);
                map.put(gems[max], ++nowGem);
                if(nowGem == 1) cIndex++;
                max++;
            }

            if(cIndex == cnt) {
                nowStart = min;
                nowEnd = max;
                nowSize = nowEnd - nowStart;
                if(nowSize < size) {
                    size = nowSize;
                    start = nowStart + 1 ;
                    end = nowEnd;
                }
            }
        }

        answer[0] = start;
        answer[1] = end;

        return answer;
    }

}
