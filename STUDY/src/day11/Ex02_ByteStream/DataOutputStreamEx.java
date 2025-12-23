package day11.Ex02_ByteStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamEx {
	
	public static void main(String[] args) {
	
	// 파일 경로
	String filepath = "sample.dat";
	
	try(
		// 파일을 byte 단위로 입력
		FileOutputStream fos = new FileOutputStream(filepath);	
		// 파일 입력 성능 향상
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		// 기본 데이터 입력
		DataOutputStream dos = new DataOutputStream(bos);
	)
	{
		
		dos.writeInt(3000);
		dos.writeDouble(12.45);
		dos.writeBoolean(false);
		System.out.println("sample.dat 파일을 출력하였습니다.");
		
	} catch (Exception e) {

		e.printStackTrace();
	}
}
}