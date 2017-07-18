/* load the records. */
INSERT into t_userinfo values('0001','apple','1991-1-1','東京都江東区豊洲四丁目1-1','0312345678','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK',1,'2015-6-2 14:29:00');
INSERT into t_userinfo values('0002','orange','1992-2-2','東京都中央区月島一丁目3-9','0387654321','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK',1,'2015-6-3 14:29:00');
INSERT into t_userinfo values('0003','banana','1993-3-3','東京都中央区築地一丁目1-1','09012345678','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK',1,'2015-6-4 14:29:00');
INSERT into t_userinfo values('0004','peach','1994-4-4','東京都中央区銀座一丁目7-12','09087654321','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK',1,'2015-6-5 14:29:00');
INSERT into t_userinfo values('0005','pineapple','1995-5-5','東京都千代田区有楽町一丁目11-1','08012345678','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK',1,'2015-6-6 14:29:00');
INSERT into t_userinfo values('0006','pear','1996-6-6','東京都千代田区霞が関二丁目1-1','08087654321','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK',1,'2015-6-7 14:29:00');
INSERT into t_userinfo values('9999','melon','1996-6-6','東京都千代田区霞が関二丁目1-1','08087654321','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK',0,'2015-6-7 14:29:00');
INSERT into t_userinfo values('9998','watermelon','1996-6-6','東京都千代田区霞が関二丁目1-1','08087654321','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK',2,'2015-6-7 14:29:00');

INSERT into t_userrole values('0001','ADMN');
INSERT into t_userrole values('0001','USER');
INSERT into t_userrole values('0002','USER');
INSERT into t_userrole values('0003','USER');
INSERT into t_userrole values('0004','USER');
INSERT into t_userrole values('0005','USER');
INSERT into t_userrole values('0006','USER');
INSERT into t_userrole values('9998','USER');
INSERT into t_userrole values('9999','USER');

commit;