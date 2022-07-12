package com.aop.step2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExTimeAspect { // ExTime~ 역할인데 AOP공통기능을 Aspect라고 해서 Aspect로 만듬 
	
	@Pointcut("execution(public * com.aop.step2..*(..))")// 어떤 메소드를 대상으로 할지를 쓰는건데 For.Rec의 factorial
	private void publicTarget() {}
	
	// 공통기능으로 시간측정
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		long startTime = System.nanoTime();
		try {
			Object result= joinPoint.proceed(); // joinPoint가 대상객체 (핵심기능)
			return result;
		}finally {
			long endTime= System.nanoTime();
			System.out.println("걸린시간 : " + (endTime - startTime));
			Signature signature = joinPoint.getSignature();
			System.out.println("?? : " + signature.getDeclaringTypeName());
			System.out.println("메소드 이름 : " + signature.getName());
			System.out.println("클래스 이름 : " + joinPoint.getTarget().getClass().getName());
			System.out.println("파라미터 목록 : " + joinPoint.getArgs()[0]);
		}
	}
}
