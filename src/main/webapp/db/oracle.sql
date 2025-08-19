CREATE TABLE user_tbl(
	user_id varchar2(30) PRIMARY KEY,
	user_pw varchar2(128) NOT NULL,
	user_name varchar2(60)
);

CREATE TABLE post_tbl(
	post_id varchar2(30) PRIMARY KEY,
	user_id varchar2(30),
	post_title varchar2(90),
	post_body CLOB,
	post_suggest number,
	post_report number
);

SELECT * FROM user_tbl;

SELECT user_pw FROM user_tbl
WHERE user_id = '1';