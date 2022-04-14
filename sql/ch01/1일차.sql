--주석 

/*

 이 공간은 주석 영역입니다.
 
 SQL(Structured Query Language) 구조화된 질의 언어
 종류 DDL, DML, DCL
 
 데이터 정의어 (DDL, Data Definition Language)
 테이블이나 관계의 구조를 생성하는데 사용
 CREATE, ALTER, DROP, TRUNCATE.. (DB)
 
 **데이터 조작어(DML, DATA Manipualtion Language)
 테이블의 데이터 검색, 삽입, 수정, 삭제하는데 사용
 SELECT, UPDATE, DELETE, INSERT..(소프트웨어 관리자)
 
 데이터 제의어(DCL, Data Control Language)
 데이터 사용 권한을 관리하는데 사용 (DB)
 GRANT, REVOKE
 
 */
 
-- 테이블 스페이스 생성 (물리적인 저장공간)
CREATE TABLESPACE myts
datafile '/u01/app/oracle/oradata/XE/myts.dbf'
size 100M autoextend on next 5M;

--계정생성(유저)
CREATE USER java IDENTIFIED BY oracle
DEFAULT TABLESPACE myts
TEMPORARY TABLESPACE temp;

--권한부여
GRANT connect, resource TO java;

--명령어 사이의 구분은 ; <- 세미콜론으로
--명령어 사이의 대소문자는 구별 안함( 데이터 자체는 구별함)
--빨간줄은 오류, 오류는 구글서칭 

