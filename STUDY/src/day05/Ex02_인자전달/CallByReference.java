package day05.Ex02_인자전달;

import day05.Ex01_상속.Pikachu;

public class CallByReference {
	
	// 배열을 전달받아 배열 요소를 변경하는 메소드
	public static void setArr(int[] arr) {
		// 요소의 값을 10씩 곱해서 변경
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * 10;
		}
		System.out.println(":::: setArr() 메소드 ::::");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		// 참조 자체를 변경
		arr = new int[]{11,22,33,44,55};
	}
	
	// 객체를 전달받아 객체의 변수를 변경하는 메소드
	public static void setObject(Pikachu pikachu) {
		pikachu.energy = 1000;
		pikachu.type = "물";
		System.out.println(":::: setObject() 메소드 ::::");
		System.out.println(pikachu);
		System.out.println();
		// 참조 자체를 변경
		pikachu = new Pikachu(123);
	}
	
	public static void main(String[] args) {
		// 배열과 객체를 생성하여 메소드로 전달해보기
		int arr[] = {1,2,3,4,5};
		Pikachu pikachu = new Pikachu();
		
		System.out.println(":::: main() 메소드 ::::");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(pikachu);
		System.out.println();
		
		// 참조타입 전달
		setArr( arr );
		setObject( pikachu );
		
		System.out.println(":::: setXXX() 메소드 호출 후 ::::");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(pikachu);
		System.out.println();
		
	}
	

}