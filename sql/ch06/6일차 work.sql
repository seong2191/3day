CREATE TABLE 강의내역 (
     강의내역번호 NUMBER(3)
    ,교수번호 NUMBER(3)
    ,과목번호 NUMBER(3)
    ,강의실 VARCHAR2(10)
    ,교시  NUMBER(3)
    ,수강인원 NUMBER(5)
    ,년월 date
);

CREATE TABLE 과목 (
     과목번호 NUMBER(3)
    ,과목이름 VARCHAR2(50)
    ,학점 NUMBER(3)
);

CREATE TABLE 교수 (
     교수번호 NUMBER(3)
    ,교수이름 VARCHAR2(20)
    ,전공 VARCHAR2(50)
    ,학위 VARCHAR2(50)
    ,주소 VARCHAR2(100)
);

CREATE TABLE 수강내역 (
    수강내역번호 NUMBER(3)
    ,학번 NUMBER(10)
    ,과목번호 NUMBER(3)
    ,강의실 VARCHAR2(10)
    ,교시 NUMBER(3)
    ,취득학점 VARCHAR(10)
    ,년월 DATE 
);

CREATE TABLE 학생 (
     학번 NUMBER(10)
    ,이름 VARCHAR2(50)
    ,주소 VARCHAR2(100)
    ,전공 VARCHAR2(50)
    ,부전공 VARCHAR2(500)
    ,생년월일 DATE
    ,학기 NUMBER(3)
    ,평점 NUMBER
);


COMMIT;



/*       강의내역, 과목, 교수, 수강내역, 학생 테이블을 만드시고 아래와 같은 제약 조건을 준 뒤 
        (1)'학생' 테이블의 PK 키를  '학번'으로 잡아준다 
        (2)'수강내역' 테이블의 PK 키를 '수강내역번호'로 잡아준다 
        (3)'과목' 테이블의 PK 키를 '과목번호'로 잡아준다 
        (4)'교수' 테이블의 PK 키를 '교수번호'로 잡아준다
        (5)'강의내역'의 PK를 '강의내역번호'로 잡아준다. 
        (6)'학생' 테이블의 PK를 '수강내역' 테이블의 '학번' 컬럼이 참조한다 FK 키 설정
        (7)'과목' 테이블의 PK를 '수강내역' 테이블의 '과목번호' 컬럼이 참조한다 FK 키 설정 
        (8)'교수' 테이블의 PK를 '강의내역' 테이블의 '교수번호' 컬럼이 참조한다 FK 키 설정
        (9)'과목' 테이블의 PK를 '강의내역' 테이블의 '과목번호' 컬럼이 참조한다 FK 키 설정
            각 테이블에 엑셀 데이터를 임포트 

    ex) ALTER TABLE 학생 ADD CONSTRAINT PK_학생_학번 PRIMARY KEY (학번);
        
        ALTER TABLE 수강내역 
        ADD CONSTRAINT FK_학생_학번 FOREIGN KEY(학번)
        REFERENCES 학생(학번);

*/

 -- 컬럼명 수정
  alter table ex6_1 rename column col1 to co1_1;
  -- 타입 수정
  alter table ex6_1 modify col2 varchar2(30);
  -- 컬럼 추가
  alter table ex6_1 add col4 number;
  -- 컬럼삭제
  alter table ex6_1 drop column col4;
  -- 제약조건 추가
  alter table ex6_1 add constraint pk_ex6_1 primary key(col1);
  
  
  alter table 학생 add constraint pk_학생 primary key(학번);
  alter table 수강내역 add constraint pk_수강내역 primary key(수강내역번호);
  alter table 과목 add constraint pk_과목 primary key(과목번호);
  alter table 교수 add constraint pk_교수 primary key(교수번호);
  alter table 강의내역 add constraint pk_강의내역 primary key(강의내역번호);
  
  alter table 학생 add constraint fk_학생_수강내역 foreign key(학번) references 학생(학번);
  alter table 과목 add constraint fk_과목_수강내역2 foreign key(과목번호) references 과목(과목번호);
  alter table 교수 add constraint fk_교수_강의내역 foreign key(교수번호) references 교수(교수번호);
  alter table 과목 add constraint fk_과목_강의내역2 foreign key(과목번호) references 과목(과목번호);
  
  commit;