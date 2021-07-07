package Programmers.Level1;

import java.util.*;

public class Level1_42576_완주하지못한선수 {

	public static void main(String[] args) {
		//leo
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] completion1 = {"eden", "kiki"};
		System.out.println(solution(participant1, completion1));
		//vinko
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(participant2, completion2));
		//mislav
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion3 = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant3, completion3));
	}
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		boolean found = false;
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		for(int i = 0; i < completion.length; i++) {
		    if(!participant[i].equals(completion[i])) {
		        answer = participant[i];
		        found = true;
		        break;
		    }
		}
		
		if(!found) answer = participant[participant.length-1];
		
		return answer;
	}

}
