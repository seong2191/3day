package com.aop.step1;

public class ForCalculator implements Calculator{
		
	@Override
	public long factorial(long num) {
		long startFor=System.nanoTime();
		long result=1;
		for(int i=1; i<=num ; i++) {
			result *=i;
		}
		long endFor=System.nanoTime();
		return result;
	}
}