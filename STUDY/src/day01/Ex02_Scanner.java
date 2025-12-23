package day01;

import java.util.Scanner;

public class Ex02_Scanner {

	// main : ctrl + space
	public static void main(String[] args) {
		// 객체 생성 키워드 : new
		// 클래스타입 객체명 = new 클래스명();
		// Scanner : 표준 입력 객체
		Scanner sc = new Scanner(System.in);
		// (경고) (Warning)	: 노란색 밑줄로 표시
		//					- 경고가 발생해도, 프로그램 실행 가능
		// (에러) (Error)		: 빨간색 밑줄로 표신
		//					- 에러가 발생하면, 프로그램 실행 불가
		
		System.out.println("a : ");
		int a = sc.nextInt();			//nextInt(): 정수 하나를 입력받는 메소드
		System.out.println("a : " + a);
		
		sc.close();		//close() : 객체를 메모리에서 해제하는 메소드
	}
}
