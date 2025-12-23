package day10.Ex01_Lambda;

import java.util.function.Supplier;

import day07.Ex12_접근지정자.A.Person;

public class Ex06_Standardinterface {

	public static void main(String[] args) {

		// 기본 람다식
		// Supplier<Person> lambda = () -> { return new Person(); };
		Supplier<Person> lambda = () -> new Person();
		Person p1 = lambda.get(); // 람다식을 통한 객체 생성
		p1.setName("김조은");
		System.out.println(p1.getName());

		// 생성자 참조
		Supplier<Person> constructorRef = Person::new;
		Person p2 = constructorRef.get(); // 생성자 참조를 통한 객체 생성
		p2.setName("이병헌");
		System.out.println(p2.getName());
	}

}