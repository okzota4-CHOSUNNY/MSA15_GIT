package shop.DTO;
// DTO(Data Transfer object)는 데이터를 담는 전용 패키지

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// 롬복 불러오기 아래기능 자동 생성됨
// -getter / setter , -toStirng(), -equals(), hashCode()
@NoArgsConstructor
// 파라미터 없는 기본 생성자 자동 생성
// new Users(); 가능하게 해줌 (JDBC, 프레임워크에서 중요)
@AllArgsConstructor
// 모든 필드를 받는 생성자 자동 생성
// new Users(no, username, password, ...)
@Builder
// 빌더 패턴 자동 생성
// Users.builder().username("id").build() 형태로 객체 생성 가능

public class Users {
	private int no;
	// 회원 고유 번호
	private String username;
	private String password;
	private String name;
	private String email;
	private Boolean enabled = true;
	// 계정 활성화 여부
	// 기본값 true -> 가입 시 바로 사용 가능
	private Data createdAt;
	// 계정 생성일
	
	private Data updatedAt;
	// 계정 수정일
	// DB의 updatedAt;
	
}

