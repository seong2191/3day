package com.aop.step2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// ExTimeAspect(공통기능)이 ForCal, RecCal 메소드가 실행될때마다
//		ForCalculator forCal= new ForCalculator();
//		RecCalculator recCal= new RecCalculator();
//		System.out.println("ForCal factorial(5) 결과 : " +forCal.fatorial(5));
//		System.out.println("RecCal factorial(5) 결과 : " +recCal.fatorial(5));
		
		GenericXmlApplicationContext context= new GenericXmlApplicationContext("aop/step2.xml");
		ForCalculator forCal=context.getBean(ForCalculator.class);
		RecCalculator recCal=context.getBean(RecCalculator.class);
		System.out.println("ForCal 결과 : " +forCal.fatorial(5));
		System.out.println("RecCal 결과 : " +recCal.fatorial(5));
	}

}
