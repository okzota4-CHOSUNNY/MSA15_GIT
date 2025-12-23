package day10.Ex01_Lambda;

/**
 * 람다식 사용하기 1. 함수형 인터페이스 정의 * @FunctionalInterface 어노테이션 지정 * 추상 메소드 1개만 정의 2.
 * 람다식 익명함수를 정의하여 인터페이스에 선언 3. 람다식 호출
 */

@FunctionalInterface // 컴파일러에 함수형 인터페이스임을 명시적으로 알림
interface FuncInterface1 {
	// @FunctionalInterface 지정 시, 추상 메소드가 없거나 2개이상이면 에러 발생
	void method();
}

@FunctionalInterface
interface FuncInterface2 {
	void method(String a, String b);
}

@FunctionalInterface
interface FuncInterface3 {
	String method();
}

@FunctionalInterface
interface FuncInterface4 {
	String method(String a, String b);
}

public class Ex01_LambdaFormat {

	public static void main(String[] args) {
		// 매개변수X, 반환타입 X 람다식
		// ( ) -> { System.out.printl(""); }
		// ( ) -> System.out.printl(""); *한 문장이면 중괄호 생략 가능

		FuncInterface1 fi1 = () -> System.out.println("자바람다식1");
		fi1.method();

		// 매개변수 O, 반환타입 X 람다식
		// (a, b) -> { System.out.printl(a + b); }
		FuncInterface2 fi2 = (a, b) -> {
			String result = a + b;
			System.out.println(result);
		};
		fi2.method("자바", "람다식2");

		// 매개변수 X, 반환타입 O 람다식
		FuncInterface3 fi3 = () -> {
			String a = "자바";
			String b = "람다식3";
			return a + b;
		};
		String result3 = fi3.method();
		System.out.println(result3);

		// 매개변수 O, 반환타입 O 람다식
		FuncInterface4 fi4 = (a, b) -> {
			return a + b;
		};
		// (에러) FuncInterface4 fi5 = (a, b) -> return a +b;
		// *return 문만 있을 땐 {} 생략 불가
		FuncInterface4 fi6 = (a, b) -> a + b;
		// *반환값만 있을 땐, return, {} 둘다 생략해야한다.

		String result4 = fi4.method("자바", "람다식4");
		String result6 = fi6.method("자바", "람다식6");
		System.out.println(result4);
		System.out.println(result6);
	}

}
