```jsp
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.sql.*" %>
        <% // get_reservations_ajax.jsp: DB에서 예약 목록을 가져와 JSON으로 반환 request.setCharacterEncoding("UTF-8"); StringBuilder
            __sb__=new StringBuilder(); __sb__.append("["); Connection conn=null; PreparedStatement pstmt=null;
            ResultSet rs=null; try { Class.forName("com.mysql.cj.jdbc.Driver"); String
            url="jdbc:mysql://localhost:3306/nuage_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true" ;
            conn=DriverManager.getConnection(url, "root" , "123456" ); // 최근 예약 100개를 가져옴 (필요시 날짜 범위 필터링 가능) String
            __sql__="SELECT r.*, c.name as cust_name FROM reservations r "
            + "JOIN customers c ON r.cust_id = c.cust_id " + "ORDER BY r.start_time DESC LIMIT 100" ;
            pstmt=conn.prepareStatement(__sql__); rs=pstmt.executeQuery(); boolean first=true; while (rs.next()) { if
            (!first) __sb__.append(","); __sb__.append("{");
            __sb__.append("\"id\":").append(rs.getInt("res_id")).append(",");
            __sb__.append("\"custName\":\"").append(rs.getString("cust_name")).append("\",");
            __sb__.append("\"resDate\":\"").append(rs.getString("res_date")).append("\",");
            __sb__.append("\"startTime\":\"").append(rs.getString("start_time")).append("\",");
            __sb__.append("\"endTime\":\"").append(rs.getString("end_time")).append("\",");
            __sb__.append("\"staffName\":\"").append(rs.getString("staff_name") !=null ? rs.getString("staff_name") : ""
            ).append("\","); __sb__.append("\"cost\":").append(rs.getInt("cost")); __sb__.append("}"); first=false; } }
            catch (Exception e) { e.printStackTrace(); } finally { if (rs !=null) try { rs.close(); } catch
            (SQLException e) {} if (pstmt !=null) try { pstmt.close(); } catch (SQLException e) {} if (conn !=null) try
            { conn.close(); } catch (SQLException e) {} } __sb__.append("]"); out.print(__sb__.toString()); %>
            ```