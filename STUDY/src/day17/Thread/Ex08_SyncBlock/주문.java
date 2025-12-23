package day17.Thread.Ex08_SyncBlock;

class 주문 extends Thread {
    String 메뉴;
    int 가격;

    public 주문(String 메뉴, int 가격) {
        this.메뉴 = 메뉴;
        this.가격 = 가격;
    }

    @Override
    public void run() {
        System.out.println(메뉴 + " 주문 받음. 제조 시작...");
        try { 
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(메뉴 + " 완성! " + 가격 + "원");
    }



    
    public static void main(String[] args) {
        System.out.println("카페 오픈! 손님 주문 시작!");

        // 손님 1명 주문
        주문 order1 = new 주문("아메리카노", 4000);
        order1.start();  // 제조 시작 (5초 걸림)

        // 손님 2명 주문
        주문 order2 = new 주문("라떼", 4500);
        order2.start();  // 동시에 제조 시작!

        System.out.println("다른 손님 받는 중...");
        // main은 멈추지 않고 계속 실행됨!
    }
}
