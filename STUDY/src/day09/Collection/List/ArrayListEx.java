package day09.Collection.List;

import java.util.ArrayList;

public class ArrayListEx {
	
	public static void main(String[] args) {
		// ArrayList 생성 - 쇼핑 카트 (장바구니)
		ArrayList<String> shoppingCart = new ArrayList<String>();
		
		// 요소 추가
		shoppingCart.add("과자");
		shoppingCart.add("우유");
		shoppingCart.add("초밥");
		
		// 반복 출력
		System.out.println("::::: 장바구니 목록 :::::");
		for (String item : shoppingCart) {
			System.out.print(item + " ");
		}
		System.out.println();
		
		// 특정 위치에 요소 추가 - add(index)
		shoppingCart.add(1, "라면");
		shoppingCart.add(2, "파인애플");
		System.out.println("::::: 위치에 요소 추가 :::::");
		System.out.println(shoppingCart);
		
		// 요소 제거
		boolean deleted = shoppingCart.remove("바나나");
		System.out.println("::::: 요소 제거 :::::");
		System.out.println("제거 여부 : " + deleted);
		
		// 요소 접근
		String item = shoppingCart.get(2);
		System.out.println("세 번째 아이템 : " + item);
		
		// 요소 확인
		boolean hasItem = shoppingCart.contains("파인애플");
		if( hasItem ) System.out.println("파인애플이 있습니다.");
		else System.out.println("파인애플이 없습니다.");
		
		// 모든 요소 제거
		shoppingCart.clear();
		System.out.println("::::: 모든 요소 제거 :::::");
		System.out.println(shoppingCart);
		
	}

}
