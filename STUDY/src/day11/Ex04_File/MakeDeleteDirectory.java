package day11.Ex04_File;

import java.io.File;
import java.util.Scanner;

public class MakeDeleteDirectory {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * 폴더 생성
	 */
	public static void makeDir() {
		System.out.print("경로 : ");
		String path = sc.nextLine();
		File file = new File(path);
		// mkdir() 	: 상위폴더가 있어야 폴더 생성 가능
		// mkdirs() : 상위폴더가 없어도 같이 생성 가능
		boolean check = file.mkdirs();	
		if( check ) {
			System.out.println("폴더 생성 성공!");
		} else {
			System.out.println("폴더 생성 실패!");
		}
	}
	
	/**
	 * 폴더 삭제
	 */
	public static void deleteDir() {
		System.out.print("경로 : ");
		String path = sc.nextLine();
		delete(path);
	}
	
	public static void delete(String path) {
		// 1. 하위 경로 파일들을 삭제
		// 2. 해당 폴더 삭제
		File file = new File(path);
		File[] fileList = file.listFiles();
		
		// 하위 경로에 파일이 있으면,
		if( fileList != null ) {
			for (File subFile : fileList) {
				String subFilePath = subFile.getPath();
				// 재귀 호출(재귀 함수; recursive)
				delete( subFilePath );
			}
		}
		// 폴더(파일) 삭제
		boolean check = file.delete();
		if( check ) {
			System.out.println("폴더(파일) 삭제 성공!");
		} else {
			System.out.println("폴더(파일) 삭제 실패!");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("1. 폴더 생성");
		System.out.println("2. 폴더 삭제");
		System.out.print("입력 : ");
		int no = sc.nextInt();
		sc.nextLine();
		
		switch (no) {
			case 1:	// 폴더 생성
					makeDir();
					break;
			case 2: // 폴더 삭제
					deleteDir();
					break;
		}
		sc.close();
	}

}