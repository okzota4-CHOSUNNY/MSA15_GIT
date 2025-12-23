package day07.Ex05_예외처리;

import java.util.Scanner;

/**
 *  예외 처리
 *  ClassCastException 
 *  : 클래스 간의 타입 변환 시, 올바르지 않은 변환으로 인해 발생하는 예외
 *  - 업캐스팅이 전제되지 않은 다운캐스팅을 하는 경우
 *  - 부모/자식 관계가 아닌 클래스로 캐스팅하는 경우
 */
class Animal {}

class Dog extends Animal {}

class Cat extends Animal {}

public class ClassCast {
	// (부모 클래스)			(자식 클래스)
	//  Animal		<---     Dog, Cat
	//  Animal = Cat					[업캐스팅]
	//  Dog = (Dog) Animal<Cat>			[다운캐스팅] (불가)
	//  Cat 에서 업캐스팅한 Animal 을 Dog 로 다운 캐스팅할 수 없다.
	//  - Cat 을 Dog 로 타입 변환할 수 없다.
	
	public static void changeToDog(Animal animal) {  // 매개변수를 받는 과정에서 업캐스팅
													 // Animal animal = new Dog();
													 // Animal animal = new Cat();
		// 예외 메시지 :  java.lang.ClassCastException
		// 예외 상황	:  타입을 변환할 수 없는 클래스로 변환 시도 시 발생하는 예외
		try {
			Dog dog = (Dog) animal;
		} catch (Exception e) {
			System.err.println("Cat 을 Dog 로 변환할 수 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		Dog dog = new Dog();
		changeToDog(dog);			// 가능
		
		Cat cat = new Cat();
		changeToDog(cat);			// 불가능
	}

}
