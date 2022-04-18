-- rollup 
-- 전체합계(총계)가 필요할때,
select period
    , decode(grouping_id(period, gubun), 1 , '소계'
                                       , 3 , '총계'
                                       , gubun) as gubun
    , sum(loan_jan_amt)  
from kor_loan_status
where period like '2013%'
group by rollup (period, gubun);


-- member의 직업별 마일리지의 합계를 출력하시오
select *
from member;

select mem_job
     , sum(mem_mileage) as 마일리지합계
from member
group by rollup(mem_job);

-- NVL은 NULL일때만 사용가능하다
select NVL(mem_job, '합 계')
     , sum(mem_mileage) as 마일리지합계
from member
group by rollup(mem_job);

select decode(grouping_id(mem_job), 1, '합 계', mem_job) as 직업
     , sum(mem_mileage) as 마일리지합계
from member
group by rollup(mem_job);


select mem_job
     , sum(mem_mileage) as 마일리지합계
from member
group by mem_job
UNION
SELECT null
      , sum(mem_mileage)
from member;


CREATE TABLE exp_goods_asia (
       country VARCHAR2(10),
       seq     NUMBER,
       goods   VARCHAR2(80));


-- 집합연산자 파일
INSERT INTO exp_goods_asia VALUES ('한국', 1, '원유제외 석유류');
INSERT INTO exp_goods_asia VALUES ('한국', 2, '자동차');
INSERT INTO exp_goods_asia VALUES ('한국', 3, '전자집적회로');
INSERT INTO exp_goods_asia VALUES ('한국', 4, '선박');
INSERT INTO exp_goods_asia VALUES ('한국', 5, 'LCD');
INSERT INTO exp_goods_asia VALUES ('한국', 6, '자동차부품');
INSERT INTO exp_goods_asia VALUES ('한국', 7, '휴대전화');
INSERT INTO exp_goods_asia VALUES ('한국', 8, '환식탄화수소');
INSERT INTO exp_goods_asia VALUES ('한국', 9, '무선송신기 디스플레이 부속품');
INSERT INTO exp_goods_asia VALUES ('한국', 10,'철 또는 비합금강');

INSERT INTO exp_goods_asia VALUES ('일본', 1, '자동차');
INSERT INTO exp_goods_asia VALUES ('일본', 2, '자동차부품');
INSERT INTO exp_goods_asia VALUES ('일본', 3, '전자집적회로');
INSERT INTO exp_goods_asia VALUES ('일본', 4, '선박');
INSERT INTO exp_goods_asia VALUES ('일본', 5, '반도체웨이퍼');
INSERT INTO exp_goods_asia VALUES ('일본', 6, '화물차');
INSERT INTO exp_goods_asia VALUES ('일본', 7, '원유제외 석유류');
INSERT INTO exp_goods_asia VALUES ('일본', 8, '건설기계');
INSERT INTO exp_goods_asia VALUES ('일본', 9, '다이오드, 트랜지스터');
INSERT INTO exp_goods_asia VALUES ('일본', 10, '기계류');

COMMIT;


SELECT goods
  FROM exp_goods_asia
 WHERE country = '한국'
 ORDER BY seq;

SELECT goods
  FROM exp_goods_asia
 WHERE country = '일본'
 ORDER BY seq;
 
 
 -- 집합연산자 union, unionall
 -- 행끼리 합칠때 사용
 -- 유니온은 컬럼의 개수를 맞춰야한다
 -- 정렬은 맨 마지막에
 -- union은 롤업대신에 사용가
 
 -- union all은 중복된 항도 모두 조회된다
 
 
 SELECT goods
  FROM exp_goods_asia
 WHERE country = '한국'
UNION 
SELECT goods
  FROM exp_goods_asia
 WHERE country = '일본';

SELECT goods
  FROM exp_goods_asia
 WHERE country = '한국'
UNION ALL
SELECT goods
  FROM exp_goods_asia
 WHERE country = '일본';
 
 
 -- 마이너스는 차집합
 SELECT goods
  FROM exp_goods_asia
 WHERE country = '한국'
MINUS
SELECT goods
  FROM exp_goods_asia
 WHERE country = '일본';  

SELECT goods
  FROM exp_goods_asia
 WHERE country = '일본'   
MINUS
SELECT goods
  FROM exp_goods_asia
 WHERE country = '한국';   

 -- intersect는 교집합
 
 SELECT goods
  FROM exp_goods_asia
 WHERE country = '한국'
INTERSECT
SELECT goods
  FROM exp_goods_asia
 WHERE country = '일본'; 
 
 -- 컬럼의 수와 타입이 맞아야함. 
SELECT goods
  FROM exp_goods_asia
 WHERE country = '한국'
UNION 
SELECT seq, goods
  FROM exp_goods_asia
 WHERE country = '일본'; 
 
 
SELECT seq, goods
  FROM exp_goods_asia
 WHERE country = '한국'
INTERSECT  -- 교집합 
SELECT seq, goods
  FROM exp_goods_asia
 WHERE country = '일본';  
 
  -- 정렬(order by)은 마지막에만 가능 
  
 SELECT goods
  FROM exp_goods_asia
 WHERE country = '한국'
UNION
SELECT goods
  FROM exp_goods_asia
 WHERE country = '일본'
  ORDER BY goods;  
  
  -- 테이블 생성 CREATE
  -- 테이블 삭제 DROP
  -- 테이블 수정 ALTER
  
  CREATE TABLE ex6_1(
     col1 varchar2(10) not null
    ,col2 varchar2(10) null
    ,col3 date default sysdate
  );
  -- drop table ex6_1;
  -- 컬럼명 수정
  alter table ex6_1 rename column col1 to co1_1;
  -- 타입 수정
  alter table ex6_1 modify col2 varchar2(30);
  -- 컬럼 추가
  alter table ex6_1 add col4 number;
  -- 컬럼삭제
  alter table ex6_1 drop column col4;
  -- 제약조건 추가
  alter table ex6_1 add constraint pk_ex6_1 primary key(col1);
  
  