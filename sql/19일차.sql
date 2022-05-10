/* 정규식
1-1 : .(dot)은 모든 문자와 match
      [] <-- 문자 1글자를 의미
      ^: 시작을 의미함 $: 끝을 의미함
      [^] 부정을 위미함
*/

select mem_name, mem_hometel
from member
where regexp_like(mem_hometel, '^..-');

select mem_name, mem_hometel
from member
where regexp_like(mem_hometel, '^[0-9][0-9]-');

/* {m} : 정확히 m회 매치
   {m,} : 최소한 m회 매치
   {m,n} : 최소 m회 최대 n회 매치
   ? : 0 or 1회 매치
   + : 1 ~  1회 이상 매치
   * : 0번 이상 매치
*/
-------------------------------------------------------
-- 8이 3번 출현하는 전화번호
select mem_name, mem_hometel
from member
where regexp_like(mem_hometel, '[8]{3}');
-------------------------------------------------------
-- 이메일 주소 중 영문자 3번 출현 후 @ 있는 이메일 주소를 출력하시오
select mem_name, mem_mail
from member
where regexp_like(mem_mail, '^[a-z][a-z][a-z]\@');

select mem_name, mem_mail
from member
where regexp_like(mem_mail, '^[a-zA-z]{1,3}@');
-------------------------------------------------------
-- 숫자가 포함되지 않은 비밀번호를 검색하시오
select mem_name, mem_pass, mem_id
from member
where regexp_like(mem_pass, '^[^0-9]+$');
-------------------------------------------------------
-- 한글이 포함되지 않은 주소를 출력하시오
select mem_name, mem_add2
from member
where regexp_like(mem_add2, '^[^가-힣]+$');

select mem_name, mem_add2
from member
where not regexp_like(mem_add2, '[가-힣]');
-------------------------------------------------------
/* () <-- 패턴 그룹의미함
   |  <-- 또는
*/
select *
from member --그룹으로 묶을때 또는 ()|()
where regexp_like(mem_name, '김|이'); -- 김 or 이 

-- J로 시작하며, 세번째 문자가 m or n 인 이름을 가진 직원 조회
select emp_name
from employees
where regexp_like(emp_name, '^[J].[m|n]');

-------------------------------------------------------
--19일차 고객정보
select *
from(select rownum as no
    , count(*) over() as allcnt
    , a.*
from
    (select mem_id
        , mem_name
        , mem_mail
        , mem_mileage
    from member
    order by mem_name)a
    )
where rownum <= 10;