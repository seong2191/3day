set serveroutput on;

-- 기본 단위를 블록이라고 하며
-- 블록은 : 이름부, 선언부, 실행부, 예외처리부로 구성
-- 이름부는 블록의 명칭이 오는데 없을 경우 익명블록 (declare)
declare
 vi_num number := 10;
 vn_pi constant number    := 3.14;
begin
 vi_num := 100;
-- vn_pi := 4; -- 오류 상수는 값 변경 불가
 dbms_output.put_line('값:'|| vi_num);
end;



declare
    vs_emp_name employees.emp_name%type;
    vs_dep_name departments.department_name%type; -- 테이블컬럼의 타입과 사이즈
begin
    select a.emp_name, b.department_name
    into vs_emp_name, vs_dep_name -- into 조회 결과 변수에 저장
    from employees a
        ,departments b
    where a.department_id = b.department_id
    and a.employee_id = 100;
    dbms_output.put_line(vs_emp_name || ':' || vs_dep_name);
end;



-- 이름을 입력 받아 학번을 출력하는 익명블록 작성

declare
    vs_nm 학생.이름%type := :nm;
    vn_hakno 학생.학번%type;
begin
    /*입력받은 이름으로 학생테이블에서 학번 조회 sql*/
    select 학번
    into vn_hakno
    from 학생
    where 학생.이름 = vs_nm;
    
    dbms_output.put_line(vs_nm || ':' || vn_hakno);
end;


begin -- 선언부가 필요 없으면 begin, end만 있어도 가능
    dbms_output.put_line(2 * 2);
end;

/* if 문*/

declare
    vn_num number := 10;
    vn_user_num number := :sum;
begin
    if vn_user_num > vn_num then
        dbms_output.put_line('10보다 작음');
    elsif vn_user_num = vn_num then
        dbms_output.put_line('10임');
    else 
        dbms_output.put_line('10보다 큼');
        if vn_user_num = 100 then
            dbms_output.put_line('헐');
    end if;
end;


/* 신입생이 들어왔습니다 나가세요 라고할라다가
    학번을 생성하여 등록해주세요
    가장 마지막 학번 앞자리(4)년도가 올해와 같다면 '마지막학번+1'
                                    같지않다면 올해 + 000001번으로 생성*/
                                    

declare
    vn_year varchar2(4) := to_char(sysdate,'yyyy');
    vn_max_no 학생.학번%type;
    vn_make_no 학생.학번%type;
begin
    --(1) 마지막 학번 조회
    select max(학번)
    into vn_max_no
    from 학번;
    --(2) 번호 앞자리와 올해를 비교하여 학번 생성
    if substr(vn_max_no,1,4) = vn_year then
        vn_make_no := vn_max_no +1;
    else
        vn_make_no := (vn_year || '000001');
    end if;
    insert into 학생(학번, 이름, 전공, 생년월일)
    values('위에서 생성한 번호', :이름, :전공, to_date(:생년월일));
    commit;
end;

-- 단순 loop문
declare
    vn_base number := 3;
    vn_cnt number := 1;
begin
 loop
  dbms_output.put_line(vn_base ||'*'||vn_cnt||'='||vn_base*vn_cnt);
  vn_cnt := vn_cnt +1;
  exit when vn_cnt > 9; --루프종료
 end loop;
end;
-----------------------------------
--2단부터 9단까지 출력 
declare
    i number := 2;
    j number;
begin
 loop
  DBMS_OUTPUT.PUT_LINE (i ||'단 ========');
  j := 1;
  loop
  dbms_output.put_line(i ||'*'||j||'='||i*j);
    j:= j+1;
    exit when j > 9; -- j루프종료
    end loop;
  i := i+1;
  exit when i > 9; -- i 루프종료
 end loop;
end;

-----------------------------------
declare
    vn_base number := 3;
    vn_cnt number := 1;
begin
 while vn_cnt <= 9
 loop
  dbms_output.put_line(vn_base ||'*'||vn_cnt||'='||vn_base*vn_cnt);
--   exit when 5 = vn_cnt; -- 이건 5까지 나옴. 단순루프에서는 필수 while, for 에서는 있어도 없어도 상관x
  vn_cnt := vn_cnt +1;
 end loop;
end;

-- for문
declare
 i number := 3;
begin
 for j in reverse 1..9 -- 초기값..종료(최대값) -- in reverse는 반대로찍힘
               -- 초기값에서 1씩 증가하여 j에 할당
 loop
  dbms_output.put_line(i || '*' || j || '=' ||i*j);
 end loop;
end;

--2단부터 9단까지 출력 (변수 선언 없이)
DECLARE
 
BEGIN
  FOR i IN 2..9
  LOOP
    DBMS_OUTPUT.PUT_LINE( i || '단===========');
    FOR j IN 1..9
    LOOP 
        DBMS_OUTPUT.PUT_LINE(i || ' * ' || j || ' = ' || (i * j));
        END LOOP;
  END LOOP;
END;


-- 숫자를 입력받아
-- 입력받은 수 만큼 *을 프린트 하는 익명블록을 작성하시오
-- ex) 5
--     *****
-- ex) 10
--     **********
declare
   
begin
	for i in 1..&num
    loop
        dbms_output.put('*');
    end loop;
		dbms_output.put_line('');
	
end;

