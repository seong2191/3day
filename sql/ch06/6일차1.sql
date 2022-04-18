-- 동등조인

select *
from member;

select *
from cart;


-- 김은대씨의 항목별 구매 갯수, 구매금
select member.mem_name-- 고객
     , member.mem_hp  -- 고객전화번호
     , cart.cart_prod -- 상품아이디
     , cart.cart_qty  -- 구매수량
     , prod.prod_name -- 상품명
     , prod.prod_sale -- 상품가격
from member
    ,cart
    ,prod
where member.mem_id = cart.cart_member
and cart.cart_prod = prod.prod_id
and member.mem_name = '김은대';


-- 김은대씨가 어떤상품에 얼만큼 금액을 썼는지
select a.mem_name-- 고객
     , c.prod_name
     , sum(b.cart_qty * c.prod_sale) as 총사용금액
from member a
    ,cart   b
    ,prod   c
-- 테이블에도 as를 써서 대입해서 사용할 수 있다.
where a.mem_id = b.cart_member
and b.cart_prod = c.prod_id
and a.mem_name = '김은대'
group by a.mem_id, a.mem_name, c.prod_id, c.prod_name
order by 3 desc;


-- 동등조인(equi-join) 두 테이블에 데이터가 동등하게 있는 row만 추출
-- 내부조인(inner join) 이라고도 함.
select a.emp_name
     , b.department_name
from employees a
   , departments b
where a.department_id = b.department_id;



-- 직원번호, 직원이름, 급여, 직업아이디, 직업명을 출력하시오
-- 급여가 15000이상인 직원만

select *
from employees;

select *
from jobs;

select a.employee_id
     , a.emp_name
     , a.salary
     , a.job_id -- 각 테이블에 동일한 항목이 있어서 하나를 결정했다.
     , b.job_title
from employees a
   , jobs b
where a.job_id = b.job_id
and salary >= 15000;














