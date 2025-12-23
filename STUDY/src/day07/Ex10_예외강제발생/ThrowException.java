package day07.Ex10_예외강제발생;

//예외 강제 발생 예시
public class ThrowException {
	public static void main(String[] args) {
		try {
			validateAge(15);
		} catch (IllegalArgumentException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		System.out.println("프로그램 계속 실행");
	}

	public static void validateAge(int age) {
		if (age < 18) {
			throw new IllegalArgumentException("18세 미만은 이용할 수 없습니다.");
		}
		System.out.println("인증 완료: 나이 " + age);
	}
}

//실행 결과:
//예외 발생: 18세 미만은 이용할 수 없습니다.
//프로그램 계속 실행