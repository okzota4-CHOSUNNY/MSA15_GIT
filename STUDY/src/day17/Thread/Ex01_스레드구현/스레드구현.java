package day17.Thread.Ex01_스레드구현;

public class 스레드구현 {

    class MyThread extends Thread {
        @Override
        public void run() {
        	            for (int i = 0; i <= 200; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println(i + " : " + threadName);
            }
        }
    }

    // 내부 클래스로 변경 (public 제거)
    class ThreadTest {
        public void runTest() {
            System.out.println(Thread.currentThread().getName());

            MyThread thread1 = new MyThread();
            MyThread thread2 = new MyThread();

            thread1.start();
            thread2.start();
                        
            System.out.println("끝");
            /**
             * 결론 ㅣ
             * 스레드는 동시에 수행되는 것처럼 보이지만,
             * 실제로는 CPU 가 아주 빠른 속도로 스레드들을 교체하면서 명령어 처리를 수행한다.
             * *CPU 는 한 시점에 하나의 스레드만 실행할 수 있다.
             * "하나를 하고 하나를 하는 방식"
             * "시분할 처리" : CPU
             * "병행 처리"	  : GPU
             */
        }
    }

    // main 메서드 추가 (public 클래스에 있어야 실행 가능)
    public static void main(String[] args) {
        스레드구현 outer = new 스레드구현();
        ThreadTest test = outer.new ThreadTest();
        test.runTest();
    }
}