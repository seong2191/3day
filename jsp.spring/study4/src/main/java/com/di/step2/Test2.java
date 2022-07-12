package com.di.step2;

public class Test2 {
	public static void main(String[] args) {
		//DI : Depency Inject, 의존 주입
		// 의존하는 객체를 외부에서 주입함으로써 코드의 재사용성을 높이는 기술
		// 의존 : 어떤 클래스1 에서 다른 클래스2 의 메소드(or 필드 등)을 사용할 때
		//			클래스1은 클래스2에 의존한다.
		
		//step2에서는 의존 객체를 외부에서 주입 -> 의존 주입
		// 생성장방식, setter방식, 필드(only spring)인데
		
		//DaoOracle 대신에 mysql로 변경하래요
		// 어디바꿔야할까용
		
		IFreeBoardDao freeBoardDao = new FreeBoardDaoOracle(); // <- 여기만 바꾸면 됩니다.
		
		IFreeBoardService freeBoardService = new FreeBoardServiceImpl1(freeBoardDao);
		freeBoardService.modifyBoard();
		
		IFreeBoardService freeBoardService2 = new FreeBoardServiceImpl2(freeBoardDao);
		freeBoardService2.modifyBoard();
		
		IFreeBoardService freeBoardService3 = new FreeBoardServiceImpl3(freeBoardDao);
		freeBoardService3.modifyBoard();
		
	}
}
