package shop.DAO;

import java.sql.Connection;

import shop.DTO.Users;
// Users DTO import
// DB에서 조회한 결과를 Users 객체에 담기 위해 필요

/**
 * UserDAO
 * - users 테이블 전담 DAO
 * - SQL 실행, ResultSet 처리 담당
 */
public class UserDAO extends JDBConnection {
	// JDBConnection 상속
	// -> DB 연결(con), psmt, rs를 바로 사용 가능


/**
 * 회원가입 (INSERT)
 * @param user : 회원가입 정보가 담긴 UsersDTO
 * @return result : 성공 1, 실패 0
 * */
public int signup(Users user) {
	int result = 0;
	// int result가 0인 은 일단 회원가입은 실패했다고 가정하고 시작하겠다.
	// insert 성공 = 1, insert 실패 = 0
	
	String sql =
			" INSERT INTO users (username, password, name, email, enabled) "
			+ " VALUES (?, ?, ?, ?, ?) ";
	// users 테이블에 회원 정보를 저장하는 sql
	// ? 는 PreparedStatement에서 값을 나중에 바인딩함
	
	try {
		psmt = con.prepareStatement(sql);
		// con(Connection) 객체를 통해 SQL을 미리 컴파일
		// 실행속도 올라가고 SQL 인젝션 방지
		psmt.setString(1, user.getUsername());
		// 첫 번째 ? → username 값 설정
        // Lombok @Data 덕분에 getUsername() 자동 생성됨
		psmt.setString(2, user.getPassword());
		psmt.setString(3, user.getName());
		psmt.setString(4, user.getEmail());
		psmt.setBoolean(5, user.getEnabled());
		// “이 계정이 활성화 상태인지 아닌지를 저장하는 값”
		result = psmt.executeUpdate();
		// INSERT 실행
		// 성공 시 1, 실패 시 0 반환
		
		
	} catch (Exception e) {
		// SQLException 포함 모든 예외 처리
		System.err.println("회원가입 DAO 처리 중 예외 발생");
		e.printStackTrace();
	}
	
	return result;
	}
}