package day07.Ex03_싱글톤패키지;

/**
 * 싱글톤 패턴
 * - 디자인 패턴 중 하나로, 생성 패턴에 속하며
 * * 클래스의 인스턴스를 메모리 상에 오직 하나만 생성하여 접근하도록 하는 패턴
 * 
 * - 객체가 필요할 때, 새로운 객체를 생성하지 않고 기존의 인스턴스를 사용
 * - 객체를 하나만 생성하기 때문에 메모리를 효율적으로 사용 (낭비하지 않기위함)
 */
public class Singleton {
    private static Singleton instance;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}