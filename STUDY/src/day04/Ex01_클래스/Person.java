package day04.Ex01_클래스;

	// 클래스
	// - 변수		: 이름, 나이
	// - 메소드	: 밥먹기, 일하기
public class Person {

	// 변수
	String name;		// 이름
	int age;			// 나이
	
	// 메소드
	// 접근지정자 (static) 반환타입 메소드명 ( 매개변수 ) { }
	
	// 밥먹기
	public void eat( String menu ) {
		System.out.println(menu + "(을/를) 먹었습니다.");
	}
	
	// 일하기
	public int work( String name, int hour ) {
		int money = 10030;
		int salary = money * hour;
		System.out.println(name + " 일을 하여 ");
		System.out.println(salary + " 원을 벌었습니다.");
		return salary;
	}
}
