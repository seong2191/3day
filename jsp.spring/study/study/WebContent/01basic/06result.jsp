<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 한글로 입력된 파라미터값을 출력하기위해 -->
<!-- 하는일은 디코딩인데 명칭은 인코딩이라.. 띠용  -->
<% request.setCharacterEncoding("utf-8"); %> 
<!-- 톰캣은 get방식일 때 자동으로 decoding(디코딩)해줌 -->

<!-- request.setCharacterEncoding은 파라미터 디코딩
	  contentType의 charSet은 response에 보낼 때 인코딩 -->
<!-- 습관적으로 request.setCharacterEncoding(utf-8),
	 charSet : UTF-8 -->
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String kor = request.getParameter("한글");
	String eng = request.getParameter("eng");
%>
한글 : <%=kor %> <br>
eng : <%=eng %>

</body>
</html>