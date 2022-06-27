<%@page import="com.study.common.util.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/inc/top.jsp"%>
	
	<%
		String msg = request.getParameter("msg");
	if(msg !=null){
		out.print(msg);
	}
	%>
	
	<%
	CookieUtils utils = new CookieUtils(request);
	String saveid = "";
	String rememberid = "";
	if (utils.exists("saveId")) { // 저장된 ID가 있을 경우
		saveid = utils.getValue("saveId"); // 해당 아이디를 아이디 입력란에 미리 입력
		rememberid = "checked"; // 아이디 기억하기 체크박스도 체크
	}

	if (!utils.exists("AUTH")) {
	%>
	<div class="container">
		<form action="loginCheck.jsp" class="loginForm">
			<h2>로그인</h2>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userId"
							class="form-control input-sm" value=<%=saveid %>></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="userPass"
							class="form-control input-sm"></td>
					</tr>
					<tr>
						<td colspan="2"><label><input type="checkbox"
								name="rememberMe" <%=rememberid %> >ID 기억하기</label></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-primary btn-sm pull-right">로그인</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<!-- container -->
	<%
		}else{
	%>
		로그인 중
	<a href="logout.jsp" class="btn btn-success btn-sm">로그아웃</a>
	<%
		}
	%>
	
</body>
</html>