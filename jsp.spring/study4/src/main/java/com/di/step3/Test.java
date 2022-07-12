package com.di.step3;

public class Test {
	public static void main(String[] args) {
		//DI : Depency Inject, 의존 주입
		// 의존하는 객체를 외부에서 주입함으로써 코드의 재사용성을 높이는 기술
		
		//step3에서는 의존 객체를 외부에서 주입을 Assembler를 이용해서
		//DaoOracle 대신에 mysql로 변경하래요
		
		Assembler assembler = new Assembler(); 
		// assembler는 freeBoardDao,service1~3의 객체를 가지고 있다.
		//spring에서 assembler(의 역할을 하는 애)가 가지고 있는 객체 = 빈(bean)
		
		IFreeBoardService freeBoardService1 = assembler.getFreeBoardService1();
		freeBoardService1.modifyBoard();
		
		IFreeBoardService freeBoardService2 = assembler.getFreeBoardService2();
		freeBoardService2.modifyBoard();
		
		IFreeBoardService freeBoardService3 = assembler.getFreeBoardService3();
		freeBoardService3.modifyBoard();
	}
}
