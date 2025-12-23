package day09.Collection.Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoSet {
	
	// 1~45 로또 번호를 6개 뽑는다.
	// 중복된 랜덤 수가 나온 경우 다시 뽑는다.
	public static void main(String[] args) {
		Set<Integer> lottoSet = new HashSet<Integer>();
		Random random = new Random();
		
		while( lottoSet.size() < 6 ) {
			int num = random.nextInt(45) + 1; // 1~6 랜덤수
			boolean check = lottoSet.add(num);
			if( !check ) {
				System.out.println(num + "번이 중복되어서 다시 뽑습니다.");
			}
		}
		System.out.println("로또 번호 : " + lottoSet);
	
		// 정렬
		// Set 컬렉션 자체는 순서가 없으므로,
		// 순서가 있는 List 컬렉션으로 변환하여 정렬할 수 있다.
		// HashSet --> ArrayList 로 변환
		List<Integer> lottoList = new ArrayList<Integer>( lottoSet );
		
		// 오름차순 정렬
		Collections.sort( lottoList );
		
		System.out.println("로또 번호 : " + lottoList);
	}

}
