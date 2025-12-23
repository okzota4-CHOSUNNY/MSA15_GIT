package day08.Ex01_Object;

class Person implements Cloneable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // toString() 재정의
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    // equals() 재정의
    @Override
    public boolean equals(Object obj) {
    	// 인스턴스가 같으면 true
        if (this == obj) return true;
        // 클래스 타입이 다르면 false
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Person person = (Person) obj;
        // 나이와 이름이 같으면 같은 객체로 판단
        return age == person.age && name.equals(person.name);
    }

    // hashCode() 재정의
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    // clone() 재정의 (예외 처리 필요)
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        try {
            Person p1 = new Person("Aloha", 25);
            Person p2 = new Person("Aloha", 25);
            Person p3 = (Person) p1.clone(); // 복제

            System.out.println("p1: " + p1);
            System.out.println("p2: " + p2);
            System.out.println("p1 == p2: " + (p1 == p2)); // false (다른 객체)
            System.out.println("p1.equals(p2): " + p1.equals(p2)); // true (동일한 값 비교)
            System.out.println("p1.hashCode(): " + p1.hashCode());
            System.out.println("p2.hashCode(): " + p2.hashCode());
            System.out.println("p3 (clone): " + p3);
            System.out.println("p1 == p3: " + (p1 == p3)); // false (다른 객체)
            System.out.println("p1.equals(p3): " + p1.equals(p3)); // true (동일한 값 비교)

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
