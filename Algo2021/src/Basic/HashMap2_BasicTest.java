package Basic;

import java.util.HashMap;

public class HashMap2_BasicTest {

	public static void main(String[] args) {
		System.out.println("=== putIfAbsent ===");
		putIfAbsent();
		System.out.println();
		
		System.out.println("=== computeIfAbsent ===");
		computeIfAbsent();
		System.out.println();
		
		System.out.println("=== compute ===");
		compute();
		System.out.println();
		
		System.out.println("=== computeIfPresent ===");
		computeIfPresent();
		System.out.println();
		
		System.out.println("=== merge ===");
		merge();
		System.out.println();
		
		System.out.println("=== getOrDefault ===");
		getOrDefault();
		System.out.println();
	}

	public static void putIfAbsent() {
		HashMap<String, Integer> map1 = new HashMap<>();
		
		System.out.println(map1.put("Apple", 3));
		System.out.println(map1.put("Apple", 5));
		System.out.println(map1);
		
		HashMap<String, Integer> map2 = new HashMap<>();
		
		System.out.println(map2.putIfAbsent("Apple", 3));
		System.out.println(map2.putIfAbsent("Apple", 5));
		System.out.println(map2);
	}
	
	private static void computeIfAbsent() {
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("Apple", 3);
		
		System.out.println(map.computeIfAbsent("Apple", key -> key.length()));
		System.out.println(map.computeIfAbsent("Banana", key -> key.length()));
		System.out.println(map);
	}
	
	private static void compute() {
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("Apple", 3);
		System.out.println(map);
		
		System.out.println(map.compute("Apple", (key, value) -> key.length() + value));
		System.out.println(map);
		
		//NullPointerException
		//System.out.println(map.compute("Banana", (key, value) -> key.length() + value));
	}
	
	private static void computeIfPresent() {
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("Apple", 3);
		System.out.println(map);
		
		System.out.println(map.computeIfPresent("Apple", (key, value) -> key.length() + value));
		System.out.println(map.computeIfPresent("Banana", (key, value) -> key.length() + value));
		System.out.println(map);
	}
	
	private static void merge() {
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("Apple", 3);
		map.put("Banana", 5);
		System.out.println(map);
		
		System.out.println(map.merge("Apple", 10, (oldValue, newValue) -> oldValue + newValue));
		System.out.println(map);
		
		System.out.println(map.merge("Apple", 10, (oldValue, newValue) -> map.get("Lemon")));
		System.out.println(map);
		
		System.out.println(map.merge("Apple", 10, (oldValue, newValue) -> map.get("Lemon")));
		System.out.println(map);
	}
	
	private static void getOrDefault() {
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("Apple", 3);
		
		System.out.println(map.getOrDefault("Apple", 0));
		System.out.println(map.getOrDefault("Banana", 0));
		System.out.println(map);
	}

}