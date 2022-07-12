package com.aop.step1;

public class Main {
	public static void main(String[] args) {
		ForCalculator forCal= new ForCalculator();
		RecCalculator recCal= new RecCalculator();
		//long startRec = System.nanoTime();
		//System.out.println(recCal.factorial(5));
		//long endRec=System.nanoTime();
		
		//long startFor=System.nanoTime();
		//System.out.println(forCal.factorial(5));
		//long endFor=System.nanoTime();
		// 이 메소드별로 호출하는데 시간을 측정하려고 합니다.
		
		//System.out.println("Rec 걸린시간 : " + (endRec-startRec));
		//System.out.println("For 걸린시간 : " + (endFor-startFor));
		
		//지금은 2개니까 할만한데 메소드 호출하는 곳이 1억개라면? 퇴사해야한다.
		//퇴사하기싫다? = > 메소드안에서 시간을 출력하는 코드를 써보자..? Rec은 안되네
		//어떻게 하지??? 프록시 객체(deligate)를 만들어서 ForCal,RecCal을 대신 실행시켜주자.
		
		ExeTimeCalculator exFor = new ExeTimeCalculator(forCal);
		ExeTimeCalculator exRec = new ExeTimeCalculator(recCal);
		System.out.println("for factorial(5) 결과 : " + exFor.factorial(5));
		System.out.println("rec factorial(5) 결과 : " + exRec.factorial(5));
		
		
		//ExeTimeCalculator 를 프록시객체라고 하고, ForCal, RecCal 객체를 대상객체라고 합니다.
		// 공통기능은 프록시객체에서 담당,				핵심기능은 대상객체에서
	}
}