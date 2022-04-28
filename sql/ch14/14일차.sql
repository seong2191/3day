/* 분석함수 (over)

분석함수(매개변수) over (partition by expr1, expr2...
                       order by expr3, expr4...
                        window 절...
                        )
    partition by : 계산 대상 그룹지정(group by)
    order by : 대상 그룹에 대한 정렬
    window : 파티션으로 분할된 그룹에 대해 더 상세한 그룹을 분할*/

select department_id, emp_name
    ,  row_number() over (partition by department_id
                          order by emp_name) as dep_row
    , round(avg(salary) over(partition by department_id)) as dep_avg
    , round(avg(salary) over()) as all_avg --over뒤에 값이 없더라도 over는 무조건 붙여야한다.
from employees;

-- 모든 학생 이름, 전공, 전공별 평점평균, 전체 평균평점을 출력

select 이름, 전공
, round(avg(평점) over(partition by 전공),2)  as 전공평균평점
, round(avg(평점) over(),2)                  as 전체평균평점
from 학생;

-- rank() 동일값 순위 건너뜀
-- dense_rank() 건너뛰지 않음
select department_id
    , emp_name
    , rank() over(partition by department_id
                  order by salary desc) as rank_dep
    , dense_rank() over(partition by department_id
                  order by salary desc) as dense_rank_dep
    , dense_rank() over(order by salary desc) as all_dense_rank_dep                  
from employees
where department_id in(30,60);


-- 부서별로 월급을 가장 많이 받는 직원 1명씩 출력하시오
-- (부서없는 직원은 제외)
select *
from employees;

select *
from (select emp_name
    , department_id 
    , salary                    
    , rank() over(partition by department_id
                    order by salary desc) as rank_dep
from employees
where department_id is not null)
where rank_dep = 1;


-- 부서별 월급 비용이 많이 드는 순위를 출력하시오
-- (가장 많은 부서가 1등)
select a.*
    , rank() over(order by dep_sum desc)  as rank
from    (select department_id
        , sum(salary) as dep_sum
        from employees
        where department_id is not null
        group by department_id) a;
        
select department_id
    , sum(salary) as dep_sum
    , rank() over(order by sum(salary) desc) as dep_rank
from employees
group by department_id;

--cart, prod 활용하여 물품별 판매합계금액의 순위를 출력하시오

select *
from cart;
cart prod
prod id
select *
from prod;
prod_sale

select b.prod_id
    , b.prod_name
    , sum(a.cart_qty * b.prod_sale) as 상품판매합계
    , dense_rank() over(order by sum(a.cart_qty * b.prod_sale) desc) as prod_rank
from cart a, prod b
where a.cart_prod = b.prod_id
group by b.prod_id, b.prod_name;

/* lag 선행로우 값 반환
   lead 후행로우 값 반환
*/

select emp_name
    , department_id
    , salary
                -- 1단계 앞 로우의 emp_name
    , lag(emp_name, 1, '가장높음') over(partition by department_id
                                    order by salary desc) as ap_emp
        --이거랑         이게 타입이 맞아야함         
                -- 1단계 뒤 로우의 emp_name                                        
    , lead(emp_name, 1, '가장낮음') over(partition by department_id
                                        order by salary desc) as back_emp
from employees
where department_id in (30,60);

-- 각 학생들의 평점이 1단계 높은 학생의 이름과의 평점 차이를 출력하시오
-- 가장 높은 학생은 이름: '1등' 차이:0

select 이름
    , round(평점,2) as 평점
    , lag(이름, 1, '1등') over(order by 평점 desc) as 높은친구이름
    , round(lag(평점,1, 평점) over(order by 평점 desc)- 평점,2) as 평점차이
from 학생;

select *
from 학생;