<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.sql.*" %>
        <% // Version: v1.1-fixed (Variable types added to prevent 500 error) request.setCharacterEncoding("UTF-8");
            String custIdStr=request.getParameter("custId"); String resDate=request.getParameter("resDate"); String
            staffName=request.getParameter("staffName"); String startTime=request.getParameter("startTime"); String
            endTime=request.getParameter("endTime"); String costStr=request.getParameter("cost"); String
            resMemo=request.getParameter("resMemo"); Connection conn=null; PreparedStatement pstmt=null; try {
            Class.forName("com.mysql.cj.jdbc.Driver"); String
            url="jdbc:mysql://localhost:3306/nuage_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true" ;
            conn=DriverManager.getConnection(url, "root" , "123456" ); String
            sql="INSERT INTO reservations (cust_id, staff_name, res_date, start_time, end_time, cost, memo) VALUES (?, ?, ?, ?, ?, ?, ?)"
            ; pstmt=conn.prepareStatement(sql); pstmt.setInt(1, (custIdStr==null) ? 0 : Integer.parseInt(custIdStr));
            pstmt.setString(2, (staffName==null) ? "미지정" : staffName); pstmt.setString(3, (resDate==null) ? "2000-01-01"
            : resDate); pstmt.setString(4, (resDate==null || startTime==null) ? "2000-01-01 00:00:00" : resDate + " " +
            startTime + ":00" ); pstmt.setString(5, (resDate==null || endTime==null) ? "2000-01-01 00:00:00" : resDate
            + " " + endTime + ":00" ); pstmt.setInt(6, (costStr==null || costStr.trim().isEmpty()) ? 0 :
            Integer.parseInt(costStr.replaceAll("[^0-9]", "" ))); pstmt.setString(7, (resMemo==null) ? "" : resMemo);
            int result=pstmt.executeUpdate(); if (result> 0) {
            out.print("{\"success\": true, \"message\": \"예약이 성공적으로 등록되었습니다.\"}");
            } else {
            out.print("{\"success\": false, \"message\": \"등록에 실패했습니다.\"}");
            }
            } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"success\": false, \"message\": \"오류: " + e.getMessage().replace("\"", "'") + "\"}");
            } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
            }
            %>