package day11.Ex01_Srialization;

import java.io.Serializable;


	// 직렬화
	// * Serializable 인터페이스를 구현해야 직렬화 객체를 정의할 수 있다.
	// * 직렬화? 객체 -> 바이트 스트림
	
public class Person implements Serializable {
//	private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = 2L;
	private String name;
	private int age;
	// 변수 추가
	private String address;
	
	// 기본 생성자
	public Person() {
		
	}
	
	// 매개변수가 있는 생성자
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
}

	
