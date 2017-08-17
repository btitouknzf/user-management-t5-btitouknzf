package com.example.terasoluna.domain.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Matchers.isNull;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.dbunit.DataSourceBasedDBTestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.example.terasoluna.domain.model.UserInfo;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.destination.Destination;
import com.ninja_squad.dbsetup.operation.Operation;

/*

//Junit+jdbctemplateパターン
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/test-context.xml"})
@Transactional
@Rollback
public class UserInfoRepositoryTest {

	@Inject
	UserInfoRepository target;
	
	@Inject
	JdbcTemplate jdbctemplate;
	
	@Before
	public void setUp() throws Exception {
		//delete
		jdbctemplate.update("DELETE FROM t_userrole");
		jdbctemplate.update("DELETE FROM t_userinfo");
		
		//insert
		jdbctemplate.update("INSERT into t_userinfo values('0002','orange','1992-2-2','東京都中央区月島一丁目3-9','0387654321','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK',1,'2015-6-3 14:29:00')");
		jdbctemplate.update("INSERT into t_userrole values('0002','USER')");
	}
	
	@Test
	public void testFindOne1() throws Exception {
		String userId = "0002";
		UserInfo actual = target.findOne(userId);
		
		assertThat(actual.getUserId(), is(userId));
	}
	
	@Test
	public void testFindOne2() throws Exception {
		String userId = "0002";
		UserInfo actual = target.findOne(userId);
		
		assertThat(actual.getUsername(), is("orange"));
	}
	
	@Test
	public void testFindOne3() throws Exception {
		String userId = "xxxx";
		UserInfo actual = target.findOne(userId);
		
		assertThat(actual, nullValue());
	}
}
 */


