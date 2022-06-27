<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	String age30 = "김비비, 김지지, 김디디, 김기기";
	request.setAttribute("age30", age30);	
%>
<c:forTokens items="${age30 }" delims="," var="a">
	<h2>${a }</h2>

</c:forTokens>

</body>
</html>