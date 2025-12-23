package day05.Ex04_instanceof;

import day04.Ex01_클래스.Person;
import day05.Ex01_상속.Pikachu;
import day05.Ex01_상속.Raichu;

public class Main {
	public static void main(String[] args) {
		String str = "Hello";
		
		// String은 Object의 하위 클래스이므로 true
		boolean result1 = str instanceof Object; 	//true
		
		// String은 CharSequence 인터페이스를 구현하므로 true
		boolean result2 = str instanceof CharSequence;		//true
		
		// String은 StringBuilder의 인스턴스가 아니므로 false
		// boolean result3 = str instanceof StringBuilder; // 컴파일 오류!
		
		// null은 어떤 타입의 인스턴스도 아님
		String nullStr = null;
		boolean result4 = nullStr instanceof String;	// false
		
		System.out.println("str instanceof Object: " + result1);
		System.out.println("str istanceof CharSequence: " + result2);
		System.out.println("nullStr instanceof String: " + result4);
		
		Raichu raichu = new Raichu();
		System.out.println(raichu instanceof Pikachu);
		System.out.println(raichu instanceof Raichu);
		
		Pikachu pikachu = new Pikachu();
		System.out.println(pikachu instanceof Pikachu);
		System.out.println(pikachu instanceof Raichu);
		
		if( pikachu instanceof Raichu ) {}
		if( pikachu instanceof Pikachu) {}
		
		// System.out.println(raichu instanceof Person);
		// instanceof : 부모 자식 관계에 있어야 타입을 확인할 수 있다.		
	}

}
