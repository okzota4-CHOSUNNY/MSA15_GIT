package day11.Ex01_Srialization;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializePerson {

	public static void main(String[] args) {
	try (
		// "Person.dat" 파일을 읽기 위한 파일 입력 스트림 생성
		// Java ----- Person.dat 간의 파일전송 연결통로를 만듬
		FileInputStream fis = new FileInputStream("Person.dat");
		// 파일에서 객체로 읽어오기 위한 객체 스트림 생성
		ObjectInputStream ois = new ObjectInputStream(fis);
		// Person 객체를 직렬화하여 파일에 저장
	 ) { 
		 // "person.dat" 파일에서 객체를 읽어와 Person 타입으로 다운캐스팅
		Person person = (Person) ois.readObject();
		System.out.println(person);
		System.out.println("Person.dat 파일 데이터를 역직렬화하여 Person 객체로 가져옴");

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e)	{
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}	
		
}		
