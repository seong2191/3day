package com.study.member.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.common.vo.ResultMessageVO;
import com.study.exception.BizNotFoundException;
import com.study.member.service.IMemberService;
import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.MemberVO;
import com.study.servlet.Handler;


public class MemberView implements Handler {

	
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String memId = req.getParameter("memId");
		
		IMemberService memberService = new MemberServiceImpl();
		ResultMessageVO resultMessageVO = new ResultMessageVO();
		try{
			MemberVO member = memberService.getMember(memId);
			req.setAttribute("member", member);
			return "member/memberView";
		}catch (BizNotFoundException bne){
			resultMessageVO.messageSetting(false, "NotFound", "명단조회실패", "/member/memberList.wow", "목록으로");
			req.setAttribute("resultMessageVO", resultMessageVO);
			return "common/message";
		}

	}
}
