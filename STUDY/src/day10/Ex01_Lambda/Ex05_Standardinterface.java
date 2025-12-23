package day10.Ex01_Lambda;

import java.util.function.Function;

public class Ex05_Standardinterface {

	public static void main(String[] args) {
			
			// 기본 람다식
			Function<String, Integer> lambda = (str) -> { return Integer.parseInt(str); };
			int result = lambda.apply( "100" );
			System.out.println( result ); // 100   (int)
		
			// 메소드 참조
			Function<String, Integer> methodRef = Integer::parseInt;
			int result2 = methodRef .apply( "200" );
			System.out.println( result2 ); // 200   (int)
		}

	}