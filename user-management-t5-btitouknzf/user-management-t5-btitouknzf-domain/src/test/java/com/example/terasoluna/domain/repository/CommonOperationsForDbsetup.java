package com.example.terasoluna.domain.repository;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.generator.ValueGenerators;
import com.ninja_squad.dbsetup.operation.Operation;

public class CommonOperationsForDbsetup {
	
	public static final Operation DELETE_ALL =
			Operations.sequenceOf(
					Operations.deleteAllFrom("t_userrole"),
					Operations.deleteAllFrom("t_userinfo"));
	
	public static final Operation DELETE_USERROLE =
			Operations.deleteAllFrom("t_userrole");
	
	public static final Operation DELETE_USERINFO =
			Operations.deleteAllFrom("t_userinfo");

	public static final Operation INSERT_0002SET =
			Operations.sequenceOf(
					Operations.insertInto("t_userinfo")
						.columns("userid","username","birthday","address","tellphone","password","state","updatedate")
						//Date型の場合・・・yyyy-MM-ddフォーマットをサポート
						//TimeStamp型の場合・・・yyyy-MM-dd hh:mm:ssもしくはyyyy-MM-ddフォーマットをサポート
						.values("0002","orange","1992-02-02","東京都中央区月島一丁目3-9","0387654321","$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK",1,"2015-06-03 14:29:00")
						.build(),
						
					Operations.insertInto("t_userrole")
						.columns("userid","role")
						.values("0002","USER")
						.build());
	
	
	public static final Operation INSERT_USERINFO =
			Operations.insertInto("t_userinfo")
				.columns("userid","username","birthday","address","tellphone","password","state","updatedate")
				//Date型の場合・・・yyyy-MM-ddフォーマットをサポート
				//TimeStamp型の場合・・・yyyy-MM-dd hh:mm:ssもしくはyyyy-MM-ddフォーマットをサポート
				.values("0002","orange","1992-02-02","東京都中央区月島一丁目3-9","0387654321","$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK",1,"2015-06-03 14:29:00")
				.build();
	
	public static final Operation INSERT_USERROLE =
			Operations.insertInto("t_userrole")
				.columns("userid","role")
				.values("0002","USER")
				.build();
	
	public static final Operation INSERT_USERINFO_NOPASS =
			Operations.insertInto("t_userinfo")
				//テスト対象外項目を一括で設定
				.withDefaultValue("password","$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK")
				.withDefaultValue("tellphone", null)
				//テスト対象を記載
				.columns("userid","username","birthday","address","state","updatedate")
				.values("0002","orange","1992-02-02","東京都中央区月島一丁目3-9",1,"2015-06-03 14:29:00")
				.build();
	
	public static final Operation INSERT_USERINFO_SEEQUENCE =
			Operations.insertInto("t_userinfo")
				//useridに0001から始まる連番を格納
				.withGeneratedValue("userid", ValueGenerators.stringSequence("").startingAt(1L).withLeftPadding(4))
				//固定値の一括設定
				.columns("username","birthday","address","tellphone","password","state","updatedate")
				.repeatingValues("orange","1992-02-02","東京都中央区月島一丁目3-9","0387654321","$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK",1,"2015-06-03 14:29:00")
				//繰り返し設定（100件）
				.times(100)
				.build();
}
