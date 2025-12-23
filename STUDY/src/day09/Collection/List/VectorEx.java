package day09.Collection.List;

import java.util.Vector;


public class VectorEx {
	
	public static void main(String[] args) {
		// Vector 생성
		// - 학생 목록
		Vector<String> students = new Vector<String>();
		
		// 요소 추가 - add()
		students.add("김경화");
		students.add("정성준");
		students.add("조성진");
		students.add("김현수");
		students.add("박희진");
		
		System.out.println("::::: 학생 목록 :::::");
		System.out.println(students);
		System.out.println("------------------");
		
		// 요소 제거 - remove()
		students.remove("김현수");		// 객체 요소(인스턴스)로 제거
		students.remove(1);				// index 로 제거
		
		// 요소 접근
		String firstStudent = students.firstElement();
		String secondStudent = students.get(1);
		String lastStudent = students.getLast();
		
		System.out.println("첫 번째 학생 : " + firstStudent);
		System.out.println("두 번째 학생 : " + secondStudent);
		System.out.println("마지막 학생 : " + lastStudent);
		
		// 요소 개수 - size()
		int size = students.size();
		System.out.println("남은 학생 수 : " + size);
		
		// 모든 요소 제거 - clear()
		students.clear();
		System.out.println("::::: 모든 요소 제거 :::::");
		System.out.println(students);
		System.out.println("----------------------");
		
		// 요소 전체 추가 - addAll()
		Vector<String> 야근반 = new Vector<String>();
		야근반.add("전휘강");
		야근반.add("안영아");
		야근반.add("양주영");
		students.addAll(야근반);
		
		System.out.println("::::: 요소 전체 추가 :::::");
		for (int i = 0; i < students.size(); i++) {
			String student = students.get(i);
			System.out.print(student);
			if( i < students.size()-1 ) System.out.print(", ");
		}
		System.out.println();
		for (String student : 야근반) {
			System.out.print(student + " ");
		}
		System.out.println();
		
		// 다른 컬렉션을 인자로 생성할 수 있다.
		Vector<String> 오전반 = new Vector<String>(야근반);
		오전반.add("최영우");
		for (String student : 오전반) {
			System.out.print(student + " ");
		}
		System.out.println();
	}

}



