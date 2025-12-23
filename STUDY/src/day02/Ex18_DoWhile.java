package day02;

import java.util.Scanner;

public class Ex18_DoWhile {

	public static void main(String[] args) {
		// 메뉴판
		// * 변수 선언 : 메뉴번호, 메뉴이름, 메뉴개수
		int menuNo = 0;
		String menuName = " ";
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("::::: 메뉴판 :::::");
			System.out.println("1. 오구당당");
			System.out.println("2. 김밥");
			System.out.println("3. 새우버거");
			System.out.println("4. 쫄면+김밥");
			System.out.println("5. 해장국");
			System.out.println("0. 종료");
			System.out.print("메뉴 번호 : ");
			
			// 메뉴번호 입력
			menuNo = sc.nextInt();
			
			// break: 제어문을 탈출하는 키워드
			if( menuNo == 0 ) break;
			
			switch (menuNo) {
				case 1: menuName = "오구당당"; break;
				case 2: menuName = "김밥"; break;
				case 3: menuName = "새우버거"; break;
				case 4: menuName = "쫄면+김밥"; break;
				case 5: menuName = "해장국"; break;
				default: break;
			}
			// 유효성 검사
			// - 메뉴번호가 0~5번만 유효
			if( menuNo >= 0 && menuNo <= 5 ) {
				System.out.println(menuName + "(을/를) 주문하였습니다.");
				count++;
			}
			else {
				System.out.println("(0~5)번 사이의 번호를 입력해주세요.");
			}
		} while ( menuNo != 0 );
		
		System.out.println(count + "개의 메뉴를 주문하였습니다.");
		System.out.println("메뉴판을 종료합니다.");
		sc.close();
		
	}
}
