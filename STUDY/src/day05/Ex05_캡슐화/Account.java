package day05.Ex05_캡슐화;

public class Account {
	// private 필드 - 외부에서 직접 접근 불가능
	private String accountNumber;
	private String accountHolder;
	private double balance;
	
	// 생성자
	public Account(String accountNumber, String accountHilder) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = 0.0;
	}
	
	// Getter 메서드
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getAccountHolder() {
		return accountHolder;
		
	}
	
	public double getBalance() {
		return balance;
	}
	
	// 입금 메서드
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println(amount + " 원이 입금되었습니다.");
		} else {
			System.out.println("유효하지 않은 입금액입니다.");
		}
	}
	
	// 출금 메서드
	public void withdraw(double amount) {
		if (amount > 0 && balance >= amount) {
			balance -= amount;
			System.out.println(amount + "원이 출금되었습니다.");
		} else {
			System.out.println("출금할 수 없습니다. 잔액이 부족하거나 유효하지 않은 금액입니다.");
		}
	}
}
