SELECT
*FROM TB_INFO

WHERE nm = '김성윤';

UPDATE TB_INFO
SET hobby = '노래'
WHERE nm = '김성윤';

commit;

SELECT * FROM TB_INFO;


/* 연산자 */

-- 수식 연산자 + - * / 
SELECT employee_id
 ,     emp_name
 ,     ROUND(salary /30, 2)   as 일당
 ,     salary                 as 월급
 ,     salary - salary * 0.1  as 실수령액
 ,     salary * 12            as 연봉
 ,     emp_name ||':'|| email as 이메일  -- 문자연산자 || <--
 
 FROM employees;
 
 
 -- 논리 연산자 
 SELECT * FROM employees WHERE salary = 2600 ; -- 같다
 SELECT * FROM employees WHERE salary <> 2600 ; -- 같지않다
 SELECT * FROM employees WHERE salary != 2600 ; -- 같지않다
 SELECT * FROM employees WHERE salary < 2600 ; -- 미만
 SELECT * FROM employees WHERE salary > 2600 ; -- 초과
 SELECT * FROM employees WHERE salary <= 2600 ; -- 이하
 SELECT * FROM employees WHERE salary >= 2600 ; -- 이상
 
 -- products 테이블에서 상품 최저 금액(min_price)가 50원 '미만'
 -- 제품명을 출력하시오, 그리고 min_price를 내림차순으로 조회하시오
 -- 카테고리에 소프트웨어/그외'를 추가
 
 SELECT  prod_name
       , prod_min_price
 FROM products
 WHERE prod_min_price < 50
 AND   prod_min_price >=30
 AND prod_category = 'Software/Other'
 ORDER BY prod_min_price desc; -- 디폴트는 오름차순
 -- AND(그리고) [A,B 조건 모두 만족할때]
 -- OR(또는) [A 또는 B조건에 해당하면]
 
 
 -- 50 or 60번 부서 직원을 조회하시오
 SELECT  emp_name
   ,  department_id
 FROM employees
WHERE department_id = 50
OR    department_id = 60;


-- TB_INFO에서 취미가 요리 도는 영화감상인 학생을 조회하시오.
SELECT *
FROM TB_INFO
WHERE hobby = '요리'
OR    hobby = '영화감상';

/* 표현식 CASE */
SELECT cust_gender, cust_name
    , CASE WHEN CUST_GENDER = 'M' THEN '남자'
           WHEN CUST_GENDER = 'F' THEN '여자'
    ELSE '?'
    END as 성별
    -- CASE로 열고 END로 닫는다.
    -- 조건 외의 값은 null로 표시되기 때문에 데이터의 빠지는 값이 있으면 WHEN추가
FROM customers;

SELECT *
FROM customers;


SELECT employee_id, salary
       ,CASE WHEN salary <= 5000 THEN 'C등급'
            WHEN salary >  5000 AND salary <=15000 THEN 'B등급'
            ELSE 'A등급'
            END as grade
        FROM employees
        ORDER BY 2 desc; -- ORDER BY 뒤에 오는 숫자는 컬럼의 번호이다 (이 구문에서는 1. 아이디 2. 샐러리 3. grade)
        
/*LIKE 조건식*/

SELECT emp_name
FROM employees
WHERE emp_name LIKE 'A%'; --첫 글자가 A로 시작하는


CREATE TABLE ex3_5(
      nm varchar2(100)
);

INSERT INTO ex3_5 VALUES('홍길');
INSERT INTO ex3_5 VALUES('홍길동');
INSERT INTO ex3_5 VALUES('홍길상');
INSERT INTO ex3_5 VALUES('길상');
INSERT INTO ex3_5 VALUES('길상홍길');
 
SELECT *
FROM ex3_5
-- WHERE nm like '홍%'; -- 홍으로 시작하는
-- WHERE nm like '%길'; -- 길로 끝나는
-- WHERE nm like '%홍%'; -- 어디든 홍이 포함되는
-- WHERE nm like '홍'; -- 완벽히 포함되는
-- 길이까지 맞아야 할대는 % 대신 _(언더바) 사용

-- WHERE nm like '홍_'; -- 홍으로 시작하고 두글자인
-- WHERE nm like '홍__'; -- 홍으로 시작하고 세글자인
WHERE nm like '_길_'; -- 중간이 길이고 양쪽으로 한글짜씩인



-- 이씨 또는 김씨를 검색하시오

SELECT *
FROM TB_INFO

WHERE nm like '이%'
      or nm like '김%';
      
      
-- 이씨가 아닌 학생을 조회하시오

SELECT *
FROM TB_INFO

WHERE nm NOT like '이%';


-- 메일 주소가 gmail이 아닌 학생을 출력하시오

SELECT*
FROM TB_INFO

WHERE email not like'%gmail%';