<%@page import="java.util.Arrays"%>
<%@page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% request.setCharacterEncoding("utf-8"); %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] hobbies = request.getParameterValues("hobby");
	String[] names = request.getParameterValues("name");
	/* 위(15행)와 같다names[0] = request.getParameter("name");*/
%>
<h1>모든 파라미터 한번에 Map으로 보기 set for문반복</h1>
<%
	Map<String, String[]> paramMap = request.getParameterMap();
	/*[ 
	 "name" : {"입력한 값"},
	 "age" : {"10"},
	 "hobby" : {"soccer", "basket", "piano", "coding"}
	 ] */
	Set<String> keySet = paramMap.keySet();
	// {"name", "age", "hobby"}
	for(String key : keySet){
		/* out.print(key + "<br>"); */
		/* paramMap.get(key + " : " + paramMap.get(key) + ""); */
		out.print(key + " : ");
		String[] values = paramMap.get(key);
		for(String value : values){
			out.print(value + ",");
		}
		out.print("<br>");
	}
%>
<h1>파라미터 한번에, SET iterator</h1>
<%
	Iterator<String> iterator = keySet.iterator();
	while(iterator.hasNext()){
		String key = iterator.next();
		out.print(key + " : ");
		String[] values = paramMap.get(key);
		for(String value : values){
			out.print(value + ",");
		}
		out.print("<br>");
	}
%>

<%
	// Entry는 맵의 인터페이스
	//map의 반복은 set의 반복이다
	Set<Map.Entry<String, String[]>> entrySet = paramMap.entrySet();
	for(Map.Entry < String,String[]> entry : entrySet){
		String key = entry.getKey(); // name, age, hobby
		String[] values = entry.getValue(); // {}, {}, {,,,}
	}
	//Entry는 key, value로 이루어져있다.
%>


</body>
</html>