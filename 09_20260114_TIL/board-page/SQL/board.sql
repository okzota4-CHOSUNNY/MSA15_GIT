-- Active: 1768361018455@@127.0.0.1@3306@aloha
-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS aloha;

-- 데이터베이스 사용
USE aloha;

-- 외래키 무시
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS board;
-- 게시판 테이블 생성
CREATE TABLE `aloha`.`board` (
  `no` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `id` varchar(64) DEFAULT NULL UNIQUE,
  `title` varchar(100) NOT NULL,
  `writer` varchar(100) NOT NULL,
  `content` text,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 샘플 데이터
TRUNCATE Table board;

INSERT INTO board (id, title, writer, content)
VALUES 
  ( UUID(), '제목1', '작성자1', '내용1'),
  ( UUID(), '제목2', '작성자2', '내용2'),
  ( UUID(), '제목3', '작성자3', '내용3'),
  ( UUID(), '제목4', '작성자4', '내용4'),
  ( UUID(), '제목5', '작성자5', '내용5')
;


-- 외래키 활성화
SET FOREIGN_KEY_CHECKS=1;

-- board 테이블과 file 테이블 조인
SELECT b.no
      ,b.title
      ,f.*
FROM board b
    ,file f
WHERE b.no = f.parent_no
  AND f.parent_table = 'board'
;