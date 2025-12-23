package day07.Ex03_싱글톤패키지;
 //아우터 이너
public class SingletonTest {
	
	public static void main(String[] args) {
		// singleton = new Singleton();
		
		Singleton s01 = Singleton.getInstance();
		Singleton s02 = Singleton.getInstance();
		
		// 인스턴스가 메모리 공간에 하나로 할당되어 있는지 확인
		System.out.println("s01 s02 가 같은지 여부 : ");
		System.out.println( s01 == s02 );
	}

}
