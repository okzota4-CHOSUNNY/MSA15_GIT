/* 
   [뉴아즈 네일샵 관리 시스템 - MySQL 실전 고도화 스크립트]
   동료님! 이 코드로 워크벤치에서 '번개 아이콘'을 눌러주세요.
*/

-- 1. 데이터베이스 생성 및 선택
CREATE DATABASE IF NOT EXISTS nuage_db;
USE nuage_db;

-- 2. 기존 테이블 삭제 (초기화용)
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS reservations;
DROP TABLE IF EXISTS services;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS admins;
SET FOREIGN_KEY_CHECKS = 1;

-- 3. 점주/직원 테이블 (admins)
CREATE TABLE admins (
    admin_id VARCHAR(20) PRIMARY KEY,       
    admin_pw VARCHAR(100) NOT NULL,        
    name VARCHAR(30) NOT NULL,             
    role VARCHAR(20) DEFAULT 'STAFF',   -- OWNER, STAFF   
    store_name VARCHAR(50) DEFAULT '뉴아즈'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 4. 고객 테이블 (customers) - [요청하신 8개 컬럼으로 최적화]
CREATE TABLE customers (
    cust_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,            -- 이름
    gender VARCHAR(10),                   -- 성별
    phone VARCHAR(20) NOT NULL,           -- 휴대전화
    membership_balance INT DEFAULT 0,     -- 보유이용권
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 등록일자
    last_visit_date DATETIME,             -- 최근방문일
    staff_name VARCHAR(30),               -- 담당자
    memo TEXT                             -- 비고
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 5. 시술 종류 테이블 (services)
CREATE TABLE services (
    service_id INT AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(50) NOT NULL,
    price INT DEFAULT 0,
    duration INT DEFAULT 60,            
    emoji VARCHAR(10)                     
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 6. 예약 현황 테이블 (reservations)
CREATE TABLE reservations (
    res_id INT AUTO_INCREMENT PRIMARY KEY,
    cust_id INT,
    admin_id VARCHAR(20),
    staff_name VARCHAR(30),               -- 추가: 담당 직원 이름
    res_date VARCHAR(20),                  -- 추가: 예약 날짜
    service_id INT,
    start_time DATETIME NOT NULL,         
    end_time DATETIME NOT NULL,           
    cost INT DEFAULT 0,                   -- 추가: 결제 금액
    memo TEXT,                            -- 추가: 관리 메모
    status VARCHAR(20) DEFAULT 'CONFIRMED',
    FOREIGN KEY (cust_id) REFERENCES customers(cust_id),
    FOREIGN KEY (admin_id) REFERENCES admins(admin_id),
    FOREIGN KEY (service_id) REFERENCES services(service_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- [기본 데이터 입력]
INSERT INTO admins (admin_id, admin_pw, name, role) VALUES ('owner', '1234', '조성은', 'OWNER');
INSERT INTO admins (admin_id, admin_pw, name, role) VALUES ('staff1', '1234', '유재인', 'STAFF');

INSERT INTO services (service_name, price, duration, emoji) VALUES ('젤 네일 (원톤)', 40000, 60, '💅');
INSERT INTO services (service_name, price, duration, emoji) VALUES ('젤 네일 (아트)', 60000, 90, '🎨');
