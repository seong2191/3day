<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%request.setCharacterEncoding("utf-8"); %>
<%@ include file="/WEB-INF/inc/header.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top.jsp" %>

<%
	Cookie cookie = new Cookie("next","it");
	// 기본적으로 maxAge = -1;
	cookie.setMaxAge(10); //0 이상으로 설정하면 브라우저가 꺼져도 남아있음
							 // 단, 해당 시간이 지나면 무조건 사라짐(30초)
							 // 초단위로 계산식을 넣어줌 60*60*24*7은 1주일
	response.addCookie(cookie);
%>

</body>
</html>