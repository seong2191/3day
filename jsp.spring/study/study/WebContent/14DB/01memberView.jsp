<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.study.member.vo.MemberVO"%>
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
	String memId = request.getParameter("memId");
	//드라이버 로딩, 연결, 실행, 종료
	Class.forName("oracle.jdbc.driver.OracleDriver"); // Class.forName 런타임동적로딩
	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	try{
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jsp", "oracle");
		
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT											");
		sb.append("     mem_id  , mem_pass  , mem_name			");
		sb.append("     , mem_bir   , mem_zip   , mem_add1		");
		sb.append("     , mem_add2  , mem_hp    , mem_mail		");
		sb.append("     , mem_job   , mem_hobby , mem_mileage	");
		sb.append("     , mem_del_yn								");
		sb.append(" FROM												");
		sb.append("     member										");
		sb.append(" WHERE mem_id= ?									");
		
		pstmt=conn.prepareStatement(sb.toString());
		// 쿼리문이 ? 포함된 쿼리문.		?를 처리하고나서 executeQuery()해야함
				
		pstmt.setString(1, memId); // ?처리할때 ''알아서 처리해줍니다.
		rs = pstmt.executeQuery();
		
		// rs가 1줄
		if(rs.next()){
			MemberVO member = new MemberVO();
			// set하는ㄱ ㅓ 복사
			member.setMemId(rs.getString("mem_id"));
			member.setMemPass(rs.getString("mem_pass"));
			member.setMemName(rs.getString("mem_name"));
			member.setMemBir(rs.getString("mem_bir"));
			member.setMemZip(rs.getString("mem_zip"));
			member.setMemAdd1(rs.getString("mem_add1"));
			member.setMemAdd2(rs.getString("mem_add2"));
			member.setMemHp(rs.getString("mem_hp"));
			member.setMemMail(rs.getString("mem_mail"));
			member.setMemJob(rs.getString("mem_job"));
			member.setMemHobby(rs.getString("mem_hobby"));
			member.setMemMileage(rs.getInt("mem_mileage"));
			member.setMemDelYn(rs.getString("mem_del_yn"));
			
			request.setAttribute("member", member);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		// 연결종료
		if(rs !=null) {try{ rs.close();}catch(Exception e){}}
		if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
		if(conn !=null) {try{ conn.close();}catch(Exception e){}}
	}
%>

<table class="table table-striped">
	<tr>
		<td>아이디</td>
		<td>${member.memId }</td>
	</tr>
	<tr>
		<td>비밀번호 안보여줌원래</td>
		<td>${member.memPass }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${member.memName }</td>
	</tr>
	<tr>
		<td>생일</td>
		<td>${member.memBir }</td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td>${member.memZip }</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>${member.memAdd1 }</td>
	</tr>
	<tr>
		<td>상세주소</td>
		<td>${member.memAdd2 }</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>${member.memHp }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${member.memMail }</td>
	</tr>
	<tr>
		<td>직업</td>
		<td>${member.memJob }</td>
	</tr>
	<tr>
		<td>취미</td>
		<td>${member.memHobby }</td>
	</tr>
	<tr>
		<td>마일리지</td>
		<td>${member.memMileage }</td>
	</tr>
	<tr>
		<td>삭제여부</td>
		<td>${member.memDelYn }</td>
	</tr>
	
	

	

</table>

</body>
</html>