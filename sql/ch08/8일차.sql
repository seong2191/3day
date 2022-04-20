/* cutstomers 고객 정보를 출력하시오
이름, 성별, 나이, 도시, 국가(countries)

*/

select *
from customers;

select lower(column_name)
from all_tab_columns
where table_name = 'customers';


select a.cust_name
    , decode(a.cust_gender,'M','남자','F','여자') as 성별
    , to_char(sysdate,'yyyy') - a.cust_year_of_birth as 나이
    , a.cust_city as 도시
    , (select country_name
       from countries
       where country_id = a.country_id) as 국가
from customers a
order by 1,3;




select a.prod_id, a.sales_date, a.amount_sold
, (select cust_name
from customers
where cust_id = a.cust_id) as 구매고객
, (select emp_name
from employees
where employee_id = a.employee_id) as 판매직원
from sales a;


-- 직원과 고객의 실적내용이 많은 관계는?
-- 아래 쿼리를 조인으로 바꿔서 출력
select (select cust_name
        from customers
        where cust_id = a.cust_id) as 구매고객
      ,(select emp_name
        from employees
        where employee_id = a.employee_id) as 판매직원
      , count(*)  
from sales a
group by a.cust_id, a.employee_id
order by 2 desc;


-- 위 쿼리를 조인

select b.cust_name
     , c.emp_name
     , count(*)
from sales a
, customers b
, employees c
where a.cust_id = b.cust_id
and a.employee_id = c.employee_id
group by b.cust_id, b.cust_name, c.employee_id, c.emp_name
order by 3 desc;

select *
from employees;



-- 세미 조인 (exists <-- 존재하는)
-- 존재하지 않는 테이블 조회는 not exists
select department_id
     , department_name
from departments a
where exists (select *
              from employees b
              where a. department_id = b.department_id);

-- 수강이력이 없는 학생 조회
select *
from 학생 a
where not exists(select *
                 from 수강내역
                 where 학번 = a.학번);


-- 카타시안 조인(주의사항으로 알고있을 것)

-- 안시조인(ansi)은 기업에 따라 쓰고 안쓰고 차이가 명확

--일반 내부조인(inner)
select *
from 학생
    ,수강내역
    ,과목
where 학생.학번 = 수강내역.학번
and 수강내역.과목번호 = 과목.과목번호;

--ansi 내부조인 (조인관련 내용이 모두 from절에 위치함)
select *
from 학생
inner join 수강내역
on(학생.학번 = 수강내역.학번)
inner join 과목
on(수강내역.과목번호 = 과목.과목번호);

--일반 outer join 외부조인
select *
from 학생
    ,수강내역
    ,과목
where 학생.학번 = 수강내역.학번(+)
and 수강내역.과목번호 = 과목.과목번호(+);

-- ansi 외부조인
select *
from 학생
left join 수강내역 -- outer 숨김가능
on(학생.학번 = 수강내역.학번)
left outer join 과목
on(수강내역.과목번호 = 과목.과목번호);

select *
from 수강내역
right join 학생 -- outer 숨김가능
on(학생.학번 = 수강내역.학번)
right outer join 과목
on(수강내역.과목번호 = 과목.과목번호);

-- full oueer join
create table test_a (emp_id number);
create table test_b (emp_id number);
insert into test_a values(10);
insert into test_a values(20);
insert into test_a values(40);

insert into test_b values(10);
insert into test_b values(20);
insert into test_b values(30);

select a.emp_id
      ,b.emp_id
from test_a a, test_b b
where a.emp_id(+) = b.emp_id; -- 일반조인에서는 안됨

select a.emp_id
     , b.emp_id
from test_a a
full outer join test_b b
on(a.emp_id = b.emp_id);


-- 2000년도 판매(금액)왕을 출력하시오 (sales)
-- 직원명은 서브쿼리 사용(select)
-- (1) sales 테이블을 활용하여 직원별 판매금액(amount_sold), 수량을 집계
-- (2) 판매금액 기준으로 정렬하여 1건 출력(인라인뷰)
-- (3) 사번으로 employee테이블 이용하여 이름 가져오기
select (select emp_name from employees where employee_id = a.employee_id) as 직원
    , 판매수량
    , to_char(판매금액,'999,999,999.99') as 판매금액
from (  select employee_id
      , sum(quantity_sold) as 판매수량
      , sum(amount_sold) as 판매금액
        from sales
        where to_char(sales_date, 'yyyy') = '2000'
        group by employee_id
        order by 3 desc
        )a
where rownum = 1;

select *
from products;
prod_id
prod_name

select *
from sales;

-- 2000년도 최다판매상품(수량으로) 1~3등까지 출력하시오
select  rownum as rnum
      ,(select prod_name 
        from products
        where prod_id = a.prod_id) as 상품명
        , to_char(판매금액,'999,999,999.99') as 판매금액
        , 판매수량
from   (select prod_id
          , sum(quantity_sold) as 판매수량
          , sum(amount_sold) as 판매금액
        from sales
        where to_char(sales_date,'yyyy') = '2000'
        group by prod_id
        order by 2 desc 
        ) a -- 참조하라
        
where rownum <= 3;



