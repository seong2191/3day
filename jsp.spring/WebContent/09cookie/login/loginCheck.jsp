<%@page import="com.study.common.util.CookieUtils"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.study.login.vo.UserVO"%>
<%@page import="com.study.common.util.UserList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp"%>
<title></title>
</head>
<body>

	<%
		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");
		String rememberMe = request.getParameter("rememberMe");
		
		
		if (rememberMe != null) {
			response.addCookie(CookieUtils.createCookie("saveId", userId, 60*60*24*7));
		} else {
			response.addCookie(CookieUtils.createCookie("saveId", "", 0));
		}


		if (userId.isEmpty() || userPass.isEmpty()) { // 아이디 or 비밀번호가 하나라도 없을 경우
			response.sendRedirect("login.jsp?msg=" + URLEncoder.encode("id 또는 pw 입력해라", "UTF-8"));
		} else { // 둘다 있는 경우
			
			UserList userList = new UserList();
			UserVO user = userList.getUser(userId);
			if (user == null) {
				// id 틀림
				response.sendRedirect("login.jsp?msg=" + URLEncoder.encode("id 또는 pw가 틀렷다.", "UTF-8"));
			} else {
				// id 맞음
				if (user.getUserPass().equals(userPass)) { // pw 맞음
					response.addCookie(new Cookie("AUTH", userId));
					response.sendRedirect("login.jsp");
				}else{ //pw 틀림
					response.sendRedirect("login.jsp?msg=" + URLEncoder.encode("id와 pw를 모두 입력해라", "UTF-8"));
				}
			}

		}
	%>






</body>
</html>