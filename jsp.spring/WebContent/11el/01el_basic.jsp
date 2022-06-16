<%@page import="com.study.common.vo.ProdVO"%>
<%@page import="com.study.common.util.ProductList"%>
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
스크립트 언어 : 응용 소프트웨어 애플리케이션 언어를 도와주는 언어

JSP : JAVA에서 out.print()하기 힘들어서 나온거
EL :  JSP에서 JAVA를 도와주기 위해 나온 언어
	   JSP태그를 사용하다 보면 태그 value=""에 객체가 들어감
		<%-- <jsp:forward page="<%=viewPage %>"></jsp:forward> --%>
		값을 넣을 때 스크립트릿 쓰기 힘들다.
		
EL이 가장 많이 쓰이는건 기본 객체(application, 기본3개(request, response, session)에 있는 속성)에 있는 속성을 출력하는 용도
EL은 단독으로 쓰이기 보다는 JSTL과 함께 쓰임.
EL 탐색 : request-session 순서로 
		  (EL로 prod1이라고 썼을 때, request 속성 전부 조사 - prod1이 있나 조사, 있으면 출력)
		  						  , 없으면 session의 속성 전부 조사 - prod1이 있나 조사, 있으면 출력
		  						  ...
		  						  기본 객체 모두 prod1 속성이 없으면 출력안함
		  						  
결론 :
1. 화면에 출력안된다. 값이 안나온다 => 기본 객체 속성에 저장한 이름이랑 다름.
2. 필드 이름이랑 잘못썼을 때 (propertyNotFoundException)
3. " "

*EL의 우선순위가 좀 높다.  주석이랑 사용할때는 우선순위가 높은 <!-- ${a} -->를 쓰자
<hr>
<%
	List<ProdVO> prodList = ProductList.getProductList();
	ProdVO prod1 = prodList.get(0);
	request.setAttribute("prodList", prodList);
	session.setAttribute("prod1", prod1);
%>
${prodList }
<br>
${prod1.prodId }
<hr>
${sadasdasd } 6월 13일
<br>
${prod1.abc }

</body>
</html>