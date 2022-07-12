package com.aop.step2;

public class RecCalculator implements Calculator{
	
	@Override
	public long fatorial(long num) {
		if(num==1) return 1;
		return num * fatorial(num-1);
	}

}
