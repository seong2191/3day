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
<%-- <> <=, =>, ==, ! =, !,   emptry --%>
<pre>
	${10 ==5 }		${10 eq
	${ 10!= 5 } ${10 not eq 5 }
	${10 <5 } ${10 lt 5 }
	${10 > 5 } ${10 gt 5 }
	${10 <= 5 } ${10 le 5 }
	${10 >= 5 } ${10 ge 5 }


</pre>

</body>
</html>