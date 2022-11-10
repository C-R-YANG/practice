-- select now(); -- 현재시간을 출력한다.
INSERT INTO user_info VALUES ('asdf1', '1234', '양초롱', 'aaa@aaa.com', '1996-08-10', 'fb', now());
INSERT INTO user_info VALUES ('qwer1', '1234', '양초롱', 'aaa@aaa.com', '1996-08-10', 'fb', now());

select * from user_info;

delete from user_info; -- where id='asdf'; -- 행 단위로 데이터를 삭제