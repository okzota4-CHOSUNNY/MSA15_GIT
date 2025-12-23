package day11.Ex03_CharacterStream;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriterEx {

	
	public static void main(String[] args) {
		// 파일 경로
		String filepath = "sample.txt";
		
		
		try (
			
			// 문자 단위로 데이터 출력
			FileWriter fw = new FileWriter(filepath);
			// 데이터 출력 성능 향상
			BufferedWriter bw = new BufferedWriter(fw);
			)	
			{
			bw.write("Hello Java~! \n");
			bw.write("this is Java \n");
			System.out.println("sample.txt 파일을 저장하였습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}