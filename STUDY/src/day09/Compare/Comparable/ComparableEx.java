package day09.Compare.Comparable;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

	class Person implements Comparable<Person> {
		
		String name;
		int age;
		
		/**
		 * copareTo()
		 * - 해당 객체 this 와 비교 객체 o의 크기 기준을 설정하여 반환하는 메소드
		 * return
		 * 		양수(1)		: 해당객체 > 비교객체
		 * 		0			: 해당객체 = 비교객체
		 * 		음수(-1)		: 해당객체 < 비교객체
		 */
		@Override
		public int compareTo(Person o) {
			// * 나이순으로 오름차순 정렬
			int thisAge = this.getAge();	// 해당객체의 나이
			int comAge = o.getAge();		// 비교객체의 나이
			
			// 방법1
//			if( thisAge > comAge ) {
//				return 1;
//			} else if( thisAge < comAge ) {
//				return -1;
//			} else {
//				return 0;
//			}

			// 방법2
//			return thisAge - comAge;
			
			// * 이름순으로 오름차순 정렬
			String thisName = this.getName();
			String comName = o.getName();
			int result = thisName.compareTo(comName);
			// : 해당문자열.compareTo(배교문자열)
			//   해당 문자열이 사전순으로 더 앞에 나오면 -
			//   같은 문자열 순서이면 0
			return -result;
			
	}



	public static void main(String[] args) {
		List<Person> personList = new LinkedList<Person>();
		personList.add( new Person("릴리", 24) );
		personList.add( new Person("해원", 23) );
		personList.add( new Person("설윤", 22) );
		personList.add( new Person("배이", 22) );
		personList.add( new Person("지우", 22) );
		personList.add( new Person("규진", 20) );
		
		// 정렬 전
		System.out.println("정렬 전");
		for (Person person : personList) {
			System.out.println(person);
		}
		System.out.println("------------------");
		
		// 정렬
		// * Person 클래스에 구현한 compareTo() 메소드에 비교기준에 따라 정렬
		Collections.sort( personList );
		// 정렬 후
		System.out.println("정렬 후");
		for (Person person : personList) {
			System.out.println(person);
		}
		System.out.println("------------------");
		
	}

}
		
		
		
		








		
		
		
		
		
		
		
		
		
		
