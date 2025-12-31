<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>뉴아즈 네일샵</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/service_management.css">
    </head>

    <body>
        <jsp:include page="include/navbar.jsp" />

        <main>
            <div class="management-container">
                <h1 class="dashboard-title">💅 시술 항목 관리</h1>
                <p style="color: var(--dusty-rose); margin-bottom: 30px;">매장에서 제공하는 시술명과 이모지를 자유롭게 관리하세요.</p>

                <!-- 시술 추가 폼 -->
                <div class="add-form">
                    <input type="text" id="new-emoji" placeholder="이모지 (예: 🎨)" style="width: 80px; flex: none;">
                    <input type="text" id="new-name" placeholder="시술명 (예: 원컬러 젤)">
                    <input type="number" id="new-duration" placeholder="소요 시간 (분)">
                    <button class="btn-add" onclick="addService()">+ 항목 추가</button>
                </div>

                <!-- 시술 리스트 (카드형) -->
                <div class="card-grid" id="service-list">
                    <!-- 초기 예시 항목들 -->
                    <div class="service-card">
                        <button class="btn-delete" title="삭제" onclick="$(this).parent().remove()">×</button>
                        <div class="service-emoji">💅</div>
                        <div class="service-name">젤 네일 (기본)</div>
                        <div class="service-duration">60분 소요</div>
                    </div>
                    <div class="service-card">
                        <button class="btn-delete" title="삭제" onclick="$(this).parent().remove()">×</button>
                        <div class="service-emoji">✨</div>
                        <div class="service-name">파츠 무제한</div>
                        <div class="service-duration">90분 소요</div>
                    </div>
                    <div class="service-card">
                        <button class="btn-delete" title="삭제" onclick="$(this).parent().remove()">×</button>
                        <div class="service-emoji">🎨</div>
                        <div class="service-name">원컬러 젤</div>
                        <div class="service-duration">45분 소요</div>
                    </div>
                </div>

                <div style="text-align: center; margin-top: 50px;">
                    <button class="btn-primary" onclick="location.href='reservation_dashboard.jsp'">📅 대시보드로
                        돌아가기</button>
                </div>
            </div>
        </main>

        <script>
            function addService() {
                const emoji = $('#new-emoji').val();
                const name = $('#new-name').val();
                const duration = $('#new-duration').val();

                if (!emoji || !name || !duration) {
                    alert('모든 필드를 입력해주세요!');
                    return;
                }

                const cardHtml = `
                <div class="service-card">
                    <button class="btn-delete" title="삭제" onclick="$(this).parent().remove()">×</button>
                    <div class="service-emoji">${emoji}</div>
                    <div class="service-name">${name}</div>
                    <div class="service-duration">${duration}분 소요</div>
                </div>
            `;
                $('#service-list').append(cardHtml);

                // 입력창 초기화
                $('#new-emoji, #new-name, #new-duration').val('');
            }
        </script>

        <!-- 푸터 제거됨 -->

        <style>
            .btn-primary {
                padding: 12px 30px;
                background-color: var(--dusty-rose);
                color: #fff;
                border: none;
                border-radius: var(--radius-md);
                font-weight: 700;
                cursor: pointer;
            }
        </style>
    </body>

    </html>