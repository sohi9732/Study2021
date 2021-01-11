package Kakao;

import java.util.*;

//"100-200*300-500+20"
//60420
//"50*6-3*2"
//300

public class Internship2020_수식최대화 {
	
	static ArrayList<Long> digits;
	static ArrayList<Character> op;

	public static void main(String[] args) throws Exception {
		System.out.println(solution("100-200*300-500+20"));		
		System.out.println(solution("50*6-3*2"));		
	}
	
	public static long solution(String expression) {
        long answer = 0;
        
        digits = new ArrayList<>();
        op = new ArrayList<>();
        
        // 숫자와 피연산자 연결리스트 각각 만들기
        int length = expression.length();
        Queue<Long> num = new LinkedList<>();
        for (int i = 0; i < length; i++) {
			if(expression.charAt(i) != '*' && expression.charAt(i) != '+' && expression.charAt(i) != '-') {
				num.offer((long)expression.charAt(i)-'0');
			} else { //연산자인 경우
				op.add(expression.charAt(i));
				char_to_int(num);
			}
		}
        //마지막 숫자 넣어주기
        char_to_int(num);
        
        long[] result = new long[6];
        
        result[0] = cal('*', '+', '-');
        result[1] = cal('*', '-', '+');
        result[2] = cal('+', '*', '-');
        result[3] = cal('+', '-', '*');
        result[4] = cal('-', '*', '+');
        result[5] = cal('-', '+', '*');
        Arrays.sort(result);
        answer = result[5];
        
        return answer;
    }

	private static long cal(char op1, char op2, char op3) {
		/** 깊은 복사 주의!! **/
		ArrayList<Long> number = (ArrayList<Long>) digits.clone();
		ArrayList<Character> operator = (ArrayList<Character>) op.clone();
		
		//1순위 계산
		for (int i = 0; i < operator.size(); i++) {
			if(operator.get(i) == op1) {
				number.set(i, whichOp(number.get(i), op1, number.get(i+1)));
				number.remove(i+1);
				operator.remove(i);
				i--;
			}
		}
		
		//2순위 계산
		for (int i = 0; i < operator.size(); i++) {
			if(operator.get(i) == op2) {
				number.set(i, whichOp(number.get(i), op2, number.get(i+1)));
				number.remove(i+1);
				operator.remove(i);
				i--;
			}
		}
		
		//3순위 계산
		for (int i = 0; i < operator.size(); i++) {
			if(operator.get(i) == op3) {
				number.set(i, whichOp(number.get(i), op3, number.get(i+1)));
				number.remove(i+1);
				operator.remove(i);
				i--;
			}
		}
		
		return Math.abs(number.get(0)); //절댓값 리턴
	}

	private static long whichOp(Long long1, char op, Long long2) {
		long result = 0;
		switch (op) {
		case '*':
			result = long1 * long2;
			break;
		case '+':
			result = long1 + long2;
			break;
		case '-':
			result = long1 - long2;
			break;
		default:
			break;
		}
		return result;
	}

	private static Queue<Long> char_to_int(Queue<Long> num) {
		if(num.size() == 1) { //한 자리 수인 경우
			digits.add(num.poll());
		} else if(num.size() == 2) { //두 자리 수인 경우
			long n = num.poll()*10;
			n += num.poll();
			digits.add(n);
		} else { //세 자리 수인 경우
			long n = num.poll()*100;
			n += num.poll()*10;
			n += num.poll();
			digits.add(n);
		}
		return num;
	}
	
	
}
