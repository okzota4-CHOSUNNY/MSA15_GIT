package day01;

import java.util.Scanner;

public class Ex09_Boolean {

	public static void main(String[] args) {
		// boolean
		// : true(참), false(거짓) 논리값만 가지는 자료형
		boolean check1 = false;
		boolean check2 = true;

		Scanner sc = new Scanner(System.in);
		boolean on = sc.nextBoolean();
		System.out.println("on : " + on);
	}

}