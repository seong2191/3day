/*
    procedure 프로시저
    업무적으로 복잡한 구문을 별도의 구문으로 작성하여
    DB에 저장하고 실행가능한 고유한 기능을 수행하는 객체
    함수와 유사하지만 서버에서 실행되며 리턴값을 0 ~ n개로 설정가능
    DML문에서는 사용하지 못하며 PL/SQL문에서 사용가능
*/

create or replace procedure my_job_proc
(     p_job_id in jobs.job_id%type
    , p_job_title in jobs.job_title%type
    , p_min_sal in jobs.min_salary%type
    , p_max_sal jobs.max_salary%type
)
is
begin
    insert into jobs(job_id, job_title, min_salary,max_salary)
    values (p_job_id, p_job_title, p_min_sal, p_max_sal);
    commit;
end;

-- 실행
exec my_job_proc('sm_job1', 'sample job1', 1000,5000);
--execute my_job_proc('sm_job1', 'sample job1', 1000,5000);

select *
from jobs
where job_id = 'sm_job1';

-- in : 프로시저 내부에서 사용
-- out : 리턴 변수
-- in out : 내부에서도 사용, 리턴도 됨
create or replace procedure test_proc (
      p_val1 varchar2 -- 디폴트 in
    , p_val2 out varchar2
    , p_val3 in out varchar2
)
is
begin
    dbms_output.put_line('p_val1:'||p_val1);
    dbms_output.put_line('p_val2:'||p_val3);
    dbms_output.put_line('p_val2:'||p_val3);
    p_val2 := 'b2';
    p_val3 := 'c2';
end;
-- out 변수 테스트는 리턴받을 변수가 필요함
declare
    v_var1 varchar2(30) := 'a';
    v_var2 varchar2(30) := 'b';
    v_var3 varchar2(30) := 'c';
begin
    --pl/sql에서 실행시 호출명령어 필요없음
 test_proc(v_var1, v_var2, v_var3);
 dbms_output.put_line('v_var2: ' || v_var2);
 dbms_output.put_line('v_var3: ' || v_var3);
end;


/*  매개변수 
    구분값, 부서번호, 부서명을 입력 받아
    insert:i
    update:u
    delete:d 를 수행하는 프로시저를 작성하시오
*/
select *
from ex17_1;
CREATE TABLE ex17_1 AS
SELECT department_id, department_name
FROM departments;
ALTER TABLE ex17_1 ADD CONSTRAINT pk_17 PRIMARY KEY(department_id);

create or replace procedure dep_proc (
    p_flag varchar2
    ,p_id ex17_1.department_id%type
    ,p_nm ex17_1.department_name%type := null
)
is
begin
    -- i insert, u update, d delete
    if p_flag = 'i' then
     insert into ex17_1 values(p_id, p_nm);
     
    elsif p_flag = 'u' then
     update ex17_1
     set department_name = p_nm
     where department_id = p_id;
     
    elsif p_flag = 'd' then
     delete ex_17_1
     where department_id = p_id;
     
    end if;
    commit;
exception when others then
 DBMS_OUTPUT.PUT_LINE('오류남');
 DBMS_OUTPUT.PUT_LINE(sqlcode);     --오류코드 반환
 DBMS_OUTPUT.PUT_LINE(sqlerrm);     --오류 메시지 반환
 DBMS_OUTPUT.PUT_LINE(dbms_utility.format_error_backtrace);
                                    -- 오류 발생 라인 반환
end;
exec dep_pro('i',301,'소셜마케팅팀');


create or replace procedure text_ex_proc
is
 vi_num number := 0;
begin
 vi_num := 10 / 0;
 dbms_output.put_line('정상처리');
exception
when zero_divide then
 dbms_output.put_line(sqlerrm);
when others then
 dbms_output.put_line('오류남.');
end;

create or replace procedure text_no_ex_proc
is
 vi_num number := 0;
begin
 vi_num := 10 / 0;
 dbms_output.put_line('정상처리');
end;

begin
 test_no_ex_proc;   -- 프로시저 내부 오류로 멈춤
 dbms_output.put_line('success');
end;


begin
 test_ex_proc;   -- 프로시저 내부 오류로 멈춤
 dbms_output.put_line('success');
end;


/*
    트랜잭션(Transaction): '거래'라는 뜻으로 은행에서는 입금과 출금을
                            하는 거래를 뜻하며 사용자, 오라클 서버, 개발자, DBA등에게
                            데이터 일치성과 동시발생을 보장하기 위해 트랜잭션을 처리한다.
                            업무의 가장 작은 단위로 구분하여 해당 업무가 성공하면 commit;
                            하나라도 실패하면 rollback; 을 통해 작업 이력을 제거한다.
                            
    savepoint : 작업 취소의 부분을 지정 할 수 있음
*/
create table ex17_2 (
    seq number
    , nm varchar2(20)
);
create or replace procedure save_test_proc(flag varchar2)
is
    point1 exception;
    point2 exception;
    vn_num number;
begin
    insert into ex17_2 values(1,'point1 before');
    savepoint mysavepoint1;
    insert into ex17_2 values(2,'point2 before');
    savepoint mysavepoint2;
    insert into ex17_2 values(3,'end');
    
    if flag = '1' then
     raise point1;
    elsif flag = '2' then
     raise point2;
    elsif flag = '3' then
     vn_num := 10/0;
    end if;
commit;
exception
when point1 then
 dbms_output.put_line('error1');
 rollback to mysavepoint1;
 commit;
when point2 then
 dbms_output.put_line('error2');
 rollback to mysavepoint2;
when others then
 dbms_output.put_line('error3');
 rollback;
end;

exec save_test_proc('3');

select *
from ex17_2;




