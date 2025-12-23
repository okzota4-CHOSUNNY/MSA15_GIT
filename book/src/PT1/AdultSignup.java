package PT1;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AdultSignup {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("생년월일을 입력하세요 (yyyy-MM-dd): ");
        String birthDateStr = scanner.nextLine();

        if (isAdult(birthDateStr)) {
            System.out.println("성인 인증 성공! 회원가입이 가능합니다.");
            // 여기에 실제 회원가입 로직 추가
            registerUser();
        } else {
            System.out.println("미성년자는 가입할 수 없습니다.");
        }

        scanner.close();
    }

    // 생년월일 문자열로 성인 여부 판단 (만 19세 이상)
    public static boolean isAdult(String birthDateStr) {
        try {
            LocalDate birthDate = LocalDate.parse(birthDateStr); // "2020-05-15" 형식
            LocalDate today = LocalDate.now();

            // 만 나이 계산
            int age = Period.between(birthDate, today).getYears();

            return age >= 19;
        } catch (Exception e) {
            System.out.println("잘못된 날짜 형식입니다. yyyy-MM-dd 형식으로 입력해주세요.");
            return false;
        }
    }

    // 실제 회원가입 처리 (예시)
    private static void registerUser() {
        System.out.println("회원가입 처리 중...");
        // DB 저장, 이메일 인증 등 로직 추가
    }
}