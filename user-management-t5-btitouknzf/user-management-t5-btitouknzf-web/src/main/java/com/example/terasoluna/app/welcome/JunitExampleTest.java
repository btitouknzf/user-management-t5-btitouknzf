package com.example.terasoluna.app.welcome;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitExampleTest {

	@Test
	public void testFoo() {
		JunitExample example1 = new JunitExample();
		assertEquals(1, example1.foo());
		JunitExample example2 = new JunitExample();
		assertEquals(1, example2.foo());
		JunitExample example3 = new JunitExample();
		assertEquals(1, example3.foo());
		JunitExample example4 = new JunitExample();
		assertEquals(5, example4.foo());
		JunitExample example5 = new JunitExample();
		assertEquals(1, example5.foo());
		JunitExample example6 = new JunitExample();
		assertEquals(1, example6.foo());
		
	}

}
