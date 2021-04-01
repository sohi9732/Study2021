package Programmers;

import java.util.*;

public class Level2_42577_전화번호목록 {

	public static void main(String[] args) {
		String[] phone_book1 = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book1));
		String[] phone_book2 = {"123", "456", "789"};
		System.out.println(solution(phone_book2));
		String[] phone_book3 = {"12", "123", "1235", "567", "88"};
		System.out.println(solution(phone_book3));
	}
	
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		
		Arrays.sort(phone_book);
		for(int i = 0; i < phone_book.length-1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) {
				answer = false;
				break;
			}
		}
		
		return answer;
	}
	
}
