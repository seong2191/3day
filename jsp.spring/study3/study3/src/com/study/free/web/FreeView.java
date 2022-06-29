package com.study.free.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.common.vo.ResultMessageVO;
import com.study.exception.BizNotEffectedException;
import com.study.exception.BizNotFoundException;
import com.study.free.service.FreeBoardServiceImpl;
import com.study.free.service.IFreeBoardService;
import com.study.free.vo.FreeBoardVO;
import com.study.servlet.Handler;

public class FreeView implements Handler {

	
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int boNo = Integer.parseInt(req.getParameter("boNo"));
		IFreeBoardService freeBoardService = new FreeBoardServiceImpl();
		ResultMessageVO resultMessageVO = new ResultMessageVO();
		try{
			FreeBoardVO freeBoard = freeBoardService.getBoard(boNo);
			freeBoardService.increaseHit(boNo);
			req.setAttribute("freeBoard", freeBoard);
			return "free/freeView";
		}catch (BizNotFoundException | BizNotEffectedException bne){
			resultMessageVO.messageSetting(false, "NotFound OR Not Effect", "글이 없거나 조회수 증가 실패", "/free/freeList.wow", "목록으로");
			req.setAttribute("resultMessageVO", resultMessageVO);
			return "common/message";
		}
		
	
	}
}
