/* define the schemas. */
CREATE TABLE t_userinfo(
	userid		VARCHAR(36) PRIMARY KEY,
	username 	VARCHAR(255),
	birthday 	DATE,
	address 	VARCHAR(255),
	tellphone 	VARCHAR(11),
	password 	VARCHAR(255),
	state 		INT,
	updatedate 	DATETIME
);

CREATE TABLE t_userrole(
	userid		VARCHAR(36),
	role		VARCHAR(4),
	FOREIGN KEY (userid) REFERENCES t_userinfo (userid)
);
