
-- DBMS_RANDOM.VALUE
-- 0 ~ 10 까지 난수 랜덤 생성
select dbms_random.value() * 10         as 난수1
     , dbms_random.value(0, 10)         as 난수2
     -- 0~ 10 자연수 랜덤생성
     , round(dbms_random.value()*10)    as 난수3
     , round(dbms_random.value(0, 10))  as 난수4
from dual;

create table ex12_1 as
select rownum as seq
    , to_char(sysdate,'yyyy') || lpad(ceil(rownum/1000),2,'0') as months
    , round(dbms_random.value(100,1000)) as amt
from dual
connect by level <= 12000;

select *
from ex12_1;

select *
from 학생
order by dbms_random.value; -- order by절에 쓰면 순서는 랜덤으로 출력

-- tb_info에서 dbms_random.value 활용하여
-- ssam을 제외하고 학생 1명만 뽑은 sql을 만드세요

select *
from tb_info;

select nm
from(select *
    from tb_info
    where pc_no not like '%SSAM%'
    order by dbms_random.value)
where rownum = 1;

/* 가장 매출이 높은 지점의 BEST TOP3 메뉴이름과 가격을 출력하시오
    (1) 가장 매출이 높은 지점명 1개 출력
    (2) 지점의 메뉴 매출순위 3개 출력
    (3) (1)의 지점명으로 (2)를 조회하여 출력
    study계정의 item, reservation, order_info 활용
*/

select *
from reservation;

select *
from order_info;

select *
from item;



select rownum as 순위
    , a.product_desc
    , a.price

from ()

where   (select branch
        from (select branch 
            , sum(sales) 
              from reservation a, order_info b
              where a.reserv_no = b.reserv_no
              group by branch
              order by 2 desc)
            where rownum = 1);
