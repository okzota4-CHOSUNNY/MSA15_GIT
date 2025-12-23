package day09.Collection.List;

import java.util.Scanner;
import java.util.Stack;


/**
 * 문자열 뒤집기 프로그램
 */

public class StackEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Stack<Character> stack = new Stack<>();
		
		// 문자열의 각 문자를 스택에 넣기 - push
		char[] charList = input.toCharArray();
		for (char ch : charList) {
			stack.push(ch);
		}
		
		System.out.println("원래 문자열 : " + input);
		System.out.print("뒤집힌 문자열 : ");
		
		
		// 스택에서 하나씩 꺼내며 출력 - pop
		while( !stack.isEmpty()) {
			System.out.println( stack.pop() );
		}
		sc.close();
		
	}
}