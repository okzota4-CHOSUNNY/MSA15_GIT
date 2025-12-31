<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.sql.*" %>
        <% // Version: 1.2 (Reverted to Array format for stability) request.setCharacterEncoding("UTF-8"); String
            query=request.getParameter("q"); StringBuilder sb=new StringBuilder(); sb.append("["); if (query !=null &&
            !query.trim().isEmpty()) { Connection conn=null; PreparedStatement pstmt=null; ResultSet rs=null; try {
            Class.forName("com.mysql.cj.jdbc.Driver"); String
            url="jdbc:mysql://localhost:3306/nuage_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true" ;
            conn=DriverManager.getConnection(url, "root" , "123456" ); String
            sql="SELECT cust_id, name, phone, last_visit_date, memo FROM customers WHERE name LIKE ? OR phone LIKE ? LIMIT 5"
            ; pstmt=conn.prepareStatement(sql); String searchVal="%" + query.trim() + "%" ; pstmt.setString(1,
            searchVal); pstmt.setString(2, searchVal); rs=pstmt.executeQuery(); boolean first=true; while (rs.next()) {
            if (!first) sb.append(","); sb.append("{"); sb.append("\"id\":").append(rs.getInt("cust_id")).append(",");
            sb.append("\"name\":\"").append(rs.getString("name")).append("\",");
            sb.append("\"phone\":\"").append(rs.getString("phone")).append("\","); String
            lastVisit=rs.getString("last_visit_date"); sb.append("\"last_visit\":\"").append(lastVisit !=null ?
            lastVisit.substring(0, 10) : "기록없음" ).append("\","); String memo=rs.getString("memo");
            sb.append("\"memo\":\"").append(memo !=null ? memo.replace("\"", "\\\"").replace(" \n", " "
            ).replace("\r", "" ) : "매모없음" ).append("\""); sb.append("}"); first=false; } } catch (Exception e) {
            e.printStackTrace(); } finally { if (rs !=null) try { rs.close(); } catch (SQLException e) {} if (pstmt
            !=null) try { pstmt.close(); } catch (SQLException e) {} if (conn !=null) try { conn.close(); } catch
            (SQLException e) {} } } sb.append("]"); out.print(sb.toString()); %>