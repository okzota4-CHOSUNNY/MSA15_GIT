DROP TABLE IF EXISTS board;
CREATE TABLE board (
    no INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK',
    id VARCHAR(64) NOT NULL UNIQUE COMMENT 'UK',
    title VARCHAR(255) NOT NULL COMMENT '제목',
    writer VARCHAR(100) NOT NULL COMMENT '작성자',
    content TEXT NOT NULL COMMENT '내용',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '작성일',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
) COMMENT '게시판';


-- 샘플 데이터 추가
INSERT INTO board (id, title, writer, content) VALUES (UUID(), '제목01', '작성자01', '내용01');
INSERT INTO board (id, title, writer, content) VALUES (UUID(), '제목02', '작성자02', '내용02');
INSERT INTO board (id, title, writer, content) VALUES (UUID(), '제목03', '작성자03', '내용03');
INSERT INTO board (id, title, writer, content) VALUES (UUID(), '제목04', '작성자04', '내용04');
INSERT INTO board (id, title, writer, content) VALUES (UUID(), '제목05', '작성자05', '내용05');



-- 전체 실행(crtl + alt + X)
-- 데이터 조회 (alst + S)
SELECT * FROM board;
