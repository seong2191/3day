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
EL은 기본적으로 출력이 된다.
EL도 언어라서 변수선언이 된다.
??? 변수 선언했는데 화면에 출력이 됩니다 ㅜ머ㅣㅇㅁ?
변수 선언만하고 화면에 출력은 안하고 싶어요...
; 앞에는 출력안함
기본적으로 EL은 빈값이 있으면 안돼요 <%--${}은 에러남 --%>
<br>
${a="구스구스덕" ; ""}
<br>
${a }
</body>
</html>