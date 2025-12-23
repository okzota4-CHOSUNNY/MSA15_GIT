package day17.Thread.Ex09_대기와알림;

import java.util.ArrayList;

class Shop {
	// 가게의 테이블 리스트
	private ArrayList<String> tableList = new ArrayList<>();
	
	public Shop() {
		tableList.add("테이블 1");
		tableList.add("테이블 2");
		tableList.add("테이블 3");
		tableList.add("테이블 4");
		tableList.add("테이블 5");
		
	}
	
	// 손님 입장
	public synchronized String entry() throws InterruptedException {
		Thread t = Thread.currentThread();
		// 테이블이 없으면
		while( tableList.size() == 0) {
			System.out.println("웨이팅 시작");
			wait();			// 
			System.out.println("웨이팅 끝!");
		}
		String table = tableList.remove(0);
		System.out.println(table + "에 손님 입장!");
		System.out.println("- 스레드 : " + t.getName());
		return table;
		
	}
	// 손님 퇴장
	public synchronized void exit(String tableName) {
		Thread t = Thread.currentThread();
		System.err.println("손님 퇴장!");
		tableList.add(tableName);
		notifyAll();		// 웨이팅 손님에게 빈 테이블 알림
		System.err.println("빈 테이블 : " + tableName);
		System.err.println("- 스레드 : : " + tableName);
	}
		
}
class Customer extends Thread {
	public class ShopMain {
		
	public void run() {
	try {	
	String table = ShopMain.shop.entry();	//입장
		Thread.sleep(5000);
		ShopMain.shop.exit(table);
	} catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();

	}
	
}
		public static Shop shop = new Shop();
			Customer c1 = new Customer();
			Customer c2 = new Customer();
			Customer c3 = new Customer();
			Customer c4 = new Customer();
			Customer c5 = new Customer();
				
}

}














