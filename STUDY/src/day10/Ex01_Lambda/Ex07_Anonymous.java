package day10.Ex01_Lambda;

/**
 * 익명 객체
 * - 익명 자식 객체
 * - 익명 구현 객체
 * 
 * 익명 함수
 */

// 익명 자식 객체의 부모 클래스 정의
class Television {
	void volumeUp() { System.out.println("UP"); }
	void volumeDown() { System.out.println("DOWN"); }
}

// 익명 구현 객체의 인터페이스 정의
interface RemoteControl {
	void volumeUp();
	void volumeDOWN();
}

// 익명 함수를 위한 함수형 인터페이스 정의
@FunctionalInterface
interface Calculator {
	int calc(int a, int b);
}

public class Ex07_Anonymous {

	public static void main(String[] args) {
		// 익명 자식 객체
		Television tv = new Television() {

			@Override
			void volumeUp() {
				System.out.println("UP - 자식");
			}

			@Override
			void volumeDown() {
				System.out.println("DOWN - 자식");
			}
		};
		tv.volumeUp();
		tv.volumeDown();
		
		// 익명구현 객체
		RemoteControl rc = new RemoteControl() {
			
			@Override
			public void volumeUp() {
				System.out.println("UP - 구현");
			}
			
			@Override
			public void volumeDOWN() {
				System.out.println("DOWN - 구현");
			}
		};
		rc.volumeUp();
		rc.volumeDOWN();
		
		// 익명 구현 객체2 : 객체지향 프로그래밍
		Calculator cal = new Calculator() {
			// 익명 함수
			@Override
			public int calc(int a, int b) {
				return a + b;
			}
		};
		int result1 = cal.calc(10, 20);
		System.out.println("result1 : " + result1);		
		
		// 익명 함수 (람다식) : 함수형 프로그래밍
		Calculator calLambda = (a, b) -> { return a + b; };
		int result2 = calLambda.calc(30, 40);
		System.out.println("result2 : " + result2);
}
}