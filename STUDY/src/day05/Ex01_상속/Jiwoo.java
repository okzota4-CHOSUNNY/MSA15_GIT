package day05.Ex01_상속;

public class Jiwoo {
	
	// main : ctrl + space
	public static void main(String[] args) {
		// 객체 생성
		Pikachu pikachu = new Pikachu();
		pikachu.energy = 100;
		pikachu.type = "전기";
		// 출력문에 객체를 출력 시, toString() 메소드가 반환한 문자열이 출력된다.
		System.out.println(pikachu);
		
		// sysout : ctrl + space
		System.out.println("::::: 피카츄 :::::");
		System.out.println("에너지 : " + pikachu.energy);
		System.out.println("타입  : " + pikachu.type);
		System.out.println("공격A : " + pikachu.aAttack());
		System.out.println("공격B : " + pikachu.bAttack());
		System.out.println();
		
		Pikachu pikachu20 = new Pikachu(150, "진화");
		System.out.println("::::: 피카츄 (Lv.20) :::::");
		System.out.println("에너지 : " + pikachu20.energy);
		System.out.println("타입  : " + pikachu20.type);
		System.out.println("공격A : " + pikachu20.aAttack());
		System.out.println("공격B : " + pikachu20.bAttack());
		System.out.println();
		
		Raichu raichu = new Raichu();
		
		System.out.println("::::: 라이츄 (Lv.20) :::::");
		System.out.println("에너지 : " + raichu.energy);
		System.out.println("타입  : " + raichu.type);
		System.out.println("공격A : " + raichu.aAttack());
		System.out.println("공격B : " + raichu.bAttack());
		System.out.println("공격C : " + raichu.cAttack());
		System.out.println();
		
		
	}

}