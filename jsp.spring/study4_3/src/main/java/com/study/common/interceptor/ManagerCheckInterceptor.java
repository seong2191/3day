package com.study.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.study.login.vo.UserVO;

public class ManagerCheckInterceptor extends HandlerInterceptorAdapter{
	//		/member/* 는 관리자만 접근 가능하다. 관리자가 아니면 들어갈 수 없다.
	// 관리자인지 아닌지는 UserVO의 userRole가지고 판단.
	// UserVO가 session에 담기는 곳은 LoginController부터 찾아보세요 로그인서비스?
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute("USER_INFO");
		if(user==null) {
			response.sendRedirect(request.getContextPath()+"/login/login.wow");
			return false;
		}
		
		if(!user.getUserRole().equals("MANAGER")) {
			response.sendError(403, "넌 매니저가 아님");
			return false;
		}
		
		return true;
	}
}
