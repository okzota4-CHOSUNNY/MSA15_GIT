package day07.Ex08_Autoclose;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * test.txt 파일을 입력하여 텍스트파일의 내용을 출력하는 프로그램
 */
public class AutoClose {
	
	public static void main(String[] args) {
		
		// AutoClose
		// try ( 자동으로 자원해제할 객체 생성 ) { }
		// : finally 구문에서 close() 하지 않아도, 자동으로 자원해제 해준다.
		// * AutoClosable 인터페이스를 구현한 클래스이어야 자동으로 자원해제 가능
		try (
			FileInputStream fis = new FileInputStream("test.txt");
			InputStreamReader in = new InputStreamReader(fis, "UTF-8");
		) {
			
			int read = 0;
			while( (read = in.read()) != -1 ) {
				System.out.print( (char) read ); 
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.err.println("지원하지 않는 인코딩 타입입니다.");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("입출력 관련 예외가 발생했습니다.");
		}
		// 자원 해제 코드
//		finally {
//			if( fis != null ) {
//				try {
//					fis.close(); 				// 메모리 해제
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			if( in != null ) {
//				try {
//					in.close();					// 메모리 해제
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
		
		
		
	}

}
