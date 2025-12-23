package day01;

public class Ex07_Long {

	public static void main(String[] args) {
		// int (4bytes : 32bits) : 2^32개 : 약 42억 개
		// int 수 표현 범위			: -21억xxx ~ 21억xxx
		
		// long (8byte : 64bits) : 2^64 개
		long ln1 = 1000;
		long ln2 = 2100000000;
		long ln3 = 2200000000L;
		// 자바에서 기본 정수는 int 타입으로 인식!
		// ** L 을 붙이지 않으면 기본정수를 int 로 인식해서 21억을 표현할 수 없다.
		
		System.out.println("1n1 : " + ln1);
		System.out.println("1n2 : " + ln2);
		System.out.println("1n3 : " + ln3);
	}
}