<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.sql.*" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Reservation Verification</title>
        </head>

        <body>
            <h2>최근 예약 내역 확인</h2>
            <% Connection conn=null; PreparedStatement pstmt=null; ResultSet rs=null; try {
                Class.forName("com.mysql.cj.jdbc.Driver"); String
                url="jdbc:mysql://localhost:3306/nuage_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"
                ; conn=DriverManager.getConnection(url, "root" , "123456" ); String
                sql="SELECT * FROM reservations ORDER BY res_id DESC LIMIT 5" ; pstmt=conn.prepareStatement(sql);
                rs=pstmt.executeQuery(); out.println("<table border='1'>
                <tr>
                    <th>ID</th>
                    <th>CustID</th>
                    <th>Staff</th>
                    <th>Date</th>
                    <th>Start</th>
                    <th>End</th>
                    <th>Cost</th>
                </tr>");
                while (rs.next()) {
                out.println("<tr>");
                    out.println("<td>" + rs.getInt("res_id") + "</td>");
                    out.println("<td>" + rs.getInt("cust_id") + "</td>");
                    out.println("<td>" + rs.getString("staff_name") + "</td>");
                    out.println("<td>" + rs.getString("res_date") + "</td>");
                    out.println("<td>" + rs.getString("start_time") + "</td>");
                    out.println("<td>" + rs.getString("end_time") + "</td>");
                    out.println("<td>" + rs.getInt("cost") + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");

                } catch (Exception e) {
                out.println("<p>오류: " + e.getMessage() + "</p>");
                } finally {
                if (rs != null) try { rs.close(); } catch (SQLException e) {}
                if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
                if (conn != null) try { conn.close(); } catch (SQLException e) {}
                }
                %>
                <p><a href="reservation_dashboard.jsp">대시보드로 돌아가기</a></p>
        </body>

        </html>