package day02;

import java.util.Scanner;

public class Ex01_대입연산자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// 입력 객체 생성
		// (바로 엔터) : shift + enter
		System.out.print("x : ");
		int x = sc.nextInt();		// x값 입력
		System.out.print("y : ");
		int y = sc.nextInt();
		System.out.print("z : ");
		int z = sc.nextInt();
		
		// 합계, 평균
		int sum = x + y + z;
		double avg = sum / 3;
		// (double) = (int) / (int)
		// * int 는 정수 자료형으로, 실수의 소수부분을 표현 할 수 없다.
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		
		// 실수 연산
		double realAvg1 = (double) sum / 3;
		double realAvg2 = sum / 3.0;
		// (큰 자료형) + (작은 자료형) = (큰 자료형)
		// (double) + (int) = (double)
		// - 서로 다른 자료형 연산 시, 결과는 큰 자료형으로 변환된다.
		
		System.out.println("평균1 : " + realAvg1);
		System.out.println("평균2 : " + realAvg2);
		
	}
}
