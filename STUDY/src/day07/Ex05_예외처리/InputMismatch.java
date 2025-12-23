package day07.Ex05_예외처리;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatch {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menuNo = 0;
		String menuName = "";
		
		do {
			System.out.println("1. Java");
			System.out.println("2. HTML CSS JS");
			System.out.println("3. MySQL DB");
			System.out.println("4. Servlet/JSP");
			System.out.println("5. Spring Framework");
			System.out.println("6. React");
			System.out.println("7. Python");
			System.out.println("8. dJango");
			System.out.println("9. Node.js");
			System.out.println("10. Express");
			System.out.println("11. Flutter");
			System.out.println("0. 종료");
			System.out.print("입력 : ");
			
			// 예외 메시지 : java.util.InputMismatchException
			// 예외 상황 	: 숫자 입력 메소드에 문자를 입력한 경우
			try {
				// 예외 발생 가능성이 있는 문장
				menuNo = sc.nextInt();
			} catch (InputMismatchException e) {
				// 숫자를 입력하지 않았다면, 다시 반복해서 입력하도록 처리
				sc.next();
				System.err.println("(0~11) 번 사이의 숫자를 입력해주세요.");
				continue;
			}
			// 종료 조건
			if( menuNo == 0 ) break;
			
			switch (menuNo) {
				case 1: menuName = "Java"; break;
				case 2: menuName = "HTML CSS JS"; break;
				case 3: menuName = "MySQL DB"; break;
				case 4: menuName = "Servlet/JSP"; break;
				case 5: menuName = "Spring Framework"; break;
				case 6: menuName = "React"; break;
				case 7: menuName = "Python"; break;
				case 8: menuName = "dJango"; break;
				case 9: menuName = "Node.js"; break;
				case 10: menuName = "Express"; break;
				case 11: menuName = "Flutter"; break;
			}
			System.out.println(menuName + "(을/를) 공부를 합니다.");
		} while (true);
		
		sc.close();
	}

}
