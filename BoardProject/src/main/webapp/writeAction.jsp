<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.board.model.BoardVO" %>
<%@ page import="com.board.model.BoardDAO" %>

<%
    // 1. 한글 깨짐 방지 (가장 중요!)
    // 브라우저에서 보낸 한글 데이터를 올바르게 해석하도록 설정합니다.
    request.setCharacterEncoding("UTF-8");

    // 2. write.jsp에서 보낸 데이터 받기 (request = 요청 보따리)
    String title = request.getParameter("title");   // name="title"인 값을 꺼냄
    String writer = request.getParameter("writer"); // name="writer"인 값을 꺼냄
    String content = request.getParameter("content"); // name="content"인 값을 꺼냄

    // 3. 데이터를 BoardVO 객체(그릇)에 예쁘게 담기
    BoardVO vo = new BoardVO();
    vo.setTitle(title);
    vo.setWriter(writer);
    vo.setContent(content);

    // 4. BoardDAO(일꾼)를 불러서 DB에 저장시키기
    BoardDAO dao = new BoardDAO();
    dao.insertBoard(vo); // DB에 쏙 들어갑니다.

    // 5. 모든 작업이 끝나면 'list.jsp'(목록 화면)로 이동시키기
    response.sendRedirect("list.jsp");
%>