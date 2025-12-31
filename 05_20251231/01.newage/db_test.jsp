<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.sql.*" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>DB Test - Customer List</title>
            <style>
                table {
                    border-collapse: collapse;
                    width: 100%;
                }

                th,
                td {
                    border: 1px solid #ddd;
                    padding: 8px;
                    text-align: left;
                }

                th {
                    background-color: #f2f2f2;
                }
            </style>
        </head>

        <body>
            <h2>DB 연결 및 데이터 확인</h2>
            <% Connection conn=null; PreparedStatement pstmt=null; ResultSet rs=null; try {
                Class.forName("com.mysql.cj.jdbc.Driver"); String
                url="jdbc:mysql://localhost:3306/nuage_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"
                ; conn=DriverManager.getConnection(url, "root" , "123456" ); out.println("<p style='color:green;'>DB 연결
                성공!</p>");

                String sql = "SELECT * FROM customers";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                out.println("<table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Memo</th>
                    </tr>");
                    boolean found = false;
                    while (rs.next()) {
                    found = true;
                    out.println("<tr>");
                        out.println("<td>" + rs.getInt("cust_id") + "</td>");
                        out.println("<td>" + rs.getString("name") + "</td>");
                        out.println("<td>" + rs.getString("phone") + "</td>");
                        out.println("<td>" + rs.getString("memo") + "</td>");
                        out.println("</tr>");
                    }
                    out.println("
                </table>");

                if (!found) {
                out.println("<p style='color:red;'>데이터가 하나도 없습니다. SQL 초기화 스크립트를 실행했는지 확인하세요.</p>");
                }
                } catch (Exception e) {
                out.println("<p style='color:red;'>오류 발생: " + e.getMessage() + "</p>");
                e.printStackTrace(new java.io.PrintWriter(out));
                } finally {
                if (rs != null) try { rs.close(); } catch (SQLException e) {}
                if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
                if (conn != null) try { conn.close(); } catch (SQLException e) {}
                }
                %>
        </body>

        </html>