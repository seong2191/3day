-- 1.

CREATE TABLESPACE TS_STUDY
datafile '/u01/app/oracle/oradata/XE/ts_study.dbf'
size 100M autoextend on next 5M;

-- 2.

CREATE USER java2 IDENTIFIED BY oracle
DEFAULT TABLESPACE TS_STUDY
TEMPORARY TABLESPACE temp;  


-- 3.
GRANT connect, resource TO java2;


-- 4.
create table ex_mem(
    mem_id varchar2(10) 
    ,mem_name varchar2(20) not null
    ,mem_job varchar2(30)
    ,mem_mileage number(8,2)
    ,mem_reg_date date
    ,constraint pk_ex_mem primary key(mem_id)
);

-- 5.
ALTER TABLE ex_mem MODIFY(mem_name VARCHAR2(50));

-- 6.
create sequence seq_code
start with 1000 increment by 1
maxvalue 9999
cycle;

-- 7.
insert into ex_mem (mem_id, mem_name, mem_job, mem_reg_date) values ('hong', '홍길동','주부',sysdate);

select *
from ex_mem;

-- 8.
insert into ex_mem(mem_id, mem_name, mem_job, mem_mileage)
select mem_id
    , mem_name
    , mem_job
    , mem_mileage
from member
where mem_like in('독서','등산','바둑');


-- 9.
delete 
from ex_mem
where mem_name = '김%';

select*
from ex_mem;

-- 10.
select mem_id
    , mem_name
    , mem_job
    , mem_mileage
from member
where mem_job = '주부'
and mem_mileage between 1000 and 3000
order by 4 desc;

-- 11.

select prod_id
    , prod_name
    , prod_sale
from prod
where prod_sale = '23000'
or prod_sale = '26000'
or prod_sale = '33000';

-- 12.
select *
from
(select mem_job as 직업
    , count(mem_job) as mem_cnt
    , to_char(max(mem_mileage),'999,999') as max_mlg
    , to_char(avg(mem_mileage),'999,999') as avg_mlg
from member
group by mem_job)
where mem_cnt >= 3;

-- 13.
select *
from cart;

select *
from member;

select *
from 
(select member.mem_id
    , member.mem_name
    , member.mem_job
    , cart.cart_prod
    , cart.cart_qty
    , substr(cart.cart_no,1,8) as 일자
from cart, member
where cart.cart_member = member.mem_id (+)) a
where 일자 = '20050728';

-- 14.
--ansi 내부조인 (조인관련 내용이 모두 from절에 위치함)

select member.mem_id
    , member.mem_name
    , member.mem_job
    , cart.cart_prod
    , cart.cart_qty
    , substr(cart.cart_no,1,8) as 일자
from cart
left join member
on (cart.cart_member =member.mem_id)
where substr(cart.cart_no,1,8) = '20050728';

-- 15.
select mem_id
    , mem_name
    , mem_job
    , mem_mileage
    , rank() over(partition by mem_job
                    order by mem_mileage desc) as mem_rank
from member;

commit;
