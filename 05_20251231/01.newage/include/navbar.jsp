<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- 실무형 통합 헤더 -->
    <header>
        <!-- [수정] 1단: 블랙 상태 바 - 상호명 중앙 배치 및 불필요한 만료/캐시 정보 삭제 -->
        <div class="top-admin-bar">
            <div class="top-left-info">
                <!-- 원장님 요청으로 왼쪽 만료일/캐시 정보 삭제됨 -->
            </div>
            <!-- [수정] 상호명 '뉴아즈' 중앙 정렬 반영 -->
            <div class="brand-name">뉴아즈</div>
            <div class="top-right-info">
                <span>'조성은' 원장님</span>
                <!-- [수정] 로그아웃 링크를 버튼 스타일로 개선 -->
                <button class="logout-btn" onclick="location.href='login.jsp'">로그아웃</button>
            </div>
        </div>

        <!-- 2단: 8대 핵심 아이콘 내비게이션 (모든 JSP 표현식은 문법 오류 방지를 위해 한 줄로 작성) -->
        <nav class="main-icon-nav">
            <!-- [학습 포인트] request.getRequestURI().contains()를 사용해 현재 접속한 페이지를 인식하고, 해당 메뉴에 'active' 클래스를 부여하여 불이 들어오게 만듭니다. -->
            <a href="reservation_dashboard.jsp" class="nav-icon-item <%= request.getRequestURI().contains("
                reservation_dashboard") ? "active" : "" %>">
                <span class="icon-img">📅</span>
                <span>스케줄</span>
            </a>
            <a href="#" class="nav-icon-item">
                <span class="icon-img">💰</span>
                <span>매출매입</span>
            </a>
            <a href="#" class="nav-icon-item">
                <span class="icon-img">💅</span>
                <span>제품</span>
            </a>
            <a href="https://www.sweettracker.co.kr/" target="_blank" class="nav-icon-item">
                <span class="icon-img">✉️</span>
                <span>문자</span>
            </a>
            <!-- [참고] 고객 관리 페이지 연결 -->
            <a href="customer_list.jsp" class="nav-icon-item <%= request.getRequestURI().contains(" customer_list")
                ? "active" : "" %>">
                <span class="icon-img">👥</span>
                <span>고객</span>
            </a>
            <a href="#" class="nav-icon-item">
                <span class="icon-img">📊</span>
                <span>집계</span>
            </a>
            <!-- [참고] 통계 분석 페이지 연결 -->
            <a href="stats_analysis.jsp" class="nav-icon-item <%= request.getRequestURI().contains(" stats_analysis")
                ? "active" : "" %>">
                <span class="icon-img">📈</span>
                <span>통계분석</span>
            </a>
            <!-- [참고] 시술 종류 등 환경 설정 페이지 연결 -->
            <a href="service_management.jsp" class="nav-icon-item <%= request.getRequestURI().contains("
                service_management") ? "active" : "" %>">
                <span class="icon-img">⚙️</span>
                <span>환경설정</span>
            </a>
        </nav>
    </header>