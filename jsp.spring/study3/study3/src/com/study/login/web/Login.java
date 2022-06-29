package com.study.login.web;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.common.util.CookieUtils;
import com.study.login.service.ILoginService;
import com.study.login.service.LoginServiceImpl;
import com.study.login.vo.UserVO;
import com.study.servlet.Handler;

public class Login implements Handler{
	ILoginService loginService = new LoginServiceImpl();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// /login/login.wow
		
		//get방식은 url을 직접 입력하거나, 위에 로그인버튼
		if(req.getMethod().equals("GET")) {
			
		String msg = req.getParameter("msg");
		String id = "";
		String checked = "";
		
		CookieUtils cookieUtils = new CookieUtils(req);
		if (cookieUtils.exists("SAVE_ID")) {
			id = cookieUtils.getValue("SAVE_ID");
			checked = "checked='checked'";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("id", id);
		req.setAttribute("checked", checked);
		return "login/login";
		}
		//post방식은 아이디, 비밀번호를 누르고 로그인을 하려는 버튼
		if(req.getMethod().equals("POST")) {
			//loginCheck
			// login.jsp에서 20행 (method="post")
			String id = req.getParameter("userId");
			String pw = req.getParameter("userPass");
			String save_id = req.getParameter("rememberMe");
			if (save_id == null) {
				CookieUtils cookieUtils = new CookieUtils(req);
				if (cookieUtils.exists("SAVE_ID")) {
					Cookie cookie = CookieUtils.createCookie("SAVE_ID", id, "/", 0);
					resp.addCookie(cookie);
				}
				save_id = "";
			}
			// post에서 한거
			// 1. responseSendRedirect 대신 return redirect:
			// 2. UserList대신 loginService
			// 3. HttpSession session = req.getSession();
			// req.getSession(true)==req.getSession();
			
			if ((id == null || id.isEmpty()) || (pw == null || pw.isEmpty())) {
				return "redirect:"+req.getContextPath()+"/login/login.wow?msg="+URLEncoder.encode("입력안했어요", "utf-8");
			} else {

				UserVO user = loginService.getUser(id);
				System.out.println(user);
				//loginService

				if (user == null) {
					return "redirect:"+req.getContextPath()+"/login/login.wow?msg="+URLEncoder.encode("id 혹은 비밀번호 틀림11", "utf-8");
				} else { //id맞았을때 
					if (user.getUserPass().equals(pw)) {//다 맞는경우
						if (save_id.equals("Y")) {
							resp.addCookie(CookieUtils.createCookie("SAVE_ID", id, "/", 3600 * 24 * 7));
						}
						/* response.addCookie(CookieUtils.createCookie("AUTH", id)); */
						HttpSession session=req.getSession();
						session.setAttribute("USER_INFO",user);
						//resp.sendRedirect("login.jsp");
						return "redirect:"+req.getContextPath()+"/index.jsp";
					} else {//  비번만 틀린경우
						return "redirect:"+req.getContextPath()+"/login/login.wow?msg="+URLEncoder.encode("id 혹은 비밀번호 틀림22", "utf-8");
					}

				}
			}
		}
		return null;
		
	}
}
