/* TABLE 테이블
1. 테이블명 컬럼명은 최대 30byte 까지 올 수 있음
2. 테이블명 컬럼명으로 예약어(CREATE, SELECT 등)는 사용할 수 없다.
3. 테이블명 컬럼명으로 문자, 숫자, _, $, # 은 사용할 수 있지만 첫 글자는 문자만 가능
4. 한 테이블에 컬럼은 최대 255개 까지 
*/

-- 테이블 생성(컬럼끼리의 구분은 콤마)
 CREATE TABLE ex1_1(
  col1 CHAR(10)     -- 고정형
, col2 VARCHAR2(10) -- 가변형 (공간의 효율화를 위해 VARCHAR2 사용)
);


--데이터 삽입
 INSERT INTO ex1_1 (col1, col2)
VALUES ('abc', 'abc');


--데이터 조회
SELECT  col1 , length(col1)
      , col2 , length(col2)
       FROM ex1_1;
       
       
-- 테이블 삭제
DROP TABLE ex1_1;