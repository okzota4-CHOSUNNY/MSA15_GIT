package DBCP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.dbcp2.BasicDataSource;

public class Main {
    public static void main(String[] args) {
        // BasicDataSource 객체 생성 (DB 연결 풀 설정)
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/aloha");
        ds.setUsername("aloha");
        ds.setPassword("123456");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // 풀 설정
        // - 최초에 커넥션 5개 생성 후
        // - 6번째 요청이 들어오면 커넥션을 최대 10개 까지 확장
        // - 동시에 사용할 수 있는 커넥션이 10개
        ds.setInitialSize(5);   // 초기 연결 개수
        ds.setMaxTotal(10);     // 최대 연결 개수

        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM board")) {

            while (rs.next()) {
                System.out.println("제목: " + rs.getString("title"));
                System.out.println("작성자: " + rs.getString("writer"));
                System.out.println("내용: " + rs.getString("content"));
                System.out.println("------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
