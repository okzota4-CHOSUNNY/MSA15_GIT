package day11.Ex04_File;

import java.io.File;

public class FileBasic {
	
	public static void main(String[] args) {
		// 1. 파일 객체 생성
		File file = new File("C:/test/test.txt");
		
		// 2. 파일 존재 여부 확인
		if( file.exists() ) {
			System.out.println("파일이 존재합니다.");
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		// 3. 파일 정보 출력
		System.out.println("이름 : " + file.getName());
		System.out.println("경로 : " + file.getPath());
		System.out.println("절대경로 : " + file.getAbsolutePath());
		
		// 4. 파일인지, 디렉토리(폴더)인지 구분
		System.out.println("파일 : " + file.isFile());
		System.out.println("폴더 : " + file.isDirectory());
		
	}

}
