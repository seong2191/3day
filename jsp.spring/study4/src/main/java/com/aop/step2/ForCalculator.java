package com.aop.step2;

public class ForCalculator implements Calculator{

	@Override
	public long fatorial(long num) {
//		long startFor= System.nanoTime();
		long result=1;
		for(int i=1; i<=num ; i++) {
			result *=i;
		}
//		long endFor= System.nanoTime();
//		System.out.println("For 걸린시간 : "+(endFor-startFor));
		return result;
	}

}
