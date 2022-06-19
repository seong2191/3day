<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
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

멤버리스트에서는 id, 이름, 생일, 직업, 취미만 보여주기
view에서는 전부보여주기
리스트에서 view갈때 이름을 클릭하도록
파라미터이름은 memId

<%
	// 1. 드라이버 로드 (oracle)
	// 2. 실제 DB에 연결
	// 3. 쿼리수행
	// 4. 연결종료
	
	Class.forName("oracle.jdbc.driver.OracleDriver"); // Class.forName 런타임동적로딩
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	try{
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jsp", "oracle");
		// 2번 연결
		
		// 3번 수행
		stmt=conn.createStatement(); // 쿼리수행 객체
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT											");
		sb.append("     mem_id  , mem_pass  , mem_name			");
		sb.append("     , mem_bir   , mem_zip   , mem_add1		");
		sb.append("     , mem_add2  , mem_hp    , mem_mail		");
		sb.append("     , mem_job   , mem_hobby , mem_mileage	");
		sb.append("     , mem_del_yn								");
		sb.append(" FROM												");
		sb.append("     member										");
		
		rs = stmt.executeQuery(sb.toString()); //쿼리수행, rs는 쿼리 수행 결과 저장 객체(rs는 select에만)
		List<MemberVO> MemberList = new ArrayList<>();
		while(rs.next()){
			MemberVO member = new MemberVO();
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
			MemberList.add(member);
		}
		request.setAttribute("MemberList", MemberList);
			
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		// 연결종료
		if(rs !=null) {try{ rs.close();}catch(Exception e){}}
		if(stmt !=null) {try{ stmt.close();}catch(Exception e){}}
		if(conn !=null) {try{ conn.close();}catch(Exception e){}}
	}
%>

<table class="table table-striped">
	<thead>
		<tr>
			<td>id</td>
			<td>이름</td>
			<td>생일</td>
			<td>직업</td>
			<td>취미</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${MemberList }" var="MemberList">
			<tr>
				<td><a href="01memberView.jsp?memId=${MemberList.memId }">${MemberList.memName }
					</a>
				</td>
				<td>${MemberList.memName }</td>
				<td>${MemberList.memBir }</td>
				<td>${MemberList.memJob }</td>
				<td>${MemberList.memHobby }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>