<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <header class="site-header">
        <div class="header-container">
            <!-- 로고 영역: 클릭 시 홈으로 이동 (임시로 index.jsp) -->
            <a href="index.jsp" class="logo-area">
                <span class="logo-icon">✂️</span>
                <span class="site-title">망머샵 미용실</span>
            </a>

            <!-- 사용자 메뉴 영역 -->
            <div class="user-menu">
                <!-- 로그인 링크 -->
                <a href="login.jsp" class="login-link">
                    <span class="login-icon">👤</span>
                    <span class="login-text">로그인</span>
                </a>
                <span class="menu-divider">|</span>
                <!-- 회원가입 링크 -->
                <a href="signup_customer.jsp" class="login-link">
                    <span class="signup-text">회원가입</span>
                </a>
            </div>
        </div>
    </header>