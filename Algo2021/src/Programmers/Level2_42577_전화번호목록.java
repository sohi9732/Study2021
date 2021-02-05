package Programmers;

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
        
        L:for(int i = 0; i < phone_book.length-1; i++) {
            for(int j = i+1; j < phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j]) || phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    break L;
                }
            }
        }
        
        return answer;
    }
	
}
