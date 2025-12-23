package day11.Ex04_File;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 파일 관리 프로그램
 * - 메뉴 출력
 * - 하위 파일 목록
 * - 파일 정보 조회
 * - 폴더 생성
 * - 폴더 삭제
 * - 파일 생성
 * - 파일 삭제
 */
public class FileManager {
	
	/**
	 * 메뉴 출력
	 */
	
	private static void menu() {
		System.out.println(":::::::::: 파일 관리 ::::::::::");
		System.out.println("1. 파일 목록");
		System.out.println("2. 파일 조회");
		System.out.println("3. 폴더 생성");
		System.out.println("4. 폴더 삭제");
		System.out.println("5. 파일 생성");
		System.out.println("6. 파일 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.println(":::::::::: 번호: ");
	}
	
	/** 
	 * 파일 목록
	 * @param path
	 */
	private static void fileList(String path) {
		System.out.println(path);
		File file = new File(path);				// 경로를 지정하여 파일 객체 생성
		File[] fileList = file.listFiles();		// 하위 경로의 파일 목록을 File[]배열로 반환
	
		System.out.println("------------------------");
		System.out.println("파일명\t\t용량\t\t수정일자");
		for (File subFile : fileList) {
			// 수정일자
			long update = subFile.lastModified();	// 최종 수정일자
			Date date = new Date(update);			// java.util.date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/DD HH:mm:ss");
			String updateDate = sdf.format(date);
			// 파일명
			String fileName = subFile.getName();
			// 용량
			long size = subFile.length();
			System.out.print(fileName + "\t\t");
			System.out.println(size + "\t\t");
			System.out.println(updateDate + "\t\t");
			System.out.println();
		}
		System.out.println("------------------------------");
	}
	
	/**
	 * 파일 정보 조회
	 * @param filePath
	 */
	private static void fileInfo(String filePath) {
		File file = new File(filePath);
		System.out.println("파일 종류 : ");
		if( file.isDirectory() ) System.out.println("디렉토리");
		if( file.isFile() ) System.out.println("일반파일");
		
		long update = file.lastModified();
		Date date = new Date(update);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String updateDate = sdf.format(date);
		
		System.out.println( file.getName() + "\t\t" );
		System.out.println( file.length() + "\t\t" );
		System.out.println( updateDate + "\t\t");
	}
		
		/**
		 * 폴더 생성
		 * @param path
		 */
		
		private static void makeDir(String path) {
			File file = new File(path);
			// mkdir() : 생성할 경로의 상위 경로까지 기존 디렉토리가 존재해야한다. (없으면 에러)
			// mkdirs(): 생성할 경로의 사이 경로까지 디렉토리를 생성해준다.
			if( file.mkdir() ) {
				System.out.println("디렉토리 생성 성공!");
			} else {
				System.out.println(" 디렉토리 생성 실패!");
			}
			System.out.println("경로 : " + path);
			}
		/**
		 * 폴더 삭제
		 * @param path
		 */
		private static void deleteDir(String path) {
			File file = new File(path);
			File[] fileList = file.listFiles();
			
			if( fileList != null) {
				for (File subFile : fileList) {
					String subFilePath = subFile.getPath();
					deleteDir(subFilePath);
				}
			
			}
			if(file.delete()) {
			} else {
				System.out.println("폴더(파일) 삭제 실패!");
			}
		}
		
		/**
		 * 파일 생성
		 * @param path
		 * @param fileName
		 */
		private static void createFile(String path, String fileName) {
			File file = new File(path, fileName);
		try {
			FileWriter fw = new FileWriter(file);
			Scanner sc = new Scanner(System.in);
			System.out.print("내용 : ");
			String text = sc.nextLine();
			fw.write(text);
			fw.close();
			System.out.println(fileName + " 파일을 생성하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 파일 삭제
	 * @param filePath
	 */
	private static void deleteFile(String filePath) {
		File file = new File(filePath);
		
		// 파일 존재 여부 확인
		if(file.exists() && file.delete() ) {
			System.out.println("파일 삭제 성공!");
		}
		else if( file.exists() ) {
			System.err.println("파일 삭제 실패!");
		}
		else {
			System.err.println("파일이 존재하지 않습니다.");
		}
	}
	
	public static void main(String[] args) {
		int menuNo;		// 메뉴번호
		Scanner sc = new Scanner(System.in);
		
		do {
			// 메뉴판 출력
			menu();
			//메뉴번호 입력
			menuNo = sc.nextInt();
			sc.nextLine();
			
			// 프로그램 종료
			if( menuNo == 0 ) break;
			
			// 파일 경로 입력
			System.out.println("파일 경로 : ");
			String path = sc.nextLine();
			
			switch (menuNo) {
			case 1:	// 파일 목록
					fileList(path);
					break;
			case 2:	// 파일 조회
					fileInfo(path);
					break;
			case 3:	// 파일 생성
					makeDir(path);
					break;
			case 4:	// 폴더 삭제
					deleteDir(path);
					break;
			case 5:	// 파일 생성
					System.out.println("파일명 : ");
					String fileName = sc.nextLine();
					createFile(path, fileName);
					break;
			case 6:	//파일 삭제
				fileInfo(path);
				break;
				
			default:
				break;
			}
		} while (true);
		
		sc.close();
	
	}
}
