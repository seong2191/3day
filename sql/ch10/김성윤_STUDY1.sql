/*
 STUDY 계정에 create_table 스크립트를 실해하여 
 테이블 생성후 1~ 5 데이터를 임포트한 뒤 
 아래 문제를 출력하시오 
 (문제에 대한 출력물은 이미지 참고)
*/
-----------1번 문제 ---------------------------------------------------
--1988년 이후 출생자의 직업이 의사,자영업 고객을 출력하시오 (어린 고객부터 출력)
SELECT to_char(birth,'yyyy') = '%19%'
FROM customer
where job = '자영업'
and job = '의사';

select *
from customer;

Q. 자영업이랑 의사를 같이 출력을 못하겠습니다..ㅠ

---------------------------------------------------------------------
-----------2번 문제 ---------------------------------------------------
--강남구에 사는 고객의 이름, 전화번호를 출력하시오 
select *
from address;

select b.customer_name
, b.phone_number
from address a, customer b
where a.zip_code = b.zip_code
and a.address_detail like '강남구';
---------------------------------------------------------------------
----------3번 문제 ---------------------------------------------------
--CUSTOMER에 있는 회원의 직업별 회원의 수를 출력하시오 (직업 NULL은 제외)
select *
from job;

select job
,(count(job))
from customer
where job is not null
group by job
order by 2 desc;

---------------------------------------------------------------------
----------4-1번 문제 ---------------------------------------------------
-- 가장 많이 가입(처음등록)한 요일과 건수를 출력하시오 
select *
from customer;

select *
from
(select to_char(first_reg_date,'day') as 요일
     , count(*) as 건수
from customer
group by to_char(first_reg_date,'day')
order by 2 desc)
where rownum = 1;


---------------------------------------------------------------------
----------4-2번 문제 ---------------------------------------------------
-- 남녀 인원수를 출력하시오 
select decode(sex_code,'M','남자','F','여자','미등록','4','합계') as gender
   , count(decode(sex_code,'M','남자','F','여자','?')) as cnt
from customer
group by rollup (sex_code);


select *
from customer;
---------------------------------------------------------------------
----------5번 문제 ---------------------------------------------------
--월별 예약 취소 건수를 출력하시오 (많은 달 부터 출력)

select to_char(reserv_date,'yyyymmdd'),'mm' as 월
     , count(cancel,'Y') as 취소건수
from reservation
where cancel = 'Y'
group by to_char(reserv_date,'yyyymmdd'),'mm'
order by 2;

select *
from reservation
where cancel = 'Y';
---------------------------------------------------------------------
----------6번 문제 ---------------------------------------------------
 -- 전체 상품별 '상품이름', '상품매출' 을 내림차순으로 구하시오 
 select *
 from item;
 
 select *
 from order_info;
 
 select product_desc
 from item;
 
 select a.product_name as 상품이름
      , sum(a.price * b.quantity) as 상품매출
 from item a , order_info b
 where a.item_id = b.item_id (+)
 group by a.product_name
 order by 2 desc;
 
-----------------------------------------------------------------------------
---------- 7번 문제 ---------------------------------------------------
-- 모든상품의 월별 매출액을 구하시오 
-- 매출월, SPECIAL_SET, PASTA, PIZZA, SEA_FOOD, STEAK, SALAD_BAR, SALAD, SANDWICH, WINE, JUICE
select *
from item;

select *
from order_info;

select substr(a.reserv_no,1,6) as 매출월
, sum(decode(a.item_id, 'M0001', a.sales,0)) as special_set
, sum(decode(a.item_id, 'M0002', a.sales,0)) as pasta
, sum(decode(a.item_id, 'M0003', a.sales,0)) as pizza
, sum(decode(a.item_id, 'M0004', a.sales,0)) as sea_food
, sum(decode(a.item_id, 'M0005', a.sales,0)) as steak
, sum(decode(a.item_id, 'M0006', a.sales,0)) as salad_bar
, sum(decode(a.item_id, 'M0007', a.sales,0)) as salad
, sum(decode(a.item_id, 'M0008', a.sales,0)) as sandwich
, sum(decode(a.item_id, 'M0009', a.sales,0)) as wine
, sum(decode(a.item_id, 'M0010', a.sales,0)) as juice
from order_info a, item b
where a.item_id = b.item_id
group by substr(a.reserv_no,1,6)
order by 1;

----------------------------------------------------------------------------
---------- 8번 문제 ---------------------------------------------------
-- 월별 온라인_전용 상품 매출액을 일요일부터 월요일까지 구분해 출력하시오 
-- 날짜, 상품명, 일요일, 월요일, 화요일, 수요일, 목요일, 금요일, 토요일의 매출을 구하시오 
select *
from item;

select *
from order_info;


select 날짜
, 상품명
, sum(decode(요일,'일요일',매출액,0)) as 일요일
, sum(decode(요일,'월요일',매출액,0)) as 월요일
, sum(decode(요일,'화요일',매출액,0)) as 화요일
, sum(decode(요일,'수요일',매출액,0)) as 수요일
, sum(decode(요일,'목요일',매출액,0)) as 목요일
, sum(decode(요일,'금요일',매출액,0)) as 금요일
, sum(decode(요일,'토요일',매출액,0)) as 토요일

from    (select substr(b.reserv_no,1,6) as 날짜
        , a.product_name as 상품명
        , to_char(to_date(substr(b.reserv_no,1,8)),'day') as 요일
        , b.sales as 매출액
        from item a, order_info b
        where a.item_id = b.item_id (+)
        and a.product_name = 'SPECIAL_SET')

group by 날짜, 상품명
order by 날짜;




----------------------------------------------------------------------------
---------- 9번 문제 ----------------------------------------------------
-- 고객수, 남자인원수, 여자인원수, 평균나이, 평균거래기간(월기준)을 구하시오 (생년월일 제외,성별 NULL 제외, MONTHS_BETWEEN, AVG, ROUND 사용(소수점 1자리 까지)
----------------------------------------------------------------------------
---------- 10번 문제 ----------------------------------------------------
--매출이력이 있는 고객의 주소, 우편번호, 해당지역 고객수를 출력하시오
----------------------------------------------------------------------------