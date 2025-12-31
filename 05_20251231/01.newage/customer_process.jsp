<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.sql.*" %>
        <% request.setCharacterEncoding("UTF-8"); String name=request.getParameter("name"); String
            gender=request.getParameter("gender"); String phone=request.getParameter("phone"); String
            memo=request.getParameter("memo"); /* MySQL 연결 정보 */ String
            url="jdbc:mysql://localhost:3306/nuage_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true" ;
            String dbId="root" ; String dbPw="123456" ; Connection conn=null; PreparedStatement pstmt=null; try {
            Class.forName("com.mysql.cj.jdbc.Driver"); conn=DriverManager.getConnection(url, dbId, dbPw); /* [중요] 테이블명은
            반드시 'customers' (복수형)로 통일합니다. */ String
            sql="INSERT INTO customers (name, gender, phone, memo) VALUES (?, ?, ?, ?)" ;
            pstmt=conn.prepareStatement(sql); pstmt.setString(1, name); pstmt.setString(2, gender); pstmt.setString(3,
            phone); pstmt.setString(4, memo); int result=pstmt.executeUpdate(); if (result> 0) {
            response.sendRedirect("customer_list.jsp");
            }
            } catch (Exception e) {
            e.printStackTrace();
            out.println("
            <script>");
                out.println("alert('등록 중 오류 발생: " + e.getMessage().replace("'", "") + "');");
                out.println("history.back();");
                out.println("</script>");
            } finally {
            if (pstmt != null) try { pstmt.close(); } catch (Exception e) {}
            if (conn != null) try { conn.close(); } catch (Exception e) {}
            }
            %>