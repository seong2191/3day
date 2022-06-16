<%@page import="java.util.ArrayList"%>
<%@page import="com.study.free.vo.FreeBoardVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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

<%
	//02cocoj (one Connection one job)
	Class.forName("oracle.jdbc.driver.OracleDriver"); // Class.forName 런타임동적로딩
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	long startTime=System.currentTimeMillis();
	try{
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jsp", "oracle");
		// 2번 연결
		
		// 3번 수행
		stmt=conn.createStatement(); // 쿼리수행 객체
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT																");
		sb.append("      bo_no,        bo_title,     bo_category  					");
		sb.append("    , bo_writer, 	bo_pass,      bo_content    				");
		sb.append("    , bo_hit															");
		sb.append("    , to_char(bo_reg_date,'YYYY-MM-dd') AS bo_reg_date			");
		sb.append("    , to_char(bo_mod_date,'YYYY-MM-dd') AS bo_mod_date			");
		sb.append("    , bo_del_yn														");
		sb.append(" FROM																	");
		sb.append("    free_board														");
		rs = stmt.executeQuery(sb.toString()); //쿼리수행, rs는 쿼리 수행 결과 저장 객체(rs는 select에만)
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		// 연결종료
		if(rs !=null) {try{ rs.close();}catch(Exception e){}}
		if(stmt !=null) {try{ rs.close();}catch(Exception e){}}
		if(conn !=null) {try{ rs.close();}catch(Exception e){}}
	}
	long endTime=System.currentTimeMillis();
%>
걸린시간: <%=endTime-startTime %>
</body>
</html>