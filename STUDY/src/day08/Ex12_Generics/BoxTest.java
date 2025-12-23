package day08.Ex12_Generics;

import day07.Ex04_빌더패턴.Pikachu;

public class BoxTest {

	public static void main(String[] args) {
		// 제네릭
		// -구조 : class 클래스명<타입매개변수1, 타입매개변수2> {}
		// -예시 : class Box <T> { }
		// -생성 : Box<타입> box = new Box<타입>();
		
		Box<String> box1 = new Box<String>();
		box1.setT("우유");
		String boxName = box1.getT();
		System.out.println("box1 : " + boxName);
		
		Box<Pikachu> box2 = new Box<Pikachu>();
		box2.setT( new Pikachu() );
		Pikachu pikachu = box2. getT();
		System.out.println("Pikachu : " + pikachu);
		
		// (에러) Box<int> numberBox = new Box<int>();
		// * 제네릭 기법의 타입으로는 "참조자료형"만 사용할 수 있다.
		// * 기본 타입은 지정할 수 없다.
		Box<Integer> numberBox = new Box<Integer>();
		numberBox.setT(100);
		System.out.println("numberBox : " + numberBox.getT());
		
		Box<int[]> snackBox = new Box<int[]>();
		snackBox.setT( new int[] {1,2,3,4,5} );
		int[] snackArr = snackBox.getT();
		for (int i : snackArr) {
			System.out.print(i + " ");
		}
	
}
	}

