select *
from 학생
where 학생.이름 = '윤지미';

select *
from 수강내역;

-- equal 조인을 실행하니까 나오지 않는다.
-- 그러므로 학번 값에 + 를 붙여줌
select *
from 학생
    ,수강내역
where 학생.학번 = 수강내역.학번(+)
and 학생.이름 = '윤지미';

/*
    외부조인(Outer Join)
    조인 조건에 만족하는 데이터가 어느 한쪽에 값이 NULL이어도
    모두 추출해야할때 사용 NULL이 포함되는 쪽에 (+) <- 사용
*/
select *
from 학생;

select 학생.학번
     , 학생.이름
     , count(수강내역.수강내역번호) as 수강건수
from  학생
    , 수강내역
where 학생.학번 = 수강내역.학번(+)
group by 학생.학번
       , 학생.이름;
       
select 수강내역.수강내역번호
from 수강내역;
       

select 학생.이름
, 수강내역.강의실
, 과목.과목이름
from 학생
, 수강내역
, 과목
where 학생.학번 = 수강내역.학번(+)
and 수강내역.과목번호 = 과목.과목번호(+);


-- 모든 교수의 강의이력을 출력하시오
-- 교수이름, 전공, 강의내역번호, 과목번호, 강의실


select 교수.교수이름
, 교수.전공
, 강의내역.강의내역번호 as 강의건수
, 강의내역.과목번호
, 강의내역.강의실
from 교수
, 강의내역
where 교수.교수번호 = 강의내역.교수번호(+);



select 교수.교수이름
, 교수.전공
, count(*) -- 널값도 포함하여 카운트
, count(강의내역.강의내역번호) as 강의건수
from 교수
, 강의내역
where 교수.교수번호 = 강의내역.교수번호(+)
group by 교수.교수이름
, 교수.전공
order by 3 desc;


-- 학생들의 '수강건수'와 '수강학점합계'를 출력하시오
--                      과목에 학점이 있음
-- 1. 각 테이블별 필요한 컬럼 조회
-- 2. 조인 후 필요한 컬럼 조회
-- 3. 집계함수 사용
-- 4. 건수 체크

select *
from 과목;

select *
from 학생;

select *
from 수강내역;

select 학생.이름
, count(수강내역.수강내역번호) as 수강건수
, NVL(sum(과목.학점),0) as 수강학점합계
from 학생
, 과목
, 수강내역
where 학생.학번 = 수강내역.학번(+)
and 수강내역.과목번호 = 과목.과목번호 (+)
group by 학생.이름
order by 2 desc;


/* 서브쿼리(sub querry)
 SQL문장 안에 보조로 사용되는 또 다른 SELECT문
 
 1. 메인 쿼리와 연관성에 따라
  (1) 연관성 없는 서브쿼리
  (2) 연관성 있는 서브쿼리
 2. 형태(위치)에 따라
  (1) 일반 서브쿼리(select 절) 스칼라 서브쿼리 라고도 함.
     -- 1:1로 연결되는 것에만
     -- 가벼운 테이블에만 사용 (무거운 테이블을 사용하면 성능의 저하)
  (2) 인라인뷰(from 절)
  (3) 중첩쿼리 (where절)
*/
select *
from departments;

select emp_name
     , department_name
from employees a
    ,departments b
where a.department_id = b.department_id;

-- (1) 일반 서브쿼리(select 절) 스칼라 서브쿼리 라고도 함.
select a.emp_name
    ,  a.department_id
    , (select department_name
    from departments
    where department_id = a.department_id) as nm
    ,  a.job_id
    , (select job_title
    from jobs
    where job_id = a.job_id) as job_nm
    from employees a;
    
-- 학생, 수강내역
select 학생.이름
    , (select 과목이름
       from 과목
       where 과목.과목번호 = 수강내역.과목번호) as 과목명
from 학생, 수강내역
where 학생.학번 = 수강내역.학번;



-- **(2) 인라인뷰(from 절)
-- select 출력 결과를 테이블처럼 사용
select rownum as rnum
, a.*
from 학생 a;

select *
from (select rownum as rnum
        , a.*
      from 학생 a) t1 -- 소괄호를 한 테이블로 본다.
                     -- 테이블 앞에는 as는 못쓴다. 컬럼에만
where t1.rnum between 1 and 10;

-- 평점이 높은 5명의 학생만 출력하시오
-- (1) 평점 높은 학생부터 출력되도록 정렬

select 이름
      ,평점
from 학생
order by 평점 desc;

-- (2) 정렬된 결과에 rownum 생성하여 인라인 뷰를 만듬

select rownum as rnum
    , a.*
from (select 이름
      ,평점
from 학생
order by 평점 desc) a;

-- (3) 2번 결과에서 2~5등까지만 나오도록 조건

select *
from (select rownum as rnum
        , a.*
      from (select 이름
                  ,평점
            from 학생
            order by 평점 desc) a
            )
where rnum between 2 and 5;


-- (3) 중첩쿼리 (where절)
-- 단순 값이 필요해서 사용
-- 전체 직원의 평균 월급 이상 받는 직원만 출력하시오

select *
from employees;

select avg(salary)
from employees;

select emp_name
     , salary
from employees
where salary >= (select avg(salary)
                 from employees);

-- 수강내역이 있는 학생만 조회하시오
select *
from 학생;

select distinct 학번
from 수강내역;

select *
from 학생
where 학번 in (select distinct 학번
              from 수강내역);

-- 수강내역이 없는 학생
-- not을 붙인다.

select *
from 학생
where 학번 not in (select distinct 학번
              from 수강내역);


-- 평균평점 이상인 학생만 조회하시오
-- 평균평점 구하기
-- (2) 검색조건에 (1)번 쿼리 사용
select *
from 학생;

select avg(평점)
from 학생;

select *
from 학생
where 평점 >= (select avg(평점)
                   from 학생);

-- member,cart
-- 고객의 cart 사용 이력의 최대, 최소 건수를 출력하시오
select *
from member;

select *
from cart;

       
select min(cnt) as 최소
     , max(cnt) as 최대
from(select a.mem_id
   , a.mem_name
   , count(b.cart_no) as cnt
     from member a, cart b
     where a.mem_id = b.cart_member
     group by a.mem_id , a.mem_name);


/* member, cart, prod
테이블을 사용하여
고객별 카트 사용횟수, 구매상품 품목 수, 
전체 상품 구매 수, 총 구매 금액을 출력하시오
(구매이력이 없으면 0건, 정렬조건 카트사용 내림)
(구매금액 prod_sale 구매수량 cart_qty
*/
-- outer 조인

select *
from member;
mem_name

select * 
from cart;
cart_no 카트사용횟수
cart_prod 구매상품 품목
cart_qty 구매수량

select *
from cart;
prod_sale

select *
from cart;

select mem_name
    ,  count(distinct(cart.cart_no)) as 카트사용횟수
    ,  count(distinct(cart.cart_prod)) as 구매상품품목수
    ,  NVL(sum(cart.cart_qty),0) as 전체상품구매수
    ,  NVL(sum(cart.cart_qty * prod.prod_sale),0) as 총구매금액
from member, cart, prod
where member.mem_id = cart.cart_member(+)
and cart.cart_prod = prod.prod_id(+)
group by mem_name
order by 2 desc;

