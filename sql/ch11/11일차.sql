-- 계층형 쿼리를 일반쿼리로 표현하려면 코드를 이렇게 짜야한다. 라는걸 보여줌


SELECT department_id, 
       department_name, 
       0 AS PARENT_ID,
       1 as levels,
        parent_id || department_id AS sort
FROM departments 
WHERE parent_id IS NULL
UNION ALL
SELECT t2.department_id, 
       LPAD(' ' , 3 * (2-1)) || t2.department_name AS department_name, 
       t2.parent_id,
       2 AS levels,
       t2.parent_id || t2.department_id AS sort
FROM departments t1,
     departments t2
WHERE t1.parent_id is null
  AND t2.parent_id = t1.department_id
UNION ALL
SELECT t3.department_id, 
       LPAD(' ' , 3 * (3-1)) || t3.department_name AS department_name, 
       t3.parent_id,
       3 as levels,
       t2.parent_id || t3.parent_id || t3.department_id as sort
FROM departments t1,
     departments t2,
     departments t3
WHERE t1.parent_id IS NULL
  AND t2.parent_id = t1.department_id
  AND t3.parent_id = t2.department_id
UNION ALL
SELECT t4.department_id, 
       LPAD(' ' , 3 * (4-1)) || t4.department_name as department_name, 
       t4.parent_id,
       4 as levels,
       t2.parent_id || t3.parent_id || t4.parent_id || t4.department_id AS sort
FROM departments t1,
     departments t2,
     departments t3,
     departments t4
WHERE t1.parent_id IS NULL
  AND t2.parent_id = t1.department_id
  AND t3.parent_id = t2.department_id
  and t4.parent_id = t3.department_id
ORDER BY sort;

select department_id
    , lpad(' ', 3 * (level - 1)) || department_name as 부서명
    , level
from departments
start with parent_id is null                -- 최상위(root) 조건
connect by prior department_id = parent_id; -- 계층구조 조건

-- employees 테이블의 계층형 구조
select employee_id
    , manager_id
    , level
    , lpad(' ', 3 *(level - 1)) || emp_name as 직원명
from employees
start with manager_id is null
connect by prior employee_id = manager_id;


-- 30번 부서직원의 관리자
select a.employee_id
    , lpad(' ', 3 * (level -1)) || a.emp_name
    , level
    , b.department_name
    , b.department_id
from employees a, departments b
where a. department_id = b.department_id
and a. department_id = 30 -- start with 전 검색조건(이 절을 맨 마지막에쓰면 레벨1이 같이 검색된다.)
start with a.manager_id is null
connect by prior a.employee_id = a.manager_id
order siblings by a.emp_name desc; -- 일반쿼리와 다른점은 정렬할때 siblings를 사용한다.

select department_id
    , lpad(' ', 3 * (level - 1)) || department_name as 부서명
    , level
from departments
start with parent_id is null                -- 최상위(root) 조건
connect by prior department_id = parent_id; -- 계층구조 조건

-- 부서아이디 : 230 , 부서명 : IT 헬프데스크
-- 팀의 하위 부서가 신설됐습니다.
-- 5 level에 해당하는 'IT 데이터 수집' 팀을 부서테이블에
-- INSERT 후 조회하시오

select level
    , lpad(' ', 3 * (level - 1)) || department_name as 부서명
    , department_id
from departments
start with parent_id is null
connect by prior department_id = parent_id;

insert into departments(department_id, department_name, parent_id)
values ('280','데이터수집','230');


-- 1. 테이블 생성 ex ( 테이블 명 : 팀), 최소한의 컬럼
-- 2. 데이터 삽입
-- 3. 계층형 쿼리 조회

create table team(
    아이디   number
   ,이름  varchar2(10)
   ,직책  varchar2(10)
   ,상위아이디 number);
    
insert into team values(1,'이사장', '사장',0);
insert into team values(2,'김부장', '부장',1);
insert into team values(3,'서차장', '차장',2);
insert into team values(4,'장과장', '과장',3);
insert into team values(5,'박과장', '과장',3);
insert into team values(6,'이대리', '대리',4);
insert into team values(7,'김대리', '대리',5);
insert into team values(8,'최사원', '사원',6);
insert into team values(9,'강사원', '사원',6);
insert into team values(10,'윤사원', '사원',7);

