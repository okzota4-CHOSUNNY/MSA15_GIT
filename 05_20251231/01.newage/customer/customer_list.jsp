<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.sql.*" %>
        <!DOCTYPE html>
        <html lang="ko">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>뉴아즈 네일샵 - 고객 관리</title>
            <link rel="stylesheet" href="css/common.css">
            <style>
                .customer-container {
                    max-width: 1000px;
                    margin: 20px auto;
                    padding: 0 15px;
                }

                .card {
                    background: #fff;
                    padding: 25px;
                    border-radius: var(--radius-lg);
                    box-shadow: var(--shadow-soft);
                    margin-bottom: 25px;
                }

                .form-row {
                    display: grid;
                    grid-template-columns: 1fr 1fr 1fr;
                    gap: 15px;
                    margin-bottom: 15px;
                }

                .form-group label {
                    display: block;
                    margin-bottom: 5px;
                    font-weight: 600;
                    font-size: 14px;
                }

                .form-control {
                    width: 100%;
                    padding: 10px;
                    border: 1px solid #ddd;
                    border-radius: 8px;
                    box-sizing: border-box;
                }

                .customer-table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-top: 10px;
                    font-size: 14px;
                }

                .customer-table th,
                .customer-table td {
                    padding: 12px;
                    text-align: left;
                    border-bottom: 1px solid #f0f0f0;
                }

                .customer-table th {
                    background-color: #f9f9f9;
                    color: #666;
                    font-size: 13px;
                    white-space: nowrap;
                }

                .btn-detail {
                    border: none;
                    background: none;
                    color: var(--main-pink);
                    cursor: pointer;
                    font-weight: 600;
                }

                .search-box {
                    margin-bottom: 20px;
                    display: flex;
                    gap: 10px;
                    align-items: center;
                }

                .pagination {
                    display: flex;
                    justify-content: center;
                    gap: 5px;
                    margin-top: 25px;
                }

                .page-link {
                    padding: 8px 12px;
                    border: 1px solid #ddd;
                    border-radius: 4px;
                    text-decoration: none;
                    color: #333;
                    font-size: 14px;
                }

                .page-link.active {
                    background-color: var(--main-pink);
                    color: #fff;
                    border-color: var(--main-pink);
                }

                .page-link:hover:not(.active) {
                    background-color: #f5f5f5;
                }

                .page-info {
                    font-size: 14px;
                    color: #666;
                    margin-right: auto;
                }
            </style>
        </head>

        <body>
            <jsp:include page="include/navbar.jsp" />
            <main>
                <div class="customer-container">
                    <h1 class="dashboard-title">👥 고객 정보 관리</h1>
                    <div class="card">
                        <h2 style="font-size: 18px; color: var(--dusty-rose); margin-bottom: 15px;">✨ 신규 고객 등록</h2>
                        <form action="customer_process.jsp" method="post">
                            <div class="form-row">
                                <div class="form-group">
                                    <label>고객명</label>
                                    <input type="text" name="name" class="form-control" placeholder="성함" required>
                                </div>
                                <div class="form-group">
                                    <label>성별</label>
                                    <select name="gender" class="form-control">
                                        <option value="여">여성</option>
                                        <option value="남">남성</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>연락처</label>
                                    <input type="tel" name="phone" class="form-control" placeholder="010-0000-0000"
                                        required>
                                </div>
                            </div>
                            <div class="form-group" style="margin-bottom: 15px;">
                                <label>비고 (메모)</label>
                                <textarea name="memo" class="form-control" style="height: 60px;"
                                    placeholder="특이사항 입력"></textarea>
                            </div>
                            <button type="submit" class="btn-primary" style="width: 100%;">고객 등록하기</button>
                        </form>
                    </div>
                    <div class="card">
                        <% request.setCharacterEncoding("UTF-8"); String search=request.getParameter("search");
                            if(search==null) search="" ; int listSize=10; String sizeParam=request.getParameter("size");
                            if(sizeParam !=null && !sizeParam.isEmpty()) { listSize=Integer.parseInt(sizeParam); } int
                            curPage=1; String pageParam=request.getParameter("page"); if(pageParam !=null &&
                            !pageParam.isEmpty()) { curPage=Integer.parseInt(pageParam); } int totalCount=0; int
                            totalPage=1; int startRow=(curPage - 1) * listSize; Connection conn=null; PreparedStatement
                            pstmt=null; ResultSet rs=null; try { String
                            url="jdbc:mysql://localhost:3306/nuage_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"
                            ; String dbId="root" ; String dbPw="123456" ; Class.forName("com.mysql.cj.jdbc.Driver");
                            conn=DriverManager.getConnection(url, dbId, dbPw); String
                            countSql="SELECT COUNT(*) FROM customers WHERE name LIKE ? OR phone LIKE ?" ;
                            pstmt=conn.prepareStatement(countSql); pstmt.setString(1, "%" + search + "%" );
                            pstmt.setString(2, "%" + search + "%" ); rs=pstmt.executeQuery(); if(rs.next())
                            totalCount=rs.getInt(1); totalPage=(int)Math.ceil((double)totalCount / listSize);
                            if(totalPage==0) totalPage=1; String
                            sql="SELECT * FROM customers WHERE name LIKE ? OR phone LIKE ? ORDER BY cust_id DESC LIMIT ? OFFSET ?"
                            ; pstmt=conn.prepareStatement(sql); pstmt.setString(1, "%" + search + "%" );
                            pstmt.setString(2, "%" + search + "%" ); pstmt.setInt(3, listSize); pstmt.setInt(4,
                            startRow); rs=pstmt.executeQuery(); %>
                            <div class="search-box">
                                <div class="page-info">
                                    <% if(!search.isEmpty()){ %>
                                        '<strong>
                                            <%= search %>
                                        </strong>' 검색 결과:
                                        <% } %>
                                            총 <strong>
                                                <%= String.format("%,d", totalCount) %>
                                            </strong>명
                                </div>
                                <form action="customer_list.jsp" method="get"
                                    style="display: flex; gap: 5px; align-items: center;">
                                    <input type="hidden" name="search" value="<%= search %>">
                                    <select name="size" class="form-control" style="width: 120px;"
                                        onchange="this.form.submit()">
                                        <option value="10" <%=listSize==10 ? "selected" : "" %>>10명씩 보기</option>
                                        <option value="30" <%=listSize==30 ? "selected" : "" %>>30명씩 보기</option>
                                        <option value="50" <%=listSize==50 ? "selected" : "" %>>50명씩 보기</option>
                                    </select>
                                </form>
                                <form action="customer_list.jsp" method="get" style="display: flex; gap: 5px;">
                                    <input type="hidden" name="size" value="<%= listSize %>">
                                    <input type="text" name="search" class="form-control" style="width: 200px;"
                                        placeholder="이름 또는 연락처" value="<%= search %>">
                                    <button type="submit" class="btn-primary" style="width: 80px;">검색</button>
                                </form>
                            </div>
                            <div style="overflow-x: auto;">
                                <table class="customer-table">
                                    <thead>
                                        <tr>
                                            <th>번호</th>
                                            <th>이름</th>
                                            <th>성별</th>
                                            <th>휴대전화</th>
                                            <th>보유이용권</th>
                                            <th>등록일자</th>
                                            <th>담당자</th>
                                            <th>비고</th>
                                            <th>관리</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% boolean hasData=false; while (rs.next()) { hasData=true; int
                                            custId=rs.getInt("cust_id"); String name=rs.getString("name"); String
                                            gender=rs.getString("gender") !=null ? rs.getString("gender") : "-" ; String
                                            phone=rs.getString("phone"); int balance=rs.getInt("membership_balance");
                                            String regDate=rs.getTimestamp("reg_date") !=null ?
                                            rs.getTimestamp("reg_date").toString().substring(0, 10) : "-" ; String
                                            staff=rs.getString("staff_name") !=null ? rs.getString("staff_name") : "-" ;
                                            String memo=rs.getString("memo") !=null ? rs.getString("memo") : "" ; %>
                                            <tr>
                                                <td style="color: #999; font-size: 12px;">
                                                    <%= custId %>
                                                </td>
                                                <td style="font-weight: 700;">
                                                    <%= name %>
                                                </td>
                                                <td>
                                                    <%= gender %>
                                                </td>
                                                <td>
                                                    <%= phone %>
                                                </td>
                                                <td style="color:var(--main-pink); font-weight:600;">
                                                    <%= String.format("%,d", balance) %>원
                                                </td>
                                                <td style="font-size: 12px; color: #888;">
                                                    <%= regDate %>
                                                </td>
                                                <td>
                                                    <%= staff %>
                                                </td>
                                                <td
                                                    style="font-size: 12px; color: #666; max-width: 150px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
                                                    <%= memo %>
                                                </td>
                                                <td><button class="btn-detail">상세</button></td>
                                            </tr>
                                            <% } if (!hasData) { out.println("<tr>
                                                <td colspan='9' style='text-align:center; padding: 50px 0;'>결과가 없습니다.
                                                </td>
                                                </tr>");
                                                }
                                                } catch (Exception e) {
                                                e.printStackTrace();
                                                out.println("<tr>
                                                    <td colspan='9'
                                                        style='text-align:center; color:red; padding:30px 0;'>로딩 오류: " +
                                                        e.toString() + "</td>
                                                </tr>");
                                                } finally {
                                                if (rs != null) try { rs.close(); } catch (Exception e) {}
                                                if (pstmt != null) try { pstmt.close(); } catch (Exception e) {}
                                                if (conn != null) try { conn.close(); } catch (Exception e) {}
                                                }
                                                %>
                                    </tbody>
                                </table>
                            </div>
                            <div class="pagination">
                                <% int startPage=((curPage - 1) / 10) * 10 + 1; int endPage=startPage + 9; if(endPage>
                                    totalPage) endPage = totalPage;
                                    if(startPage > 1) {
                                    %>
                                    <a href="customer_list.jsp?page=<%= startPage - 1 %>&size=<%= listSize %>&search=<%= search %>"
                                        class="page-link">&laquo;</a>
                                    <% } for(int i=startPage; i <=endPage; i++) { %>
                                        <a href="customer_list.jsp?page=<%= i %>&size=<%= listSize %>&search=<%= search %>"
                                            class="page-link <%= (i == curPage) ? " active" : "" %>"><%= i %></a>
                                        <% } if(endPage < totalPage) { %>
                                            <a href="customer_list.jsp?page=<%= endPage + 1 %>&size=<%= listSize %>&search=<%= search %>"
                                                class="page-link">&raquo;</a>
                                            <% } %>
                            </div>
                    </div>
                </div>
            </main>
        </body>

        </html>