package day01;

public class Ex06_Int {
	
	 public static void main(String[] args) {
		 // 리터럴 : 프로그램에서 직접 표현한 값
		 // 정수 리터럴
		 // - 2진수		: 0,1
		 //				* 리터럴 : 0b숫자
		 
		 // - 10진수		: 0,1,2,3,4,5,6,7,8,9
		 
		 // - 8진수		: 0,1,2,3,4,5,6,7
		 //				* 리터럴 : 0숫자
		 
		 // -16진수		: 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F
		 //						A(10),B(11),C(12),D(13),E(14),F(15)
		 //				* 리터럴 : 0x숫자
		 
		 // 2진수
		 int var0= 0b1010;
		 System.out.println("var0 : " + var0);
		 
		 // 10진수
		 int var1= 10;
		 System.out.println("var1 : " + var1);
		 
		// 8진수
		int var2= 010;
		System.out.println("var2 : " + var2);
		
		// 10진수
		int var3= 0x10;
		System.out.println("var3 : " + var3);
	 }

}
