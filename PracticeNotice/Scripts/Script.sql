INSERT INTO NOTICE(NOTICE_IDX, TITLE, WRITER, CONTENT)
 values(seq_notice.nextval, '테스트용 제목입니다', '겨울', '테스트용 내용입니다')
 
 CREATE TABLE noticemember(
 	noticemember_idx NUMBER PRIMARY KEY
 	, id varchar2(20) UNIQUE NOT NULL
 	, pass varchar2(20) NOT NULL
 	, name varchar2(20) NOT NULL
 	, regdate DATE DEFAULT sysdate
 )
 
 CREATE SEQUENCE seq_noticemember
 INCREMENT BY 1
 START WITH 1