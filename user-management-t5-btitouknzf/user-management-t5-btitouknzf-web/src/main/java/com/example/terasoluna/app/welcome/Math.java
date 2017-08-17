package com.example.terasoluna.app.welcome;

public class Math {
	/*
	 * 合計値を返します。
	 */
	public int sum(int... args){
		int ret = 0;
		for(int i:args){
			ret += i;
		}
		return ret;
	}
	
	/*
	 * 積の値を返します。
	 */
	
	public int multiple(int... args){
		int ret = 1;
		for(int i:args){
			ret = ret * i;
		}
		return ret;
	}
}
