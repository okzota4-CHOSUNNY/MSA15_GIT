package shop.DAO;


// SQL 예외 처리를 위한 클래스
import java.sql.SQLException;

// AUTO_INCREMENT 값 반환을 위해 필요
import java.sql.Statement;

// 날짜/시간을 DB(TIMESTAMP) 로 처리하기 위한 클래스
import java.sql.Timestamp;

// 자바 날짜 클래스
import java.util.Date;

// 자동 로그인 정보를 담는 DTO
import shop.DTO.PersistenceLogins;


/**
 * PersistenceLoginsDAO
 * 
 * ▶ persistence_logins 테이블과 직접 통신하는 DAO 클래스
 * ▶ 자동 로그인(remember-me) 기능을 위한 DB 처리 담당
 * 
 * 주요 기능
 * - username 으로 조회
 * - token 으로 조회
 * - 자동 로그인 정보 등록
 * - 자동 로그인 정보 수정
 * - 자동 로그인 정보 삭제
 */


/**
 * - username 으로 조회
 * - token 으로 조회
 * - 등록
 * - 수정
 * - 삭제
 */
public class PersistenceLoginsDAO extends JDBConnection {
// JDBConnection을 상속받아
// Connection, PreparedStatement, ResultSet을 그대로 사용	
	
	/**
	 * username 으로 조회
	 * @param username
	 * @return
	 */
	public PersistenceLogins selectByUseranme(String username) {
		// username으로 자동 로그인 정보 조회 SQL
		String sql = " SELECT * "
				   + " FROM persistence_logins "
				   + " WHERE username = ? ";
		// 조회 결과를 담을 DTO 객체(기본 null)
		PersistenceLogins persistenceLogins = null;
		try {
			psmt = con.prepareStatement(sql);	// SQL 실행 준비
			psmt.setString(1, username);	// 첫번째 ? 자리에 username 바인딩
			rs = psmt.executeQuery();	// SELECT 실행 → ResultSet 반환
			
			if( rs.next() ) { 	// 만약 조회결과가 있으면
				// DTO 객체 생성
				persistenceLogins = new PersistenceLogins();
				
				persistenceLogins.setNo( rs.getInt("no") );
				persistenceLogins.setId( rs.getString("id") );
				persistenceLogins.setUsername( rs.getString("username") );
				persistenceLogins.setToken( rs.getString("token") );
				persistenceLogins.setExpiryDate( rs.getTimestamp("expiry_date") );
				persistenceLogins.setCreatedAt( rs.getTimestamp("created_at") );
				persistenceLogins.setUpdatedAt( rs.getTimestamp("updated_at") );
			}
		} catch (SQLException e) {
			// token 조회 중 예외 발생
			System.err.println("회원 아이디로 조회 시 예외 발생");
			e.printStackTrace();
		}
		return persistenceLogins;
	}
	
	
	/**
	 * token 으로 조회
	 * @param token		 // token 자동 로그인 토큰
	 * @return			 // PersistenceLogins 객체 (없으면 null)
	 */	
	public PersistenceLogins selectByToken(String token) {
		// token으로 자동 로그인 정보 조회 SQL
		String sql = " SELECT * "
				   + " FROM persistence_logins "
				   + " WHERE token = ? ";
		
		PersistenceLogins persistenceLogins = null;
		
		try {
			// SQL 준비
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, token);
			
			// SELECT 실행
			rs = psmt.executeQuery();
			if( rs.next() ) {
				// 결과가 있으면 DTO 생성
				persistenceLogins = new PersistenceLogins();
				persistenceLogins.setNo( rs.getInt("no") );
				persistenceLogins.setId( rs.getString("id") );
				persistenceLogins.setUsername( rs.getString("username") );
				persistenceLogins.setToken( rs.getString("token") );
				persistenceLogins.setExpiryDate( rs.getTimestamp("expiry_date") );
				persistenceLogins.setCreatedAt( rs.getTimestamp("created_at") );
				persistenceLogins.setUpdatedAt( rs.getTimestamp("updated_at") );
			}
		} catch (SQLException e) {
			// token 조회 중 예외 발생
			System.err.println("토큰으로 조회 시 예외 발생");
			e.printStackTrace();
		}
		return persistenceLogins;
	}
	
	/**
	 * 자동 로그인 정보 등록
	 * @param persistenceLogins 자동 로그인 DTO
	 * @return 실행 결과 (1: 성공, 0: 실패)
	 */
	
	public int insert(PersistenceLogins persistenceLogins) {
		String sql = " INSERT INTO persistence_logins ( id, username, token, expiry_date ) "
				   + " VALUES ( ?, ?, ?, ? ) ";
		
		int result = 0;
		try {
			// 자동 생성된 PK(no) 값을 가져오기 위해 RETURN_GENERATED_KEYS 사용
			// AUTO_INCREMENT 되는 no 컬럼의 자동생성된 값을 가져온다.
			psmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// DTO 값 → SQL 파라미터 바인딩
			psmt.setString(1, persistenceLogins.getId());
			psmt.setString(2, persistenceLogins.getUsername());
			psmt.setString(3, persistenceLogins.getToken());
			
			// Date → Timestamp 변환 (DB 저장용)
			Date expiryDate = persistenceLogins.getExpiryDate();
			psmt.setTimestamp(4, new java.sql.Timestamp( expiryDate.getTime() ));
			
			result = psmt.executeUpdate();
			rs = psmt.getGeneratedKeys();
			if( rs.next() ) {
				int no = rs.getInt(1);
				persistenceLogins.setNo(no);
			}
			
		} catch (Exception e) {
			System.err.println("자동 로그인 데이터 등록 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 자동 로그인 정보 수정
	 * @param persistenceLogins 수정할 자동 로그인 DTO
	 * @return 실행 결과
	 */
	
	public int update(PersistenceLogins persistenceLogins) {
		String sql = " UPDATE persistence_logins "
				   + " SET token = ? "
				   + "    ,username = ? "
				   + "    ,expiry_date = ?"
				   + "    ,updated_at = ? "
				   + " WHERE no = ? ";
		int result = 0;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, persistenceLogins.getToken());
			psmt.setString(2, persistenceLogins.getUsername());
			Date expiryDate = persistenceLogins.getExpiryDate();
			psmt.setTimestamp(3, new Timestamp(expiryDate.getTime()) );
			psmt.setTimestamp(4, new Timestamp( new Date().getTime() ) );
			psmt.setInt(5, persistenceLogins.getNo());
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("자동 로그인 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int delete(String username) {
		String sql = " DELETE FROM persistence_logins "
				   + " WHERE username = ? ";
		
		int result = 0;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, username);
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("자동 로그인 삭제 중 예외 발생");
		}
		return result;
	}

}

















