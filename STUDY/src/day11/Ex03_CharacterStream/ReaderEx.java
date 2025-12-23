package day11.Ex03_CharacterStream;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReaderEx {

	
	public static void main(String[] args) {
		// 파일 경로
		String filepath = "sample.txt";
		
	 try(  
		 
			
			// 문자 단위로 데이터 출력
			FileReader fr = new FileReader(filepath);
			// 데이터 출력 성능 향상
			BufferedReader br = new BufferedReader(fr);
		)
	 	{
		 String text;
		 // readLine() : 파일의 문자 데이터를 한 줄씩 입력
		 //				: 데이터가 더이상 없으면 null 변환
		
	 	while(( text = br.readLine() ) != null) {
	 		System.out.println(text);
	 	}
	 
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}