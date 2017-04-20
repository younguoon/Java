DROP TABLE MEMBER;
CREATE TABLE MEMBER (
    HAKBUN  VARCHAR2(4) PRIMARY KEY,
    NAME    VARCHAR2(15),
    ADDR    VARCHAR2(4),
    PHONE   CHAR(14)
);

INSERT INTO MEMBER
VALUES('A001', '이기자', '서울', '010-1111-1111');

INSERT INTO MEMBER
VALUES('A002', '가가가', '서울', '010-2222-2222');

INSERT INTO MEMBER
VALUES('A003', '나나나', '서울', '010-3333-3333');

INSERT INTO MEMBER
VALUES('A004', '다다다', '서울', '010-4444-4444');

SELECT * FROM MEMBER;

commit;

CREATE OR REPLACE PROCEDURE call_select (
    v_member_cursor out sys_refcursor
)
IS
BEGIN
    OPEN V_MEMBER_CURSOR
    FOR
    SELECT * FROM MEMBER
    ORDER BY hakbun;
END;
/


create or replace procedure call_insert(
    hakbun  MEMBER.HAKBUN%TYPE,
    name    MEMBER.NAME%TYPE,
    addr    MEMBER.ADDR%TYPE,
    phone   MEMBER.phone%TYPE
)
IS
BEGIN
    insert into member values(hakbun, name, addr, phone);
END;
/

create or replace procedure call_update(
    p_hakbun    MEMBER.HAKBUN%TYPE,
    p_addr      MEMBER.ADDR%TYPE,
    p_phone     MEMBER.PHONE%TYPE
)
IS
BEGIN
    update member set addr = p_addr, phone = p_phone
    where hakbun = p_hakbun;
END;
/

select * from member;

create or replace procedure call_delete(p_hakbun MEMBER.HAKBUN%TYPE)
IS
BEGIN
    delete from member where hakbun = p_hakbun;
END;
/


create table sungjuk (
    hakbun  varchar2(4) primary key,
    irum    varchar2(15),
    kor     number(3),
    eng     number(3),
    math    number(3),
    tot     number(3),
    avg     number(6, 2),
    grade   varchar2(2)
);


insert into sungjuk
values('111', '111', 10, 10, 10);


select * from sungjuk;

