package Programmers;

import java.util.*;

public class Level2_42583_다리를지나는트럭 {
	
	public static void main(String[] args) {
		int[] truck_weight1 = {7, 4, 5, 6};
		System.out.println(solution(2, 10, truck_weight1));
		int[] truck_weight2 = {10};
		System.out.println(solution(100, 100, truck_weight2));
		int[] truck_weight3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		System.out.println(solution(100, 100, truck_weight3));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
        int bridge_weight = 0;
        
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int truck : truck_weights) {
			trucks.offer(Integer.valueOf(truck));
		}
        
        //다리 큐에 다리 길이만큼 0으로 채워두기
        for(int i = 0; i < bridge_length; i++) {
        	bridge.offer(0);
        }
        
        while(trucks.size() > 0) {
        	if(bridge.size() == bridge_length) {
        		bridge_weight -= bridge.peek();
        		bridge.poll();
        	}
        	
            if(bridge_weight+trucks.peek() <= weight && bridge.size() <= bridge_length) { //새 트럭 진입 가능 경우
                bridge_weight += trucks.peek();
                bridge.offer(trucks.peek());
                trucks.poll();
            } else if(bridge_weight+trucks.peek() > weight) { //새 트럭 진입 불가능 경우
                bridge.offer(0);
            }
            answer++;
        }
        
        while(bridge.size() > 0) {
        	bridge.poll();
        	answer++;
        }
        
        return answer;
	}

}
