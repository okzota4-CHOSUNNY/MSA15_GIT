package day17.Thread.Ex04_Interrupt;

public class InterruptTest extends Thread {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(3000);
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("스레드 끝");
	}

	public static void main(String[] args) throws InterruptedException {
		InterruptTest test = new InterruptTest();
		test.start();
		Thread.sleep(3000);
		// 인터럽트(Interrupt)
		// : Not Runnable 인 상태의 스레드를
		// 	 Runnable 상태가 되도록 요청하는 것
		
		// *Runnable		상태: 작업 중지 요청
		// *Not Runnable	상태: Runnabled 상태로 변경
		test.interrupt();
		
	}
	
}
