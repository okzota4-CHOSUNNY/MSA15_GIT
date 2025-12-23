package day02;

import java.util.Scanner;

public class Ex10_중첩If {
	
	public static void main(String[] args) {
		// 정보처리기사 합격 기준
		// * 응시자격 : 대학교 4학년
		// * 점수		: 60점 이상
		// 합격!
		// 불합격!
		// 응시자격이 없습니다.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("학년 : ");
		int year = sc.nextInt();
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		//4학년
		if( year == 4 ) {
			// 60점 이상
			if( score >= 60 ) {
				System.out.println("합격!");
			}
			else {
				System.out.println("불합격!");
			}
		} else {
			System.out.println("응시자격이 없습니다.");
		}
		
		// 조건문을 중첩하지 않고 조건을 작성할 수 있다면,
		// 중첩되지 않는 형태로 작성하는 것을 권장한다.
		// 방법1
		if( year == 4 && score >= 60 )
			System.out.println("합격!");
		else if( year == 4 )
			System.out.println("불합격!");
		else
			System.out.println("응시자격이 없습니다.");
		
		// 방법2
		if( year != 4 )
			System.out.println("응시자격이 없습니다.");
		else if( score >= 60)
			System.out.println("합격!");
		else
			System.out.println("불합격!");
		
		sc.close();
	}

}
