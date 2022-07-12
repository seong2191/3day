package com.di.step5;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class FreeBoardServiceImpl1 implements IFreeBoardService{
	@Inject
	IFreeBoardDao freeBoardDao;
	
	/*
	 * public FreeBoardServiceImpl1(IFreeBoardDao freeBoardDao) { this.freeBoardDao
	 * = freeBoardDao; }
	 */
	
	@Override
	public void modifyBoard() {
		freeBoardDao.updateBoard();
	}

}
