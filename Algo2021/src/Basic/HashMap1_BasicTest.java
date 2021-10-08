package Basic;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMap1_BasicTest {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();

		System.out.println("1. put() 메서드를 이용한 요소 저장");
		map.put("Apple", 3);
		map.put("Banana", 2);
		map.put("Orange", 1);
		map.put("Blueberry", 7);
		map.put("Kiwi", 2);
		map.put("Peach", 4);
		printMap(map);

		//V remove(Object key)
		System.out.println("//V remove(Object key)");
		System.out.println("2. remove() 메서드를 이용한 요소 제거 (*제거하면서 값 반환)");
		System.out.println("'Melon'키 제거 후 반환 값 : " + map.remove("Melon"));
		System.out.println("'Kiwi'키 제거 후 반환 값 : " + map.remove("Kiwi"));
		System.out.println();
		printMap(map);

		//boolean remove(Object key, Object value)
		System.out.println("//boolean remove(Object key, Object value)");
		System.out.println("3. remove() 메서드를 이용한 요소 제거 (*기존 값을 올바르게 입력할 경우 가능)");
		System.out.println("'Peach'키 값 2로 제거 가능한가? " + map.remove("Peach", 2));
		System.out.println("'Peach'키 값 4로 제거 가능한가? " + map.remove("Peach", 4));
		System.out.println();
		printMap(map);
		
		System.out.println("4. keySet() 메서드를 이용한 키로 구성된 Set 객체 반환");
		System.out.println(map.keySet());
		System.out.println();
		
		System.out.println("5. size() 메서드를 이용한 요소의 총 개수");
		System.out.println("Map의 크기 : " + map.size());
		System.out.println();
		
		System.out.println("6. get() 메서드를 이용하여 키에 대응하는 값 반환");
		System.out.println("'Apple'키의 값 : " + map.get("Apple"));
		System.out.println("'Kiwi'키의 값 : " + map.get("Kiwi")); //없으면 null을 반환
		System.out.println();
		
		//V replace(K key, V value)
		System.out.println("//V replace(K key, V value)");
		System.out.println("7. replace() 메서드를 이용하여 키에 대응하는 값 변환");
		System.out.println("기존 'Blueberry'키의 값 : " + map.replace("Blueberry", 5));
		System.out.println("변환 후 'Blueberry'키의 값 : " + map.get("Blueberry"));
		System.out.println();
		
		//boolean replace(K key, V oldValue, V newValue)
		System.out.println("//boolean replace(K key, V oldValue, V newValue)");
		System.out.println("8. replace() 메서드를 이용하여 키에 대응하는 값 변환 (*기존 값을 올바르게 입력할 경우 가능)");
		System.out.println();
		System.out.println("* 불가능한 경우");
		System.out.println("기존 'Blueberry'키의 값 : " + map.get("Blueberry"));
		System.out.println("'Blueberry'키 값 4에서 8로 변환 가능한가? " + map.replace("Blueberry", 4, 8));
		System.out.println("변환 후 'Blueberry'키의 값 : " + map.get("Blueberry") + " - (변환X)");
		System.out.println();
		System.out.println("* 가능한 경우");
		System.out.println("기존 'Blueberry'키의 값 : " + map.get("Blueberry"));
		System.out.println("'Blueberry'키 값 5에서 8로 변환 가능한가? " + map.replace("Blueberry", 5, 8));
		System.out.println("변환 후 'Blueberry'키의 값 : " + map.get("Blueberry") + " - (변환O)");
		System.out.println();
		
		System.out.println("9. containsKey() 메서드를 이용한 특정 키 포함 여부 확인");
		System.out.println("Map이 'Banana'키를 포함하는가? " + map.containsKey("Banana"));
		System.out.println("Map이 'Cherry'키를 포함하는가? " + map.containsKey("Cherry"));
		System.out.println();
		
		System.out.println("10. containsValue() 메서드를 이용한 특정 값에 해당하는 키 포함 여부 확인");
		System.out.println("Map에 값이 '1'인 키가 있는가? " + map.containsValue(1));
		System.out.println("Map에 값이 '4'인 키가 있는가? " + map.containsValue(4));
		System.out.println();
		
		System.out.println("11. isEmpty() & clear() 메서드를 이용한 전체 요소 제거");
		//isEmpty() 메서드를 이용하여 맵이 비어있는지 확인
		System.out.println("Map이 비었는가? " + map.isEmpty());
		System.out.println("clear() 메서드 실행");
		map.clear(); //clear() 메서드를 이용한 전체 요소의 제거
		System.out.println("Map이 비었는가? " + map.isEmpty());
	}
	
	//맵 전체 출력 함수
	public static void printMap(HashMap<String, Integer> map) {
		System.out.println("< Map >");
		for(Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("(" + entry.getKey() + ", " + entry.getValue() + ")");
		}
		System.out.println();
	}

}