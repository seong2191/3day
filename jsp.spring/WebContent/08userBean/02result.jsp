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
<jsp:useBean id="user" class="com.study.login.vo.UserVO" scope="request"></jsp:useBean>

<%=user %><hr>

<%-- <jsp:setProperty property="userId" name="user"/>
<%
	// 위와 동일
	user.setUserId(request.getParameter("userId"));
%>
<jsp:setProperty property="userName" name="user"/>
<jsp:setProperty property="userPass" name="user"/>
<jsp:setProperty property="userRole" name="user"/> --%>

<!-- 모든 것 -->
<jsp:setProperty property="*" name="user"/>
<%=user %>

</body>
</html>