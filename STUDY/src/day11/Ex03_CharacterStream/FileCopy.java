package day11.Ex03_CharacterStream;

import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {
	
	public static void main(String[] args) {
		try (
				FileReader fr = new FileReader("sample.txt");
				FileWriter fw = new FileWriter("sample2.txt");
				
		)
		{
			int data = 0;
			// 파일 입력 (문자)
			while ( (data = fr.read() ) != -1) {
				// 파일 출력 (문자)
				fw.write(data);
			}
			System.out.println("파일이 복사되었습니다.");
			System.out.println("sample.txt -> sample2.txt");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
