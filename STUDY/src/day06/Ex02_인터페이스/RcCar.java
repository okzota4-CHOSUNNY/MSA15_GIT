package day06.Ex02_인터페이스;

// 클래스를 상속하는 키워드 		: extends
// 인터페이스를 구현하는 키워드	: implements
public class RcCar implements RemoteControl {
	
	int speed;

	@Override
	public void turnON() {
		System.out.println("RC카 전원을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("RC카 전원을 끕니다.");
	}

	@Override
	public void setSpeed(int speed) {
		// 최대 속력을 초과하지 못하게 지정
		if( speed > RemoteControl.MAX_SPEED ) {
			this.speed = RemoteControl.MAX_SPEED;
			System.err.println("최대 속력입니다!");
		}
		// 최저 속력 미만이 되지 못하게 지정
		else if( speed < RemoteControl.MIN_SPEED ) {
			this.speed = RemoteControl.MIN_SPEED;
			System.err.println("최저 속력입니다!");
		}
		else {
			this.speed = speed;
		}
		System.out.println("현재 속도 : " + this.speed);
	}

}



