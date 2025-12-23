package day17.Thread.Ex02_스레드구현;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		
		for (int i = 0; i <= 200; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println(i + " : " + threadName);
		}
	}
	
}

public class RunnableTest {

	public static void main(String[] args) {
		System.out.println("프로그램 시작!");
		
		Thread thread1 = new Thread(new MyRunnable());
		Thread thread2 = new Thread(new MyRunnable());
		
		thread1.start();
		thread2.start();
		
		System.out.println("프로그램 종료!");
		}
	
}
