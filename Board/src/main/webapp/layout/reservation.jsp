<%@page import="board.DTO.DesignerDAO"%>
<%@page import="board.DAO.DesignerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="board.DTO.*, java.util.*" %>
<%
    // DB에서 디자이너 목록 가져오기
    DesignerVO dao = new DesignerVO();
    List<DesignerVO> list = dao.getDesignerList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<style>
    body { margin: 0; padding: 0; font-family: 'Malgun Gothic', sans-serif; background-color: #fff; }
    
    /* 상단 탭 메뉴 스타일 */
    .nav-tabs {
        display: flex;
        justify-content: space-around;
        border-bottom: 1px solid #e2e2e2;
        padding: 0; margin: 0;
        list-style: none;
        background: white;
        position: sticky; top: 0; /* 스크롤해도 상단 고정 */
    }
    .nav-tabs li {
        padding: 15px 0;
        flex: 1; text-align: center;
        color: #888; cursor: pointer;
        font-weight: bold; font-size: 15px;
    }
    /* '예약' 탭만 활성화된 것처럼 꾸미기 */
    .nav-tabs li.active {
        color: #000;
        border-bottom: 3px solid #000;
    }

    /* 디자이너 리스트 스타일 */
    .designer-list { padding: 0 20px; }
    
    .designer-card {
        display: flex; /* 좌우 배치 */
        justify-content: space-between; /* 양끝 정렬 */
        padding: 25px 0;
        border-bottom: 1px solid #f1f1f1;
        cursor: pointer; /* 클릭 가능 표시 */
    }

    /* 왼쪽 텍스트 영역 */
    .info-area { flex: 1; }
    
    .name-row { font-size: 18px; font-weight: bold; margin-bottom: 8px; color: #000; }
    .badge-npay {
        display: inline-block; background-color: #03c75a; color: white;
        font-size: 10px; padding: 2px 4px; border-radius: 4px; margin-left: 5px; vertical-align: middle;
    }
    
    .desc-row { font-size: 13px; color: #888; margin-bottom: 15px; }
    .review-score { color: #03c75a; } /* 초록색 숫자 */

    /* 예약 버튼 */
    .btn-reserve {
        background-color: white; border: 1px solid #e2e2e2;
        padding: 8px 15px; border-radius: 4px;
        color: #03c75a; font-weight: bold; font-size: 14px;
        cursor: pointer;
    }
    .btn-reserve:hover { background-color: #f9f9f9; }

    /* 오른쪽 이미지 영역 */
    .img-area { margin-left: 15px; }
    .profile-img {
        width: 80px; height: 80px;
        border-radius: 10px; /* 네이버 스타일 둥근 사각형 */
        object-fit: cover;
        background-color: #eee;
    }
    
    /* 링크 밑줄 제거 */
    a { text-decoration: none; color: inherit; display: block; }
</style>
</head>
<body>

    <ul class="nav-tabs">
        <li>홈</li>
        <li>소식</li>
        <li>가격</li>
        <li class="active">예약</li> <li>스타일</li>
        <li>리뷰</li>
    </ul>

    <div style="background:#f4f7f8; padding: 15px; font-size: 13px; color:#555; text-align: center;">
        <span style="color:#03c75a;">✔</span> 매장 시스템과 연동된 실시간예약 매장입니다.
    </div>

    <div class="designer-list">
        <% for(DesignerVO vo : list) { %>
        
        <a href="designerDetail.jsp?id=<%= vo.getId() %>">
            <div class="designer-card">
                
                <div class="info-area">
                    <div class="name-row">
                        <%= vo.getName() %> 
                        <span class="badge-npay">N pay</span>
                    </div>
                    <div class="desc-row">
                        <%= vo.getInfo() %> · 리뷰 <%= vo.getReviewCnt() %>
                    </div>
                    <button type="button" class="btn-reserve">📅 예약</button>
                </div>

                <div class="img-area">
                    <img src="<%= vo.getImgUrl() %>" class="profile-img">
                </div>
                
            </div>
        </a>
        <% } %>
    </div>

</body>
</html>