//Junit+DBunitパターン
/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/test-context-dbunit.xml"})
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionDbUnitTestExecutionListener.class,
	SqlScriptsTestExecutionListener.class
})
@Transactional
@Rollback
@DatabaseSetup("/META-INF/test_data.xml")
@ExpectedDatabase(value = "/META-INF/afterselect_data.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
public class UserInfoRepositoryTest {
	
	@Inject
	UserInfoRepository target;
	

	@Test
	public void testFindOne1() throws Exception {
		String userId = "0002";
		UserInfo actual = target.findOne(userId);
		
		assertThat(actual.getUserId(), is(userId));
	}
	
	@Test
	public void testFindOne2() throws Exception {
		String userId = "0002";
		UserInfo actual = target.findOne(userId);
		
		assertThat(actual.getUsername(), is("orange"));
	}
	
	@Test
	public void testFindOne3() throws Exception {
		String userId = "xxxx";
		UserInfo actual = target.findOne(userId);
		
		assertThat(actual, nullValue());
	}
}
*/

//Junit+DBsetupパターンselectのみ
/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/test-context.xml"})
@Transactional
@Rollback
public class UserInfoRepositoryTest {
		
	@Inject
	DataSource dataSource;
	
	@Inject
	UserInfoRepository target;
	
	@Before
	public void setUp(){
		
		//直接記述パターン
		Operation operation = 
				Operations.sequenceOf(
						CommonOperationsForDbsetup.DELETE_USERROLE,
						CommonOperationsForDbsetup.DELETE_USERINFO,
						Operations.insertInto("t_userinfo")
							.columns("userid","username","birthday","address","tellphone","password","state","updatedate")
							.values("0002","orange","1992-02-02","東京都中央区月島一丁目3-9","0387654321","$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK",1,"2015-06-03 14:29:00")
							.build());
		
		DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
		dbSetup.launch();
		
		
		//メソッド外だしパターン
		Destination dest = new DataSourceDestination(dataSource);
		Operation ops = Operations.sequenceOf(CommonOperationsForDbsetup.DELETE_USERROLE,
												CommonOperationsForDbsetup.DELETE_USERINFO,
												CommonOperationsForDbsetup.INSERT_USERINFO,
												CommonOperationsForDbsetup.INSERT_USERROLE);
		DbSetup dbSetup = new DbSetup(dest, ops);
		dbSetup.launch();
		
		
		//大量データ投入(SEEQUENCEメソッド)
		Destination dest = new DataSourceDestination(dataSource);
		Operation ops = Operations.sequenceOf(CommonOperationsForDbsetup.DELETE_USERROLE,
												CommonOperationsForDbsetup.DELETE_USERINFO,
												CommonOperationsForDbsetup.INSERT_USERINFO_SEEQUENCE,
												CommonOperationsForDbsetup.INSERT_USERROLE);
		DbSetup dbSetup = new DbSetup(dest, ops);
		dbSetup.launch();
		
		
		
		Destination dest = new DataSourceDestination(dataSource);
		Operation ops = Operations.sequenceOf(CommonOperationsForDbsetup.DELETE_ALL,
												CommonOperationsForDbsetup.INSERT_0002SET);
		DbSetup dbSetup = new DbSetup(dest, ops);
		dbSetup.launch();
		
		
	}
	
	@Test
	public void testFindOne1() throws Exception {
		String userId = "0002";
		UserInfo actual = target.findOne(userId);
		
		assertThat(actual.getUserId(), is(userId));
	}
	
	@Test
	public void testFindOne2() throws Exception {
		String userId = "0002";
		UserInfo actual = target.findOne(userId);
		
		assertThat(actual.getUsername(), is("orange"));
	}
	
	@Test
	public void testFindOne3() throws Exception {
		String userId = "xxxx";
		UserInfo actual = target.findOne(userId);
		
		assertThat(actual, nullValue());
	}
}
*/

//Junit+DBsetupパターン更新系テスト含むパターン
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/test-context.xml"})
@Transactional
@Rollback
public class UserInfoRepositoryTest {
		
	@Inject
	DataSource dataSource;
	
	@Inject
	UserInfoRepository target;
	
	private static DbSetupTracker TRACKER = new DbSetupTracker();
	
	@Before
	public void setUp(){
		//直接記述パターン
		/*
		Operation operation = 
				Operations.sequenceOf(
						CommonOperationsForDbsetup.DELETE_USERROLE,
						CommonOperationsForDbsetup.DELETE_USERINFO,
						Operations.insertInto("t_userinfo")
							.columns("userid","username","birthday","address","tellphone","password","state","updatedate")
							.values("0002","orange","1992-02-02","東京都中央区月島一丁目3-9","0387654321","$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK",1,"2015-06-03 14:29:00")
							.build());
		
		DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
		dbSetup.launch();
		*/
		
		//メソッド外だしパターン
		/*
		Destination dest = new DataSourceDestination(dataSource);
		Operation ops = Operations.sequenceOf(CommonOperationsForDbsetup.DELETE_USERROLE,
												CommonOperationsForDbsetup.DELETE_USERINFO,
												CommonOperationsForDbsetup.INSERT_USERINFO,
												CommonOperationsForDbsetup.INSERT_USERROLE);
		DbSetup dbSetup = new DbSetup(dest, ops);
		dbSetup.launch();
		*/
		
		//大量データ投入(SEEQUENCEメソッド)
		/*
		Destination dest = new DataSourceDestination(dataSource);
		Operation ops = Operations.sequenceOf(CommonOperationsForDbsetup.DELETE_USERROLE,
												CommonOperationsForDbsetup.DELETE_USERINFO,
												CommonOperationsForDbsetup.INSERT_USERINFO_SEEQUENCE,
												CommonOperationsForDbsetup.INSERT_USERROLE);
		DbSetup dbSetup = new DbSetup(dest, ops);
		dbSetup.launch();
		*/
		
		
		Destination dest = new DataSourceDestination(dataSource);
		Operation ops = Operations.sequenceOf(CommonOperationsForDbsetup.DELETE_ALL,
												CommonOperationsForDbsetup.INSERT_0002SET);
		DbSetup dbSetup = new DbSetup(dest, ops);
		
		//メソッドごとに、必要に応じてDbSetupを実行する。
		TRACKER.launchIfNecessary(dbSetup);
		
		
	}
	
	@Test
	public void testFindOne1() throws Exception {
		String userId = "0002";
		UserInfo actual = target.findOne(userId);
		
		assertThat(actual.getUserId(), is(userId));
		
		//データを更新しないテストケースでは、DbSetupTracker#skipNextLaunch(); を呼び出しておく
		// これにより、次の(＝別メソッドの)テストの事前処理で DbSetupTracker#launchIfNecessary() が
        // 呼び出されてもテストデータ再作成処理が実行されなくなる
		TRACKER.skipNextLaunch();
	}
	
	@Test
	public void testFindOne2() throws Exception {
		String userId = "0002";
		UserInfo actual = target.findOne(userId);
		
		assertThat(actual.getUsername(), is("orange"));

		TRACKER.skipNextLaunch();
	}
	
	@Test
	public void testFindOne3() throws Exception {
		String userId = "xxxx";
		UserInfo actual = target.findOne(userId);
		
		assertThat(actual, nullValue());
		
		TRACKER.skipNextLaunch();
	}
	
}

