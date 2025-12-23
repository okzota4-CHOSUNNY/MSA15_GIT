package com.board.model;
// ↑ 패키지 선언

import java.sql.Date;
// ↑ 날짜 도구 가져오기

public class BoardVO {

    // 1. 변수들 (그대로 둠)
    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date regDate;

    // 2. Getter / Setter 메서드 (롬복 대신 직접 써줍니다)
    // 이 코드가 있어야 DAO에서 vo.setSeq() 같은 걸 쓸 수 있습니다.

    public int getSeq() {
        return seq;
    }
    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}