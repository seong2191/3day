package com.di.step5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// DaoOracle, ServiceImpl		@Component
		// ServiceImpl에 @Inject는 생상자 위에
		// context.getBean에 "이름"지우고
		
		//에러발생상황
		/* 1. FreeBoardServiceImpl1에는 @Component랑 @Inject 있음
		 		+ FreeBoardDaoOracle에는 @Component 없음
		 		(가장 많이 만나는 에러)
		 		
		   2. FreeBoardServiceImpl1에는 @Component랑 @Inject 있음
		   		+ FreeBoardDaoOracle에는 @Component 있음
		   		+ FreeBoardDaoMysql에도 @Component 있음
		   		(원칙적으론 Dao는 둘 중 1개만 @Component 있는게 맞는데
		   		2개 있어도 해결은 할 수 있다. 근데 외울 필요는...)
		   		
		   3. FreeBoardServiceImpl1에는 @Inject가 없음
		 */
		
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("di/step5.xml");
		// content = assembler,
		// context "di/step4.xml"을 읽어서 거기에 적혀있는 객체들을 만들어서 가지고 있음

		IFreeBoardService freeBoardService1 = context.getBean(FreeBoardServiceImpl1.class);
		freeBoardService1.modifyBoard();

	}
}
