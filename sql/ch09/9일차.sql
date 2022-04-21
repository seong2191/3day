select a.employee_id, a.emp_name
    ,  a.department_id, b.department_name
from employees a
    ,departments b
where a.department_id = b.department_id;

create or replace view emp_dept as
select a.employee_id, a.emp_name
    ,  a.department_id, b.department_name
from employees a
    ,departments b
where a.department_id = b.department_id;

-- 뷰 생성 권한 필요 (system계정에서 권한부여)
GRANT CREATE VIEW TO java;
-- emp_dept 조회할 수 있는 권한 부여
grant select on emp_dept to study;


select *
from emp_dept;

-- 계정생성(system에서 실행)
create user study identified by study;
-- 접속 권한 부여(system에서 실행)
grant connect to study;


-- (1) sys계정에서 study 계정생성 및 접속권한부여
-- (2) java(myts) 계정에서 만든 view 객체를 조회할 수 있는 권한을
--     study계정에게 부여
-- emp_dept 조회할 수 있는 권한 부여
grant select on emp_dept to study;
-- (3) study 계정에서 emp_dept 조회가능
select * from java.emp_dept;

create or replace view tb_hak as
select 학생 as hak_no
     , 이름 as han_nm
from 학생;

grant select on tb_hak to study;
grant insert on tb_hak to study;

/* view 뷰는 실제 데이터는 테이블에 있지만 마치 테이블처럼 사용
   (1)자주 사용하는 sql을 뷰로 만들어 편리하게 이용가능
   (2)데이터 보안 측면에서 중요한 컬럼은 감출 수 있다.
   단순 뷰
    - 테이블 하나로 생성하여 insert/update/delete 가능
    - 그룹함수 불가능
   복합 뷰
    - 여러개 테이블로 생성 insert/update/delete 불가능
    - 그룹함수 가능
   
    connect, resource, dba (롤)
    롤: 다수 사용자와 다양한 권한을 효과적으로 관리하기 위해 권한을 그룹화 한 개념
    connect : 사용자가 데이터베이스 접속할 수 있는 권한을 그룹화한 롤
    resource: 테이블, 시퀀스, 트리거와 같은 객체 생성 권한을 그룹화한 롤
    dba : 모든권한 

*/
-- 계정 롤 권한 조회
select *
from dba_role_privs
where grantee = 'java';
-- 
select *
from dba_sys_privs
where grantee = 'java';

select *
from dba_sys_privs
where grantee = 'resource';


/* 시노님 Synonym '동의어'란 뜻으로 객체 각자의 고유한 이름에 대한
동의어를 만드는 것
PUBLIC 모든 사용자 접근가능
PRIVATE 특정 사용자만 사용 (디폴트)
*/
-- 시노님 생성 권한 부여
grant create synonym to java;
-- channels 테이블 시노님 syn_channel로 부여
create or replace synonym syn_channel
for channels;


grant select on syn_channel to study;
-- public 시노님 부여 및 삭제는 DBA권한이 있어야함.

create or replace public synonym hak
for java.학생;
grant select on hak to study;

drop synonym hak;
drop view emp_dept;

select *
from user_constraints
where table_name = '학생';


select *
from user_constraints
where constraint_name like '%pk%';

--comment
comment on table TB_INFO is '4월반';
comment on column tb_info.pc_no is '컴퓨터번호';
comment on column tb_info.info_no is '기본번호';
comment on column tb_info.nm is '이름';
comment on column tb_info.email is '메일';
comment on column tb_info.hobby is '취미';

/* 시퀀스 객체 SEQUENCE
   자동순번을 반환하는 객체로 (CURRVAL, NEXTVAL) 사용
*/
create sequence my_seq
increment by 1      -- 증강숫자
start with   1      -- 시작숫자
minvalue     1      -- 최소값
maxvalue     999999 -- 최대값
nocycle             -- 디폴트 nocycle 최대, 최소 도달 후 중지
nocache;            -- 디폴트 nocache 메모리에 값 미리 할당 여부

select my_seq.nextval -- 값 증가
    ,  my_seq.currval -- 현재값
from dual;

select my_seq.nextval
from dual;

select my_seq.currval -- 처음부터 currval을 하면 오류가 난다
from dual;

create table ex9_1(
    seq number
    ,dt timestamp default systimestamp
);

insert into ex9_1(seq) values(my_seq.nextval);

select *
from ex9_1;



-- ex9_2 테이블에 seq값이 0000000001~0000010000
-- 위와 같은 형태로 저장되도록 insert문을 작성하시오

create table ex9_2(
    seq varchar2(10)
    ,dt timestamp default systimestamp
);

select lpad(my_seq.nextval,10,'0')
from dual;


insert into ex9_2(seq) values(lpad(my_seq.nextval,10,'0'));


select *
from ex9_2;

select nvl(max(seq),0) + 1
from ex9_1;

insert into ex9_1(seq)
values((select nvl(max(seq),0) + 1
from ex9_1));

select *
from ex9_1;

commit;



/* MERGE 문
과목 테이블에 머신러닝 과목이 있으면 학점을 6으로 업데이트
                             없으면 번호를 생성하여 insert
                            (과목이름: 머신러닝, 학점:3)
*/
select nvl(max(과목번호),0) +1
from 과목;

merge into 과목 a      -- 대상테이블
using dual            -- 비교테이블
on (과목이름='머신러닝') -- 비교내용
when matched then     -- 비교내용이 true
update set a.학점 = 6
when not matched then -- 비교내용이 false
insert (a.과목번호, a.과목이름, a.학점)
values ((select nvl(max(과목번호),0) +1
from 과목),'머신러닝',3);

select *
from 과목;


-- 이탈리아의 2000년 연평균 매출보다 월평균 매출이 높은 월과
-- 평균 월평균 매출액을 출력하시오
-- sales_month, amount_sold, country_id, country_name, cust_id
select *
from sales;
sales_month
select sum(amount_sold)

select *
from customers;
cust_id
country_id

select *
from countries;
country_id
country_name

select  country_id
    , country_name
    , sales_date
from countries, sales;




select a.sales_month
     , a.amount_sold
     , c.country_name
from sales a, customers b, countries c
where a.cust_id = b.cust_id (+)
and b.country_id = c.country_id (+)
and a.sales_month like '2000%'
and c.country_name = 'Italy';
group by a.sales_month

(select avg(amount_sold)
from sales a, customers b, countries c
where a.cust_id = b.cust_id (+)
and b.country_id = c.country_id (+)
and a.sales_month like '2000%'
and c.country_name = 'Italy');

select *
from sales a, customers b, countries c
where a.cust_id = b.cust_id (+)
and b.country_id = c.country_id (+)
and a.sales_month like '2000%'
and c.country_name = 'Italy';




select a.*

from (select a.sales_month,
    avg(a.amount_sold) as 월
    from sales a, customers b, countries c
    where a.cust_id = b.cust_id (+)
    and b.country_id = c.country_id (+)
    and a.sales_month like '2000%'
    and c.country_name = 'Italy'
    group by a.sales_month)a

    (select round(avg(amount_sold))
    from sales a, customers b, countries c
    where a.cust_id = b.cust_id (+)
    and b.country_id = c.country_id (+)
    and a.sales_month like '2000%'
    and c.country_name = 'Italy')b

where a > b ;