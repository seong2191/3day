/* WITH 절 별칭으로 사용한 SELECT문을 다른 SELECT문에서 
   참조가능함. (반복되는 쿼리가 있다면 WITH절로 사용하면 
               변수처럼 사용가능 )
    통계쿼리나 튜닝할때 많이 사용 
    temp라는 임시 테이블을 사용하여 장시간 걸리는 쿼리 결과를
    임시로 저장하여 사용함. 
    oralce 9이상에서 지원함. 
    가독성이 좋음 
*/
WITH T1 AS ( 
  SELECT 이름, 학생.학번, 평점, 전공, 과목번호, 수강내역번호  
  FROM 학생, 수강내역 
  WHERE 학생.학번 = 수강내역.학번(+) 
)
, T2 AS(
   SELECT AVG(평점) as 전체평점평균
   FROM T1 
)
, T3 AS (
  SELECT 전공 
      , AVG(평점) as 전공평점평균 
  FROM T1 
  GROUP BY 전공 
)
, T4 AS (
   SELECT 이름, 학번, COUNT(수강내역번호) as cnt 
   FROM T1
   GROUP BY 이름, 학번
)
SELECT T1.이름 
FROM T1, T4
WHERE  T3.전공평점평균 > T2.전체평점평균
;



SELECT a.branch
     , b.item_id 
     , b.sales 
FROM reservation a
   , order_info b
WHERE a.reserv_no = b.reserv_no;

                                                    
                                                    
                                                    
-- WITH절을 활용하여 수강건수 출력
WITH T1 AS ( 
  SELECT 학생.이름
       , 학생.학번
       , 학생.평점
       , 학생.전공
       , 수강내역.수강내역번호  
       , 수강내역.과목번호
  FROM 학생, 수강내역 
  WHERE 학생.학번 = 수강내역.학번(+) 
)
, T2  AS (
    SELECT 학번, 이름, COUNT(수강내역번호) as cnt
    FROM T1
    GROUP BY 학번, 이름
)
, T3 AS(
  SELECT T1.학번, T1.이름, 과목.과목이름 
  FROM 과목, T1
  WHERE 과목.과목번호 = T1.과목번호 
) 
SELECT * 
FROM T2, T3
WHERE T2.학번 = T3.학번 
;
/* 문제 (일반 쿼리로 작성하세요)
   kor_loan_status 테이블에서 '연도별' '최종월(마지막월)'
   기준으로 가장 대출이 많은 도시와 잔액을 구하시오. 
   
   1.연도별 최종월 (2011년은 12월 이지만 2013은 11월임 )
     - 연도
     별 가장 큰월을 구한다. 
   2.연도별 최종월을 기준으로 대출잔액이 가장 큰 금액을 추출 
   3.월별 지역별 대출잔액과 2의 결과를 비교하여 금액이 같은건 추출 
*/

-- 년월별 지역별 대출합계 
SELECT period
     , region
     , sum(loan_jan_amt) as jan_amt
FROM kor_loan_status
GROUP BY  period
        , region;
-- 최종월 
SELECT MAX(period) as max_month
FROM kor_loan_status
GROUP BY substr(period,1,4);
-- 최종월의 대출가장큰값 
SELECT  period                     -- 최종월 
     ,  MAX(jan_amt) as max_jam    -- 대출가장큰값  
FROM (SELECT period
           , region
           , sum(loan_jan_amt) as jan_amt
      FROM kor_loan_status
      GROUP BY  period, region ) b
    ,(SELECT MAX(period) as max_month -- 최종월 
       FROM kor_loan_status
      GROUP BY substr(period,1,4)) a 
WHERE b.period = a.max_month 
GROUP BY period;
--201311	334062.7
--201212	331572.3
--201112	334728.3

SELECT b2.*
FROM (SELECT period
             , region
             , sum(loan_jan_amt) as jan_amt
        FROM kor_loan_status
        GROUP BY  period, region
     ) b2 
     ,(SELECT  period                     -- 최종월 
             ,  MAX(jan_amt) as max_jam    -- 대출가장큰값  
        FROM (SELECT period
                   , region
                   , sum(loan_jan_amt) as jan_amt
              FROM kor_loan_status
              GROUP BY  period, region ) b
            ,(SELECT MAX(period) as max_month -- 최종월 
               FROM kor_loan_status
              GROUP BY substr(period,1,4)) a 
        WHERE b.period = a.max_month 
        GROUP BY period) c 
WHERE b2.period = c.period
AND   b2.jan_amt =c.max_jam;

WITH b2 AS (
  SELECT period, region, sum(loan_jan_amt) as jan_amt
  FROM kor_loan_status GROUP BY  period, region
), c AS (
   SELECT b2.period, max(b2.jan_amt)as max_amt
   FROM b2, (SELECT MAX(period) as max_month -- 최종월 
               FROM kor_loan_status
              GROUP BY substr(period,1,4)) a
   WHERE  b2.period = a.max_month
   GROUP BY b2.period
)SELECT b2.*
FROM b2, c WHERE b2.period = c.period
AND   b2.jan_amt = c.max_amt;





-- 최종월        
SELECT MAX(period) max_month
FROM kor_loan_status
GROUP BY substr(period,1,4);


-- 최종월의 지역의 대출가장 큰값 
SELECT period
    , max(jan_amt) as max_amt
FROM (SELECT period
             , region
             , sum(loan_jan_amt) jan_amt
        FROM kor_loan_status 
        WHERE period = 201311
        GROUP BY period, region
       )
GROUP BY period;

-- 최종월의 가장큰 대출금액을 가진 지역조회 
SELECT *
FROM(   SELECT period
             , region
             , sum(loan_jan_amt) jan_amt
        FROM kor_loan_status 
        WHERE period = 201311
        GROUP BY period, region
    )
WHERE period = 201311
AND jan_amt =334062.7;