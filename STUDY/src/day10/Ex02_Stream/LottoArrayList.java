package day10.Ex02_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LottoArrayList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 게임 : ");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.print("[" + (i+1) + "게임] : ");
			ArrayList<Integer> lottoList = new ArrayList<Integer>();
			
			for (int j = 0; j < 6; j++) {
				int rand = (int) (Math.random() * 45 + 1);
				
				// 중복 제거
				if( lottoList.contains(rand) ) j--;
				else lottoList.add(rand);
			} 
			
			// 정렬
			Collections.sort( lottoList );
			
			// 출력
			for (Integer lotto : lottoList) {
				System.out.print(lotto + " ");
			}
			System.out.println();
		}
		sc.close();
	}
	
}






