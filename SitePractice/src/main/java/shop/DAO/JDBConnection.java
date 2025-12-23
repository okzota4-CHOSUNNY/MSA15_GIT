package shop.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//JDBC 관련 클래스들
//- Connection        : DB와 연결된 통로
//- Statement         : 일반 SQL 실행 객체
//- PreparedStatement : ? 파라미터를 사용하는 SQL 실행 객체
//- ResultSet         : SELECT 결과를 담는 객체

/**
 * JDBConnection
 * - DB 연결을 담당하는 공통 부모 클래스
 * - DAO 클래스들이 상속해서 사용
 */

// 이 클래스는 DB연결 전용 부모 클래스

public class JDBConnection {
	public Connection con;
	// DB와 연결된 Connection 객체
	// DAO에서 SQL을 실행할 때 사용
	public Statement stmt;
	// 파라미터가 없는 단순 SQL 실행용 객체
	// (실무에서는 거의 안 쓰고 PreparedStatement 위주)
	public PreparedStatement psmt;
	// ? 파라미터를 사용하는 SQL 실행 객체
	// 가장 많이 사용됨
	public ResultSet rs;
	// SELECT 쿼리 실행 결과를 저장하는 객체
    /**
     * 기본 생성자
     * - 객체가 생성되는 순간 DB 연결을 시도
     * - DAO에서 super()로 자동 호출됨
     */
	public JDBConnection() {
		try {
			// 1.JDBC 드라이버 로드
			// mysql-connector-j.jar 안에 있는 드라이버 클래스를 메모리에 로드
			Class.forName("com.mysql.cj.jdbc.Driver");	
			// 2. DB 접속 정보 설정
			String url = 
				"jdbc:mysql://127.0.0.1:3306/aloha"
                + "?serverTimezone=Asia/Seoul"
                + "&allowPublicKeyRetrieval=true"
                + "&useSSL=false";
		String id = "aloha";
		// DB 접속 계정
		String pw = "123456";
		// DB 접속 계정 비밀번호
		// 3.DB 연결 시도
		con = DriverManager.getConnection(url, id, pw);
		// 성공하면 Connection 객체가 생성되어 con에 저장됨
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			// 드라이버 로드 실패 or DB 연결 실패 시
			System.err.println("DB 연결 실패");
			e.printStackTrace();
		}
	}
}
