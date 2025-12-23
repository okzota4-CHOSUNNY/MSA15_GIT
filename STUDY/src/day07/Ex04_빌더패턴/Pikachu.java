package day07.Ex04_빌더패턴;

import java.util.Calendar.Builder;

public class Pikachu {

	// 변수
	private int energy;
	private string type;
	private int level;
	
	// privat 생성자
	private Pikachu(Builder builer) {
		this.energy = builder.energy;
		this.type = builer.type;
		this.level = builer.level;
	}
	
	// Builder 클래스를 static 이너 클래스로 정의
	public static void main(String[] args) {
		
		// 각 변수를 초기화하고, 인스턴스 반환하는 메소드 정의
		public Builder energy(int energy) {
			this.energy = energy;
			return this;
		public Builder type(String type) {
			this.type = type;
			ruturn this;
		}
		public Builder level(int level) {
			this.level = level;
			return this;
		}
		// 객체를 생성해주는 build()메소드
		public Pikachu build() {
			return new Pikachu(this)
		}
	}
}
