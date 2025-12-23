package day02;

import java.util.Scanner;

public class Ex11_Switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("채널 : ");
		int channel = sc.nextInt();
		
		switch (channel) {
		case 11:
			System.out.println("MBC - 굿데이");
			break;
		case 24:
			System.out.println("ENA - 나는솔로 - 데프콘");
			break;
		case 100:
			System.out.println("넷플릭스 - 은중과 상연, 다루얼질지니");
			break;
		case 101:
			System.out.println("왓챠, 티핑, 쿠팡플레이, 디즈니 플러스");
			break;
		default:
			System.out.println("코딩밖에 안함");
			break;
					
		}
		sc.close();
	}
}
