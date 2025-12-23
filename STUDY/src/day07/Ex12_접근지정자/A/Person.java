package day07.Ex12_접근지정자.A;

public class Person {

	// 변수: 이름, 나이, 키, 체중
	public String name;
	protected int age;
	int height;
	private int weight;
	
	
	// 생성자
	// -기본 생성자
	public Person() {
		this("이름없음", 1, 0, 0);
	}
	// - 모든 매개변수 생성자
	public Person(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	//toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	
	
}
