/* WITH 절 별칭으로 사용한 select문을 다른 select문에서 참조가능함.
(반복되는 쿼리가 있다면 with절로 사용하면 변수처럼 사용 가능)
통계쿼리나 튜닝할때 많이 사용
temp라는 임시테이블을 사용하여 장시간 걸리는 쿼리결과를 임시로 저장하여 사용함.
oracle 9이상에서 지원함.
가독성이 좋음
*/

with t1 as(
    select 이름, 학생.학번, 평점, 전공, 과목번호
    from 학생, 수강내역
    where 학생.학번 = 수강내역.학번(+)
), t2 as(
    select avg(평점) as 전체평균평점
    from t1
), t3 as(
    select 전공
        , avg(평점) as 전공평점평균
    from t1
    group by 전공
)
select t1.이름
from t1, t2, t3
where t3.전공평점평균 > t2.전체평점평균;

(select 학생.이름
, 학생.학번
, 학생.평점
, 학생.전공
, 수강내역.수강내역번호
, 수강내역.과목번호
from 학생, 수강내역
where 학생.학번 = 수강내역.학번(+)
)t2 as(

select 학번, 이름, count(수강내역번호) as cnt
from t1
group by 학번, 이름
)

select *
from 과목, t1
where 과목.과목번호= t1.과목번호
;


/* 문제 (일반 쿼리로 작성하세요) 책 226page
    kor_loan_status 테이블에서 '연도별' '최종월(마지막월)'
    기준으로 가장 대출이 많은 도시와 잔액을 구하시오.
    1. 연도별 최종월 (2011년은 12월 이지만 2013은 11월임) 
        - 연도별 가장 큰 월을 구한다.
    2. 연도별 최종월을 기준으로 대출잔액이 가장 큰 금액을 추출
    3. 월별 지역별 대출잔액과 2의 결과를 비교하여 금액이 같은 건수 추출*/

select *
from kor_loan_status;

-- 년월별 지역별 총 대출합계
;

--최종월
select max(period) as 최종월
from kor_loan_status
group by substr(period,1,4);

--최종월의 대출 가장 큰 값
select period as 년월          -- 최종월
    , max(jan_amt) as max_jam -- 대출가장큰값
from (select period
    ,  region
    ,  sum(loan_jan_amt) as jan_amt
from kor_loan_status
group by period, region) b
, (select max(period) as max_month -- 최종월
from kor_loan_status
group by substr(period,1,4)) a
where b. period = a.max_month
group by period;

select  b2.*
from ( select period
            , region
            , sum(loan_jan_amt) as jan_amt
        from kor_loan_status
        group by period
                ,region
    ) b2
                , (select period as 년월          -- 최종월
                , max(jan_amt) as max_jam -- 대출가장큰값
            from (select period
                ,  region
                ,  sum(loan_jan_amt) as jan_amt
            from kor_loan_status
            group by period, region) b
            , (select max(period) as max_month -- 최종월
            from kor_loan_status
            group by substr(period,1,4)) a
            where b. period = a.max_month
            group by b.period) c
where b2.period = c.period
and b2.jan_amt = c.max_jam;