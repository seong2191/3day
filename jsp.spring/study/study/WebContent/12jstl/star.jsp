<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String star ="*";
%>

<c:forEach begin="1" end="5" var="i">
	<%=star %>
	<br>
	<% star+= "*";%>
</c:forEach> 


<hr><hr><hr>

<%
	String blank = "&nbsp;";
	star = "*";
%>

<c:forEach begin="1" end="5" var="i">
	<c:forEach begin="1" end="${i+1 }" var="j">
	<%=blank + blank%>
	</c:forEach>
	
	<c:forEach begin="1" end="${6-i }" var="j">
	<%=star %>
	</c:forEach>
	

	<br>

</c:forEach>

<hr><hr><hr>


<%
	String star1 = "*";
%>
<c:forEach begin="0" end="4" var="i">
	<c:forEach begin="0" end="${5-i }" var="j">
	<%=blank + blank %>
	</c:forEach>
	
	<c:forEach begin="1" end="${i*2+1 }" var="j">
	<%=star1 %>
	</c:forEach>
	<br>

</c:forEach>







</body>
</html>