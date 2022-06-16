<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 사진이 먼저오냐 memberList가 먼저오냐 차이 -->
<%
	List<String> MemberList = (List<String>)request.getAttribute("memberList");
	out.print("<ul>");
	for(String member : MemberList){
		out.print("<li>" + member);
	}
%>

<img alt="사진" src="bts.png" width="50px" height="50px"><br>
<img alt="사진" src="/study/07pageModule/bts.png" width="50px" height="50px"><br>
<img alt="사진" src="<%=request.getContextPath() %>/07pageModule/bts.png" width="50px" height="50px">



</body>
</html>