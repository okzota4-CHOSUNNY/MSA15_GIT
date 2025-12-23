package day03;

import java.util.Iterator;
import java.util.Scanner;

/**
	 * 할일 목록 프로그램
	 * 
	 * 최대 10개의 할일을 관리할 수 있는 프로그램으로,
	 * 메뉴를 통해 할일을 추가, 조회, 상태변경 할 수 있는 기능을 구현
	 * 기능
	 * 1. 할일 추가
	 * 2. 할일 목록
	 * 3. 상태 변경
	 * 
	 * ""상태"" 를 enum(열거타입)으로 정의하여 관리
	 * *Status
	 * - 시작 전
	 * - 진행 중
	 * - 완료
	 */
	enum Status {
		TODO("시작 전"),
		ING("진행 중"),
		DONE("완료");
		
		// 상수 선언
		private final String status;		// 상태의 값을 저장하는 상수
		
		// 생성자를 통해 상수의 값을 지정
		Status(String status) {
			this.status = status;
		}
	
	
		// 상태의 값을 반환하는 메소드
		public String getValue() {
			return status;
		}
}

	class Todo {
		String name;	// 할일
		Status status;	// 상태
		
		// alt + shift + S : 소스메뉴
		// 생성자, getter/setter, toString
		public Todo(String name, Status status) {
			this.name = name;
			this.status = status;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public Status getStatus() {
			return status;
		}
		
		public void setStatus(Status status) {
			this.status = status;
		}
		
		@Override
		public String toString() {
			return "Todo [name=" + name + ", status=" + status.getValue() + "]";
			}
		}
	
	public class Ex09_Todo {
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Todo[] todoList = new Todo[10];		// 최대 10개의 할일
			int count = 0;						// 할일 개수
			
			while( true ) {
				System.out.println("####### 할일 목록 프로그램 #######");
				System.out.println("1. 할일 추가");
				System.out.println("2. 할일 목록");
				System.out.println("3. 상태 변경");
				System.out.println("0. 프로그램 종료");
				System.out.print("메뉴 선택 : ");
				int menuNo = sc.nextInt();
				sc.nextLine();		// 남은 엔터 제거
				
				if( menuNo == 0) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				
				switch (menuNo) {
				case 1: // 할일 추가
					System.out.println("할일 : ");
					String name = sc.nextLine();
					Todo todo = new Todo(name, Status.TODO);	// 할일 객체 생성
					todoList[count++] = todo;					// 할일 추가
					// count++;									// 할일 개수 추가
					System.out.println("할일을 추가하였습니다.");
					System.out.println("todo");
					System.out.println();
					break;
				case 2: // 할일 목록
					System.out.println("===== 할일 목록 =====");
					for (int i = 0; i < todoList.length; i++) {
						if( todoList[i] == null ) continue;
						System.out.println( (i+1) + ". " + todoList[i]);
					}
					System.out.println();
					break;
				case 3: // 상태변경
					System.out.println("할일 번호 : ");
					int index = sc.nextInt() - 1;
					sc.nextLine(); // 남은 엔터 제거
					// 변경가능한 상태 출력
					Status[] statusList = Status.values();
					for (Status status : statusList) {
						System.out.println( (status.ordinal() + 1) + ". " + status.getValue() );
					}
					// 변경할 상태 번호 입력
					System.out.print("번호 : ");
					int statusNo = sc.nextInt();
					sc.nextLine();
					// 상태변경
					Status updateStatus = statusList[statusNo-1];	// 입력할 번호의 사앹
					todoList[index].setStatus( updateStatus);		// 지정한 할일의 상태를 변경
					System.out.println("할일의 상태를" + updateStatus.getValue() + "(으/로) 변경하였습니다.");
					break;
				default:
					System.out.println("0~3 사이의 올바른 번호를 입력해주세요.");
					break;
				}
			}
						
			sc.close();	
		}
	}
	