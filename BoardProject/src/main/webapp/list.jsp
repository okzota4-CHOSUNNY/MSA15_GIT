<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.board.model.BoardVO" %>
<%@ page import="com.board.model.BoardDAO" %>

<%
    // 1. 자바 코드 영역: DB에서 글 목록을 가져옵니다.
    BoardDAO dao = new BoardDAO(); // 일꾼 소환
    List<BoardVO> list = dao.getBoardList(); // 일꾼에게 목록 가져오라고 시킴
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
    /* 테이블 디자인 */
    table { width: 100%; border-collapse: collapse; }
    th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }
    th { background-color: #eee; } /* 제목 줄은 회색 배경 */
</style>
</head>
<body>

    <h2>게시판 목록</h2>

    <div style="text-align: right; margin-bottom: 10px;">
        <button onclick="location.href='write.jsp'">글쓰기</button>
    </div>

    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
        </thead>
        <tbody>
            <% 
                // 2. 가져온 리스트(list)가 비어있는지 확인합니다.
                if(list.isEmpty()) { 
            %>
                <tr>
                    <td colspan="4">등록된 게시글이 없습니다.</td>
                </tr>
            <% 
                } else {
                    // 3. 데이터가 있다면, for문을 돌려서 하나씩 꺼냅니다.
                    // 향상된 for문: list에 있는 BoardVO를 하나씩 꺼내 vo 변수에 담습니다.
                    for(BoardVO vo : list) {
            %>
                <tr>
                    <td><%= vo.getSeq() %></td> <td style="text-align:left;">
                        <%= vo.getTitle() %> </td>
                    
                    <td><%= vo.getWriter() %></td> <td><%= vo.getRegDate() %></td> </tr>
                <% 
                    } // for문 닫기
                } // else문 닫기
            %>
        </tbody>
    </table>

</body>
</html>