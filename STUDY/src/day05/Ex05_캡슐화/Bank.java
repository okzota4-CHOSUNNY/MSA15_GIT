package day05.Ex05_캡슐화;

public class Bank {

	public static void main(String[] args) {
		Account account = new Account("282401-04-109955", "김조은");
		// account.balance;
		// balance 변수는 private 으로 지정했기 때문에, 접근불가
		// 입금
		account.deposit(50000);
		// 출금
		account.withdraw(10000);
		account.withdraw(50000);
		
		double money = account.getBalance();
		System.out.println("예금액 : " + money);
		System.out.println("예금주 : " + account.getAccountHolder());
		System.out.println("계좌번호 : " + account.getAccountNumber());
	}
}
