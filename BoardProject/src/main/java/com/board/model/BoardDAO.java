package com.board.model; 
// ↑ 이 파일은 'com.board.model' 패키지 안에 위치합니다.

import java.sql.Connection; 
// ↑ DB와 연결된 통로(고속도로)를 의미하는 객체입니다.

import java.sql.DriverManager; 
// ↑ 드라이버를 통해 실제 DB 연결을 도와주는 관리자 클래스입니다.

import java.sql.PreparedStatement; 
// ↑ SQL문을 운반하고 실행해주는 택배 기사 같은 객체입니다.

import java.sql.ResultSet; 
// ↑ SELECT(조회) 결과를 담아오는 결과 테이블 객체입니다.

import java.util.ArrayList; 
// ↑ 크기가 자유롭게 늘어나는 배열(리스트) 구현체입니다.

import java.util.List; 
// ↑ 리스트의 껍데기(인터페이스)입니다.

public class BoardDAO { 
// ↑ DB 작업을 전담하는 DAO(Data Access Object) 클래스 시작

    // 1. DB 접속 정보 설정 (본인 환경에 맞게 수정하세요!)
    private String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
    // ↑ 접속 주소: localhost(내컴퓨터), 1521(포트), xe(DB이름)

    private String uid = "scott"; 
    // ↑ 오라클 사용자 아이디 (본인 거로 바꾸세요. 예: system, c##hr 등)

    private String upw = "tiger"; 
    // ↑ 오라클 비밀번호 (본인 거로 바꾸세요)


    // 2. DB 연결을 돕는 공통 메서드 (접속 도우미)
    public Connection getConnection() throws Exception { 
    // ↑ DB 연결 객체(Connection)를 반환하는 메서드입니다. 예외가 발생하면 던집니다.
    
        Class.forName("oracle.jdbc.driver.OracleDriver"); 
        // ↑ 오라클 드라이버(ojdbc8.jar) 프로그램을 메모리에 로딩합니다.
        
        return DriverManager.getConnection(url, uid, upw); 
        // ↑ 주소, 아이디, 비번을 이용해 연결을 성공시키고 그 연결 끈(Connection)을 반환합니다.
    }


    // 3. [기능 1] 게시글 목록 전체 조회 (Read)
    public List<BoardVO> getBoardList() { 
    // ↑ 게시글 여러 개(List)를 가져오는 메서드입니다. 결과물은 BoardVO들이 담긴 리스트입니다.
    
        List<BoardVO> list = new ArrayList<>(); 
        // ↑ 데이터를 담을 빈 리스트 가방을 하나 만듭니다.

        String sql = "SELECT * FROM BOARD ORDER BY SEQ DESC"; 
        // ↑ 실행할 SQL: 모든 컬럼(*)을 조회하되, 번호(SEQ)가 큰 순서(DESC, 최신순)로 정렬합니다.

        // try-with-resources: 괄호() 안의 자원(conn, pstmt, rs)은 작업이 끝나면 자동으로 닫힙니다. (메모리 누수 방지)
        try (
            Connection conn = getConnection(); 
            // ↑ 위에서 만든 도우미를 통해 DB에 접속합니다.

            PreparedStatement pstmt = conn.prepareStatement(sql); 
            // ↑ SQL 문장을 실행할 준비를 합니다.

            ResultSet rs = pstmt.executeQuery(); 
            // ↑ 준비된 SQL을 실행(Query)하고, 그 결과표를 rs 변수에 받습니다.
        ) {
            
            // rs.next(): 결과표에 다음 줄(데이터)이 있으면 true, 없으면 false를 반환합니다.
            while (rs.next()) { 
            // ↑ 데이터가 있는 동안 계속 반복합니다. (게시글이 10개면 10번 돕니다)

                BoardVO vo = new BoardVO(); 
                // ↑ 빈 게시글 객체(그릇) 하나를 만듭니다. (롬복 덕분에 깔끔하게 생성)

                vo.setSeq(rs.getInt("SEQ")); 
                // ↑ DB 결과표의 'SEQ' 컬럼 값을 꺼내서 vo의 seq 변수에 넣습니다.

                vo.setTitle(rs.getString("TITLE")); 
                // ↑ 'TITLE' 값을 꺼내서 넣습니다.

                vo.setWriter(rs.getString("WRITER")); 
                // ↑ 'WRITER' 값을 꺼내서 넣습니다.

                vo.setContent(rs.getString("CONTENT")); 
                // ↑ 'CONTENT' 값을 꺼내서 넣습니다.

                vo.setRegDate(rs.getDate("REGDATE")); 
                // ↑ 'REGDATE' 값을 꺼내서 넣습니다.

                list.add(vo); 
                // ↑ 내용이 채워진 vo 객체를 리스트 가방에 추가합니다.
            }
            
        } catch (Exception e) { 
        // ↑ 에러가 발생하면 이곳으로 떨어집니다.
            e.printStackTrace(); 
            // ↑ 에러의 원인을 콘솔창에 빨간 글씨로 출력합니다.
        }

        return list; 
        // ↑ 게시글들이 가득 담긴 가방(list)을 호출한 사람에게 전달합니다.
    }


    // 4. [기능 2] 게시글 저장 (Create)
    public void insertBoard(BoardVO vo) { 
    // ↑ 게시글 하나(BoardVO)를 받아서 DB에 저장하는 메서드입니다.
    
        String sql = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?)"; 
        // ↑ 실행할 SQL: 값 들어갈 자리는 물음표(?)로 비워둡니다. 
        // BOARD_SEQ.NEXTVAL: 시퀀스가 자동으로 다음 번호를 매겨줍니다.

        try (
            Connection conn = getConnection(); 
            // ↑ DB 접속
            
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            // ↑ SQL 준비
        ) {
            
            // 물음표(?) 채우기 작업
            pstmt.setString(1, vo.getTitle()); 
            // ↑ 첫 번째 물음표(?)에 제목을 넣습니다.

            pstmt.setString(2, vo.getWriter()); 
            // ↑ 두 번째 물음표(?)에 작성자를 넣습니다.

            pstmt.setString(3, vo.getContent()); 
            // ↑ 세 번째 물음표(?)에 내용을 넣습니다.

            pstmt.executeUpdate(); 
            // ↑ 완성된 SQL을 실행합니다. (데이터 변경은 executeUpdate를 씁니다)
            
        } catch (Exception e) { 
        // ↑ 에러 처리
            e.printStackTrace(); 
        }
    }
}