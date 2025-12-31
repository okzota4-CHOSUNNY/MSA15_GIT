<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>뉴아즈 네일샵 - 통계분석</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="css/common.css">
        <style>
            .stats-container {
                max-width: 600px;
                margin: 20px auto;
                padding: 0 15px;
            }

            .stats-section {
                background-color: #2ecc71;
                /* 즐겨찾기 녹색 헤더 */
                color: #fff;
                padding: 10px 15px;
                border-radius: 8px 8px 0 0;
                display: flex;
                justify-content: space-between;
                align-items: center;
                font-weight: 700;
            }

            .stats-list {
                background: #fff;
                border: 1px solid #ddd;
                border-radius: 0 0 8px 8px;
                margin-bottom: 20px;
            }

            .stats-item {
                display: flex;
                align-items: center;
                padding: 15px;
                border-bottom: 1px solid #f0f0f0;
                cursor: pointer;
                transition: background 0.2s;
            }

            .stats-item:hover {
                background-color: #f9f9f9;
            }

            .stats-item:last-child {
                border-bottom: none;
            }

            .item-category {
                background: #f0f0f0;
                padding: 2px 6px;
                border-radius: 4px;
                font-size: 11px;
                margin-right: 12px;
                color: #666;
                min-width: 50px;
                text-align: center;
            }

            .item-content {
                flex: 1;
            }

            .item-title {
                font-size: 15px;
                font-weight: 600;
                color: #333;
            }

            .item-desc {
                font-size: 12px;
                color: #999;
                margin-top: 3px;
            }

            .item-star {
                color: #f1c40f;
                margin-left: 10px;
                font-size: 18px;
            }
        </style>
    </head>

    <body>
        <!-- 공통 내비게이션 포함 -->
        <jsp:include page="include/navbar.jsp" />

        <main>
            <div class="stats-container">
                <h2 style="font-size: 20px; margin-bottom: 15px;">📈 통계분석</h2>

                <!-- 즐겨찾기 섹션 (별표 항목들) -->
                <div class="stats-section">
                    <span>즐겨찾기</span>
                    <button
                        style="background:none; border:1px solid #fff; color:#fff; border-radius:4px; font-size:12px; padding:2px 8px;">편집</button>
                </div>
                <div class="stats-list">
                    <!-- 1. 매출분석 -->
                    <div class="stats-item">
                        <span class="item-category">매출분석</span>
                        <div class="item-content">
                            <div class="item-title">월간 결제 수단별 통계[금년]</div>
                            <div class="item-desc">올해 월간 결제 수단별 통계를 보여줍니다.</div>
                        </div>
                        <span class="item-star">★</span>
                    </div>
                    <div class="stats-item">
                        <span class="item-category">매출분석</span>
                        <div class="item-content">
                            <div class="item-title">월간 관리별 통계[금년]</div>
                            <div class="item-desc">올해 월간 관리별 통계를 보여줍니다.</div>
                        </div>
                        <span class="item-star">★</span>
                    </div>
                    <div class="stats-item">
                        <span class="item-category">매출분석</span>
                        <div class="item-content">
                            <div class="item-title">일간 매출 구분별 통계[금월]</div>
                            <div class="item-desc">일 매출 구분별 통계를 보여줍니다.</div>
                        </div>
                        <span class="item-star">★</span>
                    </div>

                    <!-- 2. 고객분석 -->
                    <div class="stats-item">
                        <span class="item-category">고객분석</span>
                        <div class="item-content">
                            <div class="item-title">노쇼정보현황[금년]</div>
                            <div class="item-desc">노쇼 횟수가 많은 고객 10명을 보여줍니다.</div>
                        </div>
                        <span class="item-star">★</span>
                    </div>
                    <div class="stats-item">
                        <span class="item-category">고객분석</span>
                        <div class="item-content">
                            <div class="item-title">예약취소현황[금년]</div>
                            <div class="item-desc">예약취소 횟수가 많은 고객 10명을 보여줍니다.</div>
                        </div>
                        <span class="item-star">★</span>
                    </div>
                    <div class="stats-item">
                        <span class="item-category">고객분석</span>
                        <div class="item-content">
                            <div class="item-title">방문순위[금년]</div>
                            <div class="item-desc">방문수가 많은 순으로 10명을 보여줍니다.</div>
                        </div>
                        <span class="item-star">★</span>
                    </div>
                    <div class="stats-item">
                        <span class="item-category">고객분석</span>
                        <div class="item-content">
                            <div class="item-title">월별신규방문자[최근3년]</div>
                            <div class="item-desc">최근 3년 월별, 연도별 신규 고객수를 보여줍니다.</div>
                        </div>
                        <span class="item-star">★</span>
                    </div>

                    <!-- 3. 회원권분석 -->
                    <div class="stats-item">
                        <span class="item-category">회원권</span>
                        <div class="item-content">
                            <div class="item-title">만료예정 금액권</div>
                            <div class="item-desc">만료 예정인 금액권 목록을 보여줍니다.</div>
                        </div>
                        <span class="item-star">★</span>
                    </div>
                </div>
            </div>
        </main>
    </body>

    </html>