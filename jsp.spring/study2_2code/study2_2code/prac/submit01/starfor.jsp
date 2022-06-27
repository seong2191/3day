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
	String star = "*";
	for(int i = 0; i <5 ;i++ ){
		out.print(star+"<br>");
		star+="*";
	}
	%>
	<hr><hr><hr>
	<%
	String blank = "&nbsp;";
	star = "*";
	for (int i = 5; i >= 1; i--) {
		for (int j = 1; j <= 5-i; j++) {
			out.print(blank+blank);
		}
		for (int j = 1; j < i+1; j++) {
			out.print(star);
		}
		out.print("<br>");
	}
%>	
	<hr><hr><hr>
	
	<%
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j <= 5-i; j++) {
			out.print(blank+blank);
		}
		for (int j = 1; j <= i*2+1; j++) {
			out.print(star);
		}
		out.print("<br>");
	}
	%>
	
	

</body>
</html>