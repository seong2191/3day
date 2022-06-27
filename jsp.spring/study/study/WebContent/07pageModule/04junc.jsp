<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
	String idol = request.getParameter("idol");
	String viewPage="";
	List<String> memberList = new ArrayList<>();
	if("aoa".equals(idol)){
		viewPage="04aoa.jsp";
		memberList.add("설현");
		memberList.add("기타");
	}else if(idol.equals("bts")){
		viewPage="04bts.jsp";
		memberList.add("뷔");
		memberList.add("정곡");
		memberList.add("랩몬스터");
		memberList.add("기타");
	}
	request.setAttribute("memberList", memberList);
%>
	여기다 아무말가능
	중요한건 aoa랑 bts 화면에 보여줄때 화면 양식이 다르면 jsp파일을 따로 만들어야한다.
	(화면 양식이 같으면 굳이 jsp파일을 2개 안만들고 1개만 만들어도 된다.)
	
	form.jsp에서 뭘 선택했냐에 따라 aoa.jsp 또는 bts.jsp로 이동하도록 해야합니다.
	forward되도 역시 같은 request를 공유한다.
	<jsp:forward page="<%=viewPage %>"></jsp:forward>

</body>
</html>