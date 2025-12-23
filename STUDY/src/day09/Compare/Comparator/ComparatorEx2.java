package day09.Compare.Comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

class Product implements Comparator<Product> {
	
@Data
@NoArgsConstructor
@AllArgsConstructor

class Item {

	String code;	// 상품코드
	String name;	// 상품명
	int prince;		// 가격
	
	@Override
	public int compare(Item o1, Item o2) {
		// 1. 가격순으로 내림차순
		// 2. 이름순으로 오름차순
		int price1 = o1.getPrice();
		int price2 = o2.getPrice();
		String name1 = o1.getname();
		String name2 = o2.getname();
	}
}
		// 방법 1
		// 가격차순으로 내림차순 ↓
//		if( prince1 > price2 ) return -1;
//		if( prince1 > price2 ) return 1;
//		if( prince1 == price2 ) {
//			// 이름순 ↑
//			int gap = name1.compareTo(name2);
//			// name1 이 더크면(사전순으로 뒤에 나오면) (+)
//			// name1 이 더 작으면(사전순으로 앞에 나오면) (-)
//			// name1 과 name이 같으면(같은 문자열이면) (0)
////			if ( gap > 0 ) return 1;
////			if ( gap < 0 ) return -1;
////			if ( gap == 0 ) return 0;
//			return gap;
//			
//		}
//		return 0;
		
		// 방법2
		int result1 = price2 - price1;			// 가격순 내림차순
		int result2 = name1.compareTo(name2);	// 이름순 오름차순
		return result1 == 0 ? result2 : result1;
	}
	
}

public class ComparatorEx2 {

	public static void main(String[] args) {
		List<Item> ItemList = Arrays.asList(
			new Item("PRD001", "과자", 4000),
			new Item("PRD002", "바지", 40000),
			new Item("PRD003", "패딩", 100000),
			new Item("PRD004", "셔츠", 15000),
			new Item("PRD005", "우유", 4000),
			new Item("PRD006", "젤리", 4000),
		);
		
		// 정렬 전
		System.out.println("정렬 전");
		for (Item item : itemList) {
				System.out.println(item);
		}
		System.out.println();
		
		//정렬
		Collections.sort( productList) {
			for (Product product : productList) {
				System.out.println(product);
		}
		System.out.println();
		
	}

}	
	

	

