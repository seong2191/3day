<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border= 1>
<tbody>


	<%
	
		for(int i=1; i<10 ; i++){
		out.print("<tr>");
	
		
		for(int j=2; j<10; j++){
			out.print("<td>"+j+"x"+i+"="+i*j+"</td>");
		}
		
		out.print("</tr>");
		}
	%>

</tbody>


</table>

</body>
</html>