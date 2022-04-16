-- TO NUMBER 숫자데이터 타입으로

SELECT '12'* '300'
FROM dual;

CREATE TABLE ex5_1 (
    col1 varchar2(1000)  
);
INSERT INTO ex5_1 VALUES('123');
INSERT INTO ex5_1 VALUES('923');
INSERT INTO ex5_1 VALUES('1111');
INSERT INTO ex5_1 VALUES('999');

-- 데이터 타입을 확인하고 정렬해야한다.
SELECT *
FROM ex5_1
ORDER BY TO_NUMBER(col1) desc;


--CUSTOMERS 테이블에서
--CUST_YEAR_OF_BIRTH <- 을 활용하여
--80년 이후 출생자를 출력하시오
--이름, 출생년도, 나이(나이계산은 올해년도 - 출생년도, 성별 출력
--나이 오름차순으로 정렬, 나이가 같으면 이름 오름차순


SELECT*
from customers;

SELECT cust_name
, cust_year_of_birth
, to_char(sysdate,'yyyy')- cust_year_of_birth as 나이
, cust_gender
FROM customers
WHERE cust_year_of_birth >= 1980
ORDER BY 3 , 1;

/* 집계함수 대상 데이터에서 특정 그룹으로 묶어
그 그룹에 대해 총합, 평균, 최댓값, 최솟값 등을 구하는 함수
*/

-- COUNT <-- 로우의 건수집계
SELECT COUNT(*)                      -- null 포함
     , COUNT(ALL department_id)      -- dafalut는 ALL
     , COUNT(department_id)          -- all은 중복 포함
     , COUNT(distinct department_id) -- 중복제거
FROM employees; --group by절을 사용하지 않았기 때문에 전체 테이블에 관한



-- AVG : 평균
SELECT AVG(mem_mileage)
FROM member;

-- employees의 '평균 급여'와 '직원수'를 출력하시오
-- 소수점 2째자리까지 출력

SELECT ROUND(avg(salary),2) as 평균급여
     , COUNT(*) as 직원수
FROM employees;



SELECT ROUND(AVG(salary),2)
     ,MIN(salary)
     ,MAX(salary)
     ,SUM(salary)
FROM employees;

-- 50번 부서의 직원 수와 평균, 최소, 최대급여를 출력하시오
-- 집계함수에는 name 을 쓸수가 없다
SELECT COUNT(employee_id)   as 직원수
    ,  avg(salary)          as 평균급여
    ,  min(salary)          as 최소
    ,  max(salary)          as 최대
from employees
where department_id = 50
or department_id = 60;


-- 부서별 '직원수', '평균급여'
-- group by 절
select department_id
      ,count(employee_id)   as 부서별직원수
      ,round(avg(salary),2) as 부서평균급여
from employees
group by department_id -- 집계함수를 제외한 select 절에 들어간 컬럼은
                       -- group by 절에 들어가야함.
order by 1;

-- member 테이블 직업별 고객수를 출력하시오

select mem_job       as 직업
     , count(mem_id) as 고객수
from member
group by mem_job
order by 2 desc;


-- distinct 중복제거

SELECT distinct mem_job
from member;

-- 지역별로 대출 총합을 알고싶다.
-- 연도별, 지역별, 대출합계를 구하시오
-- 테이블의 데이터 형태를 본다 -- desc kor_loan_status
-- 

select substr(period,1,4) as 연도별
      ,region
      ,sum(loan_jan_amt) as 대출합계
from kor_loan_status
where substr(period,1,4) = '2013' 
group by substr(period,1,4), region
order by 2 desc;



-- 3명 이상 있는 직업만 출력하시오
-- 집계를 낸 후에 검색을 위해 where절 말고 having 절을 사용한다.
select mem_job
, count(mem_id) as 고객수
from member
group by mem_job
having count(mem_id) >=3
order by 2 desc;


--순서 from - where - group by - having - select - order by

-- 직원수가 30명 이상인 부서와 직원수를 출력하시오
select *
from employees;

select count(employee_id) as 직원수
     , department_id as 부서
from employees
group by department_id
having count(employee_id) >= 30;


-- 의사컬럼 ROWNUM : 테이블에 없는데 있는 것 처럼 사용
-- 임시로 번호가 생김
-- 테이블에 있는것처럼 사용가능
select rownum as rnum
     , a.*
from employees a;

select rownum as rnum
      ,a.* --테이블의 전체
from member a
where rownum = 1;  -- 특정할 수가 없어서 1만가능, 범위를 설정하면 가능

-- 고용 요일별 입사직원수를 조회하시오
-- hire_date
-- employees에 있는 직원

select*
from employees;

select count(employee_id) as 직원수
    ,to_char(hire_date,'day') as 요일
from employees
group by to_char(hire_date,'day')
order by 1 desc ;


select cust_gender
, cust_name
, case when cust_hender = 'M' then '남자'
       when cust_hender = 'F' then '여자'
else'?'
end as gender
,decode(cust_gender, 'M', '남자', 'F', '여자','?') as gender2
                  -- 조건1 결과1  조건2  결과2 그밖에
from customers;


-- 직원의 고용일자 컬럼을 활용하여
-- 연도별 요일별 입사인원수를 출력하시오
-- to_char, decode, group by, count, sum .. 사용
--(1) 고용일자 데이터로 연도컬럼 생성, 요일 컬럼 생성
--(2) 생성한 데이터로 집계


select *
from employees;

select to_char(hire_date,'yyyy') as 연도별
    , count(decode(to_char(hire_date,'day'),'일요일',2)) as 일요일
    , count(decode(to_char(hire_date,'day'),'월요일',2)) as 월요일
    , count(decode(to_char(hire_date,'day'),'화요일',2)) as 화요일
    , count(decode(to_char(hire_date,'day'),'수요일',2)) as 수요일
    , count(decode(to_char(hire_date,'day'),'목요일',2)) as 목요일
    , count(decode(to_char(hire_date,'day'),'금요일',2)) as 금요일
    , count(decode(to_char(hire_date,'day'),'토요일',2)) as 토요일
    , count(employee_id) as 직원수
from employees
group by to_char(hire_date,'yyyy')
order by 1;




