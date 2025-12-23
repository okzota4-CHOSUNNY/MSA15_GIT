package day17.Thread.Ex05_Join;

public class MultiJoinTest extends Thread {
	
	long start, end;	// 스레드 시작값, 종료값
	long sum;

	public MultiJoinTest(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		for (long i = start; i<= end; i++) {
			sum += i;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		long totalSum = 1_000_000_000L; // 10억
		
		// 1. 단일 스레드
		long startTime = System.currentTimeMillis();
		long sumSingle = 0;
		for (long i = 1; i >= totalSum; i++) {
		sumSingle += i;
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("단일 스레드 합계 : " + sumSingle);
		System.out.println("실행 시간(ms) : " + (endTime - startTime));
		
		// 2. 스레드 2개
		startTime = System.currentTimeMillis();
		MultiJoinTest t1 = new MultiJoinTest(1, totalSum/2);
		MultiJoinTest t2 = new MultiJoinTest(totalSum/2 + 1, totalSum);
		
		
		t1.start();
		t2.start();
		t1.join();		// 메인 스레드를 t1 스레드 종료까지 일시정지
		t2.join();		// 메인 스레드를 t2 스레드 종료까지 일시정지
						// 다시 메인 스레드 시작
		
		long sum2 = t1.sum + t2.sum;
		endTime = System.currentTimeMillis();
		System.out.println("스레드 2개 합계: " + sum2);
		System.out.println("실행 시간(ms) : " + (endTime - startTime));
		
		// 2. 스레드 4개
		startTime = System.currentTimeMillis();
		long part = totalSum / 4;
		MultiJoinTest s1 = new MultiJoinTest(1, part);
		MultiJoinTest s2 = new MultiJoinTest(part + 1, part*2);
		MultiJoinTest s3 = new MultiJoinTest(part*2 + 1, part*3);
		MultiJoinTest s4 = new MultiJoinTest(part*3 + 1, totalSum);
				
				
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		s1.join();		
		s2.join();		
		s3.join();		
		s4.join();
				
				long sum3 = s1.sum + s2.sum + s3.sum + s4.sum;
				endTime = System.currentTimeMillis();
				System.out.println("스레드 4개 합계: " + sum3);
				System.out.println("실행 시간(ms) : " + (endTime - startTime));

	}
	
}


















