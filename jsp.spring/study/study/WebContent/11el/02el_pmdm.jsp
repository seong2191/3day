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
EL도 언어. EL사용중에는 EL이라는 언어의 문법을 따름.
사칙연산은 기본적으로 산술연산만 지원
<br>
<pre>
${"10"+1 }	"10"을 long으로 변환 후 10L+1L= 11L
${"10.1" +2 }   "10.1"을 Double로 변환 후 연산
플러스 마이너스 곱하기 나누기
</pre>









</body>
</html>