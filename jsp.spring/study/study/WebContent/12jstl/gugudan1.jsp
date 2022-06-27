<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	
	<c:forEach begin="1" end="9" var="i">
	<tr>
		<c:forEach begin="2" end="9" var="j">
			<td>${j } x ${i } = ${j*i }</td>
		</c:forEach>
	</tr>		
	</c:forEach>
		



</table>


</body>
</html>