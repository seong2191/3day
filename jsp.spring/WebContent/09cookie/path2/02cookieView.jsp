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
Cookie[] cookies = request.getCookies();
		//배열을 return 하는 메소드는 조심해야 될거
		// null을 return 하는지, 길이가 0인 배열을 return하는지
		if(cookies != null){
			for(Cookie cookie : cookies){
				out.print(cookie.getName() + " : " + cookie.getValue());
				out.print("<br>");
			}
		}
%>

</body>
</html>