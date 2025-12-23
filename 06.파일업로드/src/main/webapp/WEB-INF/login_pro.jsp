<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. id, passwd 파라미터 가져오기
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
			
	// 2. 아이디, 비밀번호 일치 여부
	boolean result = id.equals("CHO") && passwd.equals("123456");
	String root = request.getContextPath();
	// 3. 로그인 성공 -> 메인화면(/)으로 이동
	if( result ) {
		response.sendRedirect(root + "/");
	}
	//로그인 실패
	else{
		response.sendRedirect(root + "/login.jsp?error=true");
	}
	
%>