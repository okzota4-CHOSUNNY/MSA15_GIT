package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	/**
	 * Oracle DB 연결을 담당하는 공통 클래스
	 * 모든 DAO 클래스의 부모 역할
	 */
	// DB 연결 객체 (DAO에서 사용)
	protected Connection con;
	
	/**
	 * 생성자
	 * 객체 생성 시 DB 연결 수행
	 */

	public DBConnection() {
		try {
			// 1. 오라클 JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Oracle JDBC 드라이버를 메모리에 로딩
			// 이 줄이 없으면 DB 연결 자체가 불가
			// “Oracle과 통신할 준비” 단계
			
			// 2. DB 접속 정보
			String url = "jdbc:oracle:thin@localhost:1521:xe";
			/**
			 jdbc:oracle:thin → Oracle JDBC 방식
			 localhost → 내 PC
			 1521 → Oracle 기본 포트
			 xe → Express Edition SID
			**/
			
			String user = "계정명";
			String password = "비밀번호";
			
			// 3. DB 연결
			con = DriverManager.getConnection(url, user, password);
			// 성공시 con 객체가 생성됨
			// 위 객체로 SQL 실행이 가능
			
			System.out.println("DB 연결 성공");
		
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle 드라이버 로딩 실패");
			e.printStackTrace();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}
