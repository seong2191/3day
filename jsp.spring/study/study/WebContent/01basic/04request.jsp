<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--request에서 중요한건 파라미터다  -->
<!-- <% %> 는 자바코드삽입이라는 뜻 -->
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
%>

파라미터 id값 : <%=id %> <br>
파라미터 pw값 : <%=pw %> <br>

<hr>
<a href="04aGet.jsp?p1=김성윤">a태그로 가는건 get방식</a>

<!-- 파라미터값주는거 -->
<!--get방식  -->
<!-- http://localhost:8080/study/01basic/04request.jsp?id=ksy2191&pw=1234 -->

<!-- post방식 -->
<!-- form action="" method=post -->

</body>
</html>