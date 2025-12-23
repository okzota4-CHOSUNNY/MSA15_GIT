package day09.Collection.List;

import java.util.LinkedList;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class Product {
	String name;			// 상품명
	int price;				// 가격
	int count;				// 재고수
}

public class LinkedListEx {

	public static void main(String[] args) {
		// LinkedList 생성 - 상품 목록
		LinkedList<Product> products = new LinkedList<>();
		Product product1 = new Product.ProductBuilder()
									  .name("기계식 키보드")
									  .price(50000)
									  .count(10)
									  .build();
		
		Product product2 = new Product.ProductBuilder()
									  .name("무선 마우스")
									  .price(30000)
									  .count(20)
									  .build();
		
		Product product3 = new Product.ProductBuilder()
									  .name("미니 손난로")
									  .price(15000)
									  .count(11)
									  .build();
		
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		// 첫 번째/마지막 요소 가져오기
		Product firstProduct = products.getFirst();
		Product lastProduct = products.getLast();
		System.out.println("첫 번째 상품 : " + firstProduct);
		System.out.println("마지막 상품 : " + lastProduct);
		
		// 첫 번째/마지막 요소 제거
		products.removeFirst();
		products.removeLast();
		
		// 첫 번째/마지막 요소 추가
		products.addFirst( new Product("모니터", 200000, 10) );
		products.addLast( new Product("컴퓨터", 1500000, 5) );
		System.out.println(products);
		
		System.out.println("상품 개수 : " + products.size());
		
		products.clear();
		System.out.println("::::: 상품 목록 :::::");
		System.out.println(products);
		
	}
}