package Programmers;

public class Level2_49993_스킬트리 {

	public static void main(String[] args) {
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution("CBD", skill_trees));
	}
	
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		
		String[] skillcase = new String[skill.length()];
		int index = 0;
		for(int i = 0; i < skillcase.length; i++) {
			String s = "";
			index++;
			for(int j = 0; j < index; j++) {
				s += skill.charAt(j);
			}
			skillcase[i] = s;
		}
		
		for(String skilltree : skill_trees) {
			String s = "";
			for(int i = 0; i < skilltree.length(); i++) {
				for(int j = 0; j < skill.length(); j++) {
					if(skilltree.charAt(i) == skill.charAt(j)) {
						s += skilltree.charAt(i);
						break;
					}
				}
			}
		
			if(s.length() == 0) {
				answer++;
				continue;
			}
		
			for(int i = 0; i < skillcase.length; i++) {
				if(skillcase[i].equals(s)) {
					answer++;
					break;
				}
			}
		}
		
		return answer;
	}

}
