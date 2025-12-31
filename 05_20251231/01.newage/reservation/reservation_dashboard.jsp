<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <title>뉴아즈 네일샵 - 대시보드</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/reservation_dashboard.css">
        <style>
            .res-block {
                position: absolute;
                left: 5%;
                width: 90%;
                background: rgba(255, 182, 193, 0.9);
                border-left: 5px solid #ff758c;
                border-radius: 4px;
                font-size: 11px;
                padding: 6px;
                color: #333;
                box-sizing: border-box;
                overflow: hidden;
                z-index: 10;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                cursor: pointer;
            }

            .res-block:hover {
                transform: scale(1.03);
                background: #ffb6c1;
            }

            .res-block.staff-owner {
                background: #ffe4e1;
                border-color: #ffb6c1;
            }

            .res-block.staff1 {
                background: #e0f7fa;
                border-color: #4dd0e1;
            }

            .time-select-group select {
                padding: 6px;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 13px;
            }
        </style>
    </head>

    <body>
        <jsp:include page="include/navbar.jsp" />
        <main id="dashboardMain">
            <div class="dashboard-container">
                <div class="calendar-nav">
                    <div class="nav-center"><span>2025. 12/28 - 1/3</span></div>
                    <div class="nav-right"><button class="btn-nav"
                            style="background:#ff758c; color:#fff; border:none; font-weight:700;">+ 예약등록</button></div>
                </div>
                <div class="week-grid-wrapper">
                    <div class="week-header">
                        <div style="width:var(--time-col-width); border-right:1px solid #eee;"></div>
                        <div class="day-header">12/28(일)</div>
                        <div class="day-header">12/29(월)</div>
                        <div class="day-header today">12/30(화)</div>
                        <div class="day-header">12/31(수)</div>
                        <div class="day-header">01/01(목)</div>
                        <div class="day-header">01/02(금)</div>
                        <div class="day-header">01/03(토)</div>
                    </div>
                    <div class="grid-body">
                        <div class="time-axis">
                            <div class="time-label"></div>
                            <% for(int i=9; i<=20; i++) { %>
                                <div class="time-label">
                                    <%= (i<12?"AM ":" PM ")+(i<=12?i:i-12) %></div>
                        <% } %>
                    </div>
                    <div class=" days-container">
                                        <% for(int i=0; i<7; i++) { %>
                                            <div class="day-column"></div>
                                            <% } %>
                                </div>
                        </div>
                    </div>
                </div>

                <div id="rightRegPanel" style="width:400px; border-left:1px solid #ddd; background:#fff;">
                    <div class="panel-content" style="padding:20px;">
                        <div class="search-box">
                            <label>고객 검색</label>
                            <input type="text" id="custInput" class="form-field" placeholder="이름/번호 입력..."
                                oninput="handleSearch(this.value)">
                            <div id="searchResults"
                                style="display:none; position:absolute; background:#fff; border:1px solid #ddd; width:350px; z-index:100;">
                            </div>
                        </div>
                        <div id="selectedCust" style="display:none; margin:10px 0; padding:10px; background:#f9f9f9;">
                            <b id="custName"></b> (<span id="custPhone"></span>)
                        </div>
                        <div class="form-row">
                            <label>예약날짜</label><input type="date" id="resDate" class="form-field" value="2025-12-30">
                        </div>
                        <div class="form-row">
                            <label>시술시간 (10분 단위)</label>
                            <div class="time-select-group" style="display:flex; align-items:center; gap:5px;">
                                <select id="sH">
                                    <% for(int i=9; i<=20; i++) { %>
                                        <option value="<%=String.format(" %02d",i)%>" <%=i==14?"selected":""%>><%=i%>시
                                        </option>
                                        <%}%>
                                </select> :
                                <select id="sM">
                                    <% for(int i=0; i<60; i+=10) { %>
                                        <option value="<%=String.format(" %02d",i)%>"><%=i%>분</option>
                                        <%}%>
                                </select> ~
                                <select id="eH">
                                    <% for(int i=9; i<=20; i++) { %>
                                        <option value="<%=String.format(" %02d",i)%>" <%=i==15?"selected":""%>><%=i%>시
                                        </option>
                                        <%}%>
                                </select> :
                                <select id="eM">
                                    <% for(int i=0; i<60; i+=10) { %>
                                        <option value="<%=String.format(" %02d",i)%>" <%=i==30?"selected":""%>><%=i%>분
                                        </option>
                                        <%}%>
                                </select>
                            </div>
                        </div>
                        <button class="btn-reg" onclick="saveRes()"
                            style="width:100%; padding:15px; background:#ff758c; color:#fff; border:none; margin-top:15px; cursor:pointer;">예약등록</button>
                    </div>
                </div>
        </main>

        <script>
            let curId = null;
            function handleSearch(v) {
                if (v.length < 2) return;
                $.ajax({
                    url: 'customer_search_ajax.jsp', data: { q: v }, success: function (customers) {
                        let h = ''; customers.forEach(c => { h += '<div style="padding:10px; cursor:pointer; border-bottom:1px solid #eee;" onclick="sel(\'' + c.id + '\',\'' + c.name + '\',\'' + c.phone + '\')">' + c.name + '(' + c.phone + ')</div>'; });
                        $('#searchResults').html(h).show();
                    }
                });
            }
            function sel(id, n, p) { curId = id; $('#custName').text(n); $('#custPhone').text(p); $('#selectedCust').show(); $('#searchResults').hide(); }

            function saveRes() {
                if (!curId) { alert('고객을 선택해 주세요!'); return; }
                const data = {
                    custId: curId, resDate: $('#resDate').val(), staffName: $('#staffName').val(),
                    startTime: $('#sH').val() + ':' + $('#sM').val(), endTime: $('#eH').val() + ':' + $('#eM').val(),
                    cost: $('#cost').val()
                };
                $.ajax({ url: 'reservation_process_ajax.jsp', type: 'POST', data: data, success: function (r) { alert(r.message); loadRes(); } });
            }

            function loadRes() {
                $.ajax({
                    url: 'get_reservations_ajax.jsp', success: function (list) {
                        $('.day-column').empty();
                        list.forEach(res => {
                            const s = new Date(res.startTime.replace(/-/g, '/'));
                            const e = new Date(res.endTime.replace(/-/g, '/'));
                            let idx = -1;
                            if (res.resDate === '2025-12-30') idx = 2;
                            else if (res.resDate === '2025-12-28') idx = 0;
                            else if (res.resDate === '2025-12-29') idx = 1;
                            else if (res.resDate === '2025-12-31') idx = 3;

                            if (idx !== -1) {
                                const top = (s.getHours() - 9) * 100 + (s.getMinutes() * 100 / 60);
                                const dur = (e - s) / (1000 * 60);
                                const h = (dur * 100 / 60);
                                const block = $('<div class="res-block">').css({ top: top + 'px', height: h + 'px' })
                                    .html('<div class="res-title">' + res.custName + '</div><div class="res-time">' + s.getHours() + ':' + (s.getMinutes() < 10 ? '0' : '') + s.getMinutes() + ' (' + dur + '분)</div>');
                                $('.day-column').eq(idx).append(block);
                            }
                        });
                    }
                });
            }
            $(document).ready(function () { loadRes(); });
        </script>
    </body>

    </html>