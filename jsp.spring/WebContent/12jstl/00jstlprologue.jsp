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
	int score = Integer.parseInt("100"); // request.getParameter;
	if(score==100){
		out.print("100점");
	}
	
	// 복잡한 태그일때
	if(score==100){
%>
	무언가 복잡한 태그
	<a href="score100.jsp">100점들만 가는 사이트</a>
	<h1>축하</h1>
	<table border="1">
		<thead></thead>
		<tbody>
			<tr> <td></td> </tr>
			
		</tbody>
	</table>
	<%
	}
	%>
	
	<if boolean="true">무언가 복잡한 태그</if>
	이런것들을 지원해주는 태그들을 모아놓은 library가 jstl입니다.
	(jstl은 library다 jsp standard tag library)
	
</body>
</html>