 DROP TABLE MEMBER;
CREATE TABLE MEMBER(
HAKBUN VARCHAR2(4) PRIMARY KEY,
NAME VARCHAR2(15),
ADDR VARCHAR2(4),
PHONE CHAR(14));

INSERT INTO MEMBER VALUES('A001','이기자','서울','010-1111-1111');
INSERT INTO MEMBER VALUES('A002','김기자','대구','010-2222-2222');
SELECT * FROM MEMBER;

COMMIT;


create or replace procedure call_select(
v_member_cursor out sys_refcursor
)
is begin
open v_member_cursor
for select * from member order by hakbun;
end;
/

create or replace procedure call_insert(hakbun MEMBER.HAKBUN%TYPE,
name MEMBER.NAME%TYPE, addr MEMBER.ADDR%TYPE, phone MEMBER.PHONE%TYPE)
is
begin
insert into member values (hakbun,name,addr,phone);
end;
/

create or replace procedure call_update(p_hakbun MEMBER.HAKBUN%TYPE,
p_addr MEMBER.ADDR%TYPE, p_phone MEMBER.PHONE%TYPE)
is
begin
update member set addr = p_addr,phone =p_phone where hakbun = p_hakbun;
end;
/

create or replace procedure call_delete(p_hakbun MEMBER.HAKBUN%TYPE)
is 
begin
delete from member where hakbun =p_hakbun;
end;
/

CREATE TABLE SUNGJUK(
HAKBUN VARCHAR2(4) PRIMARY KEY,
IRUM VARCHAR2(15),
KOR NUMBER(3),
ENG NUMBER(3),
MATH NUMBER(3),
TOT NUMBER(3),
AVG NUMBER(6,2),
GRADE VARCHAR2(2));

SELECT * FROM SUNGJUK;
DESC SUNGJUK;