select *
from team;

select 이름
, lpad(' ',4 *(level-1)) || 직책 as 직책
, level
from team
start with 상위아이디 = 0        -- 이 조건에 맞는 로우부터
connect by prior 아이디 = 상위아이디;
-- connect by prior 자식 = 부모 top down -- 현재방식
-- connect by prior 부모 = 자식 buttom up

/*
 무한루프 상황일 경우에는 nocycle을 사용하여 멈추게하고
 connect_by_iscycle 함수를 사용하여 원인이 되는 행을 찾는다.

 무한루프 상황(서로가 서로를 바라보는 상황이 되면 무한루프에 빠진다)
 ex 30번이 40번을 바라보고, 40번이 30번을 바라보게 된다면.
 select 구절에 connect_by_iscycle을 써주면 문제가 되는 데이터에 1이 표기된다.
 connect by nocycle prior > nocycle을 추가해주고 윗구절을 써서 체크한다.
*/

commit;

-- 계층형 쿼리에서만 사용하는 함수
-- connect_by_root
-- connect_by_ieleaf
-- sys_connect_by_path(컬럼, '아무기호')

select department_id
    , parent_id
    , level
    , lpad(' ', 3 * (level - 1)) || department_name as 부서명
    , connect_by_root department_name as 최상위데이터
    , connect_by_isleaf as 하위있는지  -- 마지막이면 1, 자식이 있으면 0 리턴
    , sys_connect_by_path(department_name, '|') as 연결정보
from departments
start with parent_id is null                -- 최상위(root) 조건
connect by prior department_id = parent_id; -- 계층구조 조건


-- level은 오라클에서 실행되는 모든 쿼리 내에서 사용가능한
-- 가상의 열로 (connect by) 절과 함께 사용된다.
-- 트리 내에서 어떤 단계에 있는지를 나타내는 정수값.
-- 정수형 데이터가 필요할때 사용
select level
from dual
connect by level <= 12;

-- 2017년 1월 ~ 2017년 12월

select '2017'|| lpad(level,2,'0') as 년월 -- 레벨에 2자리를 0으로 채웠다
from dual
connect by level <= 12;

select period
    , sum(loan_jan_amt) as 합계
from kor_loan_status
where period like '2011%'
group by period;


-- 201101   0
-- 201102   0
-- ...
-- 201112   1031611.1
-- outer join으로 값이 없는 월에 0으로 채울 수 있다.
select a. 년월
    ,  nvl(b. 합계,0) as 합계
from (select '2011'|| lpad(level,2,'0') as 년월 -- 레벨에 2자리를 0으로 채웠다
from dual
connect by level <= 12) a
    ,(select period         as 년월
    , sum(loan_jan_amt)     as 합계
from kor_loan_status
where period like '2011%'
group by period) b
where a. 년월 = b. 년월 (+)
order by 1;


-- connect by level을 사용하여 (동적으로) 다음달이 되면
-- 쿼리 수정없이 31일까지 출력이 되도록

-- 이번달 20220401 ~ 이번달 마지막 날까지 데이터를 출력하시오
-- 20220401
-- 20220402
-- ...
-- 20220430

select  to_char(sysdate, 'yyyymm')|| lpad(level,2,'0') as 일자
from dual
connect by level <= to_char(last_day(sysdate),'dd');

-- reservation 테이블을 활용하여 (study계정)
-- 금천 지점의 요일별 예약수를 출력하시오
-- (1) 요일별 예약수 집계
-- (2) 1~7의 요일 데이터 생성
-- (3) 1,2 조인하여 출력

select *
from reservation;

select decode(a.day,'1','일요일','2','월요일','3','화요일',
            '4','수요일','5','목요일','6','금요일','7','토요일') as 요일
      ,nvl(b.cnt,0) as cnt
from    (select level as day
        from dual
        connect by level <= 7) a
,
        (select to_char(to_date(reserv_date),'d') as day
        , count(cancel) as cnt
        from reservation
        where branch = '금천'
        group by to_char(to_date(reserv_date),'d')) b
where a.day = b.day(+)
order by a.day;




