package day09.Collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// 요소 추가
		map.put("릴리", 24);
		map.put("해원", 23);
		map.put("설윤", 22);
		map.put("배이", 22);
		map.put("지우", 22);
		map.put("규진", 20);
		
		map.put("조은", 20);
		
		// 기존에 있는 key "해원"을 중복해서 추가
		// * 중복해서 key를 추가하면, 마지막에 추가한 값으로 지정된다.
		map.put("해원", 99);
		
		System.out.println("총 인원수 : " + map.size());
		System.out.println();
		
		System.out.println("해원의 나이 : " + map.get("해원"));
		System.out.println("설윤의 나이 : " + map.get("설윤"));
		
		// 요소 제거
		map.remove("조은");
		
		// Map 반복
		Set<String> KeySet = map.keySet();
		for (String key : KeySet) {
			Integer value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		// Map 반복 2
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet. iterator();
		
		while( entryIterator.hasNext() ) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		System.out.println();
		
		// Map 반복 3 - formap
		// formap : ctrl + space
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + " : " + val);
		}
		System.out.println();
		
		System.out.println("총 개수 : " + map.size());
		map.clear();
		System.out.println("empty 여부 : " + map.isEmpty());
	}
}
