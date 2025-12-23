package day10.Ex02_Stream;

import java.util.Scanner;

public class LottoArray {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 게임 : ");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.print("[" + (i+1) + "게임] : ");
			int lotto[] = new int[6];
			
			// 랜덤 수 6개를 대입
			for (int j = 0; j < lotto.length; j++) {
				int rand = (int) (Math.random() * 45 ) + 1; // 1~45 랜덤 수
				lotto[j] = rand;
				
				// 중복 제거
				for (int k = 0; k < j; k++) {
					// 현재 뽑은 랜덤 수가, 기존 수들과 같으면 다시 뽑는다.
					if( rand == lotto[k] ) {
						j--;		
						break;
					}
				}
			} // - 랜덤 수 6개 대입
			
			// 정렬 - 버블 정렬
			for (int j = 0; j < lotto.length-1; j++) {
				for (int k = 0; k < lotto.length-1-j; k++) {
					if( lotto[k] > lotto[k+1] ) {
						int temp = lotto[k];
						lotto[k] = lotto[k+1];
						lotto[k+1] = temp;
					}
				}
			} // - 정렬 끝
			
			// 출력
			for (int j = 0; j < lotto.length; j++) {
				System.out.print(lotto[j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
