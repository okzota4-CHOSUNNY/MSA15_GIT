<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.sql.*" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Database Schema Update</title>
        </head>

        <body>
            <h2>데이터베이스 스키마 업데이트 (reservations 테이블)</h2>
            <% Connection conn=null; Statement stmt=null; try { Class.forName("com.mysql.cj.jdbc.Driver"); String
                url="jdbc:mysql://localhost:3306/nuage_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"
                ; conn=DriverManager.getConnection(url, "root" , "123456" ); stmt=conn.createStatement();
                out.println("<p>업데이트 시작...</p>");

                // 1. staff_name 추가
                try {
                stmt.execute("ALTER TABLE reservations ADD COLUMN staff_name VARCHAR(30) AFTER admin_id");
                out.println("<p style='color:green;'>[성공] staff_name 컬럼 추가됨</p>");
                } catch (SQLException e) {
                out.println("<p style='color:orange;'>[주의] staff_name: " + e.getMessage() + "</p>");
                }

                // 2. res_date 추가
                try {
                stmt.execute("ALTER TABLE reservations ADD COLUMN res_date VARCHAR(20) AFTER staff_name");
                out.println("<p style='color:green;'>[성공] res_date 컬럼 추가됨</p>");
                } catch (SQLException e) {
                out.println("<p style='color:orange;'>[주의] res_date: " + e.getMessage() + "</p>");
                }

                // 3. cost 추가
                try {
                stmt.execute("ALTER TABLE reservations ADD COLUMN cost INT DEFAULT 0 AFTER end_time");
                out.println("<p style='color:green;'>[성공] cost 컬럼 추가됨</p>");
                } catch (SQLException e) {
                out.println("<p style='color:orange;'>[주의] cost: " + e.getMessage() + "</p>");
                }

                // 4. memo 추가
                try {
                stmt.execute("ALTER TABLE reservations ADD COLUMN memo TEXT AFTER cost");
                out.println("<p style='color:green;'>[성공] memo 컬럼 추가됨</p>");
                } catch (SQLException e) {
                out.println("<p style='color:orange;'>[주의] memo: " + e.getMessage() + "</p>");
                }

                out.println("<p><b>업데이트 완료!</b></p>");
                out.println("<p><a href='reservation_dashboard.jsp'>대시보드로 돌아가기</a></p>");

                } catch (Exception e) {
                out.println("<p style='color:red;'>오류 발생: " + e.getMessage() + "</p>");
                e.printStackTrace(new java.io.PrintWriter(out));
                } finally {
                if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
                if (conn != null) try { conn.close(); } catch (SQLException e) {}
                }
                %>
        </body>

        </html>