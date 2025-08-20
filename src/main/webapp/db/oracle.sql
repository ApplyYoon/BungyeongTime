CREATE TABLE user_tbl(
	user_id varchar2(30) PRIMARY KEY,
	user_pw varchar2(128) NOT NULL,
	user_name varchar2(60)
);

CREATE TABLE post_tbl(
	post_id varchar2(30) PRIMARY KEY,
	user_id varchar2(30),
	post_title varchar2(90),
	post_content CLOB,
	post_suggest number,
	post_report number
);

INSERT INTO post_tbl VALUES(
	'1', 'test', 'TestTitle', 'TestContent', 0, 0
);

SELECT NVL(MAX(TO_NUMBER(post_id)), 0) + 1 AS next_post_id FROM post_tbl;

SELECT * FROM user_tbl;
SELECT * FROM post_tbl;

SELECT user_pw FROM user_tbl
WHERE user_id = '1';

DROP TABLE post_tbl