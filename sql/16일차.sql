/*
    이름이 있는 블록
    이름
    IS
     선언부
    BEGIN
     실행부
     EXCEPTION
    END;
*/
-- 국가번호를 입력 받아 국가명을 반환하는 함수
create or replace function fn_get_country(p_id number)
 return varchar2
is
 vs_country_name countries.country_name%type;
 vn_num number;
begin
 -- 해당 데이터가 있는지 없는지 체크
 if vn_num > 0 then
 -- 있을경우 조회
 select country_name
   into vs_country_name
 from countries
 where country_id = p_id;
 -- 없을경우 '해당국가 없음' 할당
 else
    vs_country_name := '해당국가 없음';
 end if;
 return vs_country_name; -- 리턴값
end;

-- 입력값에 해당되는 국가명이 없으면
-- '해당국가 없음' 을 리턴하는 함수로 수정하시오.


create or replace function fn_year
 return varchar2
is
begin
 return to_char(sysdate,'yyyy');
end;

select fn_year(), fn_year
from dual;

/* 학생이름을 입력받아 수강학점의 총합을 리턴하는* 함수를 작성하시오
   해당 이름의 학생이 없으면 0 or '없음'
   입력값 이름 : varchar2
   리턴값 학점 : varchar2
*/

create or replace function fn_get_score(p_name varchar2)
 return varchar2
is
 vn_score varchar2(30);
 vn_cnt number;
begin
 -- (1) 입력 받은 학생이 존재하는지 체크
select count(*)
into vn_cnt
from 학생
where 이름 = p_name;
if vn_cnt > 0 then
 select nvl(sum(과목.학점),0)
 into vn_score
 from 학생, 수강내역, 과목
 where 학생.이름 = p_name
 and 학생.학번 = 수강내역.학번(+)
 and 수강내역.과목번호 = 과목.과목번호;
else
 vn_score := '없음';
end if;
 -- (2) 학생이 있으면 수강학점합계 조회
 return vn_score;
end;

select 이름, fn_get_score(이름)
from 학생;


/* mem_id를 입력받아
   등급을 리턴하는 함수를 만드시오
   vip : 마일리지 5000이상 또는 구매 수량 100이상
   gold : 마일리지 5000미만 3000이상 또는 구매 수량 50이상
   silver : 나머지
   select fn_get_mem_grade('a001') <-- return vip
   from member;
   (1) 필요한 sql작성 (고객별 마일리지, 구매수량(qty))
   (2) (1) 조회 데이터로 조건문 작성
   if ~ vip
   elsif gold
   else silver
*/

create or replace function fn_get_mem_grade(p_id varchar2)
 return varchar2
is
 vn_mileage number;
 vn_qty number;
 vs_grade varchar2(30);
begin
    select sum(cart_qty), max(mem_mileage)
    into vn_qty, vn_mileage
    from member, cart
    where member.mem_id = p_id
    and member.mem_id = cart.cart_member(+);
-- vip : 마일리지 5000이상 또는 구매 수량 100이상
    if vn_mileage >= 5000 or vn_qty >= 100 then
    vs_grade := 'vip';
-- gold : 마일리지 5000미만 3000이상 또는 구매 수량 50이상
    elsif vn_mileage < 5000 and vn_mileage >= 3000 or vn_qty >= 50 then
    vs_grade := 'gold';
-- silver : 나머지
    else
    vs_grade := 'silver';
    end if;
 return vs_grade;
end;

select mem_id, mem_name, fn_get_mem_grade(mem_id)
from member;


/* yyyymmdd(문자)형태의 날짜를 입력받아
   dday를 계산하는 함수를 만드시오(네이버 dday 기준)
   지났다면 : 기준일 부터 1722일째 되는 날 입니다.
   오늘이라면 : 오늘은 기준일 부터 1일째 되는 날입니다.
   남았다면 : 오늘부터 기준일까지는 243일 남았습니다.
   (입력: 문자열, 리턴: 문자열*/
   


create or replace function fn_dday(p_date varchar2)
 return varchar2
is
    day varchar2(30);
    today varchar2(30);
    dday varchar2(30);
begin
    select fn_dday('20170815'), trunc(sysdate - to_date(20170815))
         , fn_dday('20220502'), trunc(sysdate - to_date(20220502))
         , fn_dday('20221231'), trunc(sysdate - to_date(20221231))
    into today, dday
    from dual;
end;