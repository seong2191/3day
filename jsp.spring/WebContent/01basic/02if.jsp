<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//http://localhost:8080/study/01basic/02if.jsp
	//		?ch=HanChangHee
	String ch= request.getParameter("ch");
	/* if(ch==null){
		out.print("파라미터가 없어요");
	}else{
		out.print("ch: " + ch);
	} */
%>

<%
	if(ch==null){
%>
	파라미터가 없어요
	<table border="1"><tr><td>abasd</td></tr></table>
	<a href="aaa">asdasd</a>
<%
	}else{
%>
	ch : <%=ch %>
	<!--out.print(ch); 대신  =ch  -->
<%
	}
%>

</body>
</html>