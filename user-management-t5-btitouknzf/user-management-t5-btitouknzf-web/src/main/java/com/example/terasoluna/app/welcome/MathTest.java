package com.example.terasoluna.app.welcome;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathTest {

	Math math = new Math();
	
	@Test
	public void testCase_失敗(){
		fail("失敗");
	}
	
	@Test
	public void testCase_１から１０までの合計は５５(){
		assertEquals(55, math.sum(1,2,3,4,5,6,7,8,9,10));
	}
	
	@Test
	public void testCase_１から１０までの合計は５４() {
		assertEquals(54, math.sum(1,2,3,4,5,6,7,8,9,10) );
	}
	
	@Test
	public void testCase_１から１０までの積は５４(){
		assertEquals(100, math.multiple(1,2,3,4,5,6,7,8,9,10));
	}
	
	@Test
	public void testCase_10(){
		assertEquals(1, math.multiple(2,3,4,5,6,7,8,9,10));
	}
	
	@Test
	public void testCase_１から１０までの積は０(){
		assertEquals(0, math.multiple(1,2,3,4,5,6,7,8,9,0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCase_Exception発生() throws Exception{
		Integer.parseInt("数値に変換できないときにException発生");
	}

}
