
<%@page import="com.study.member.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp"%>
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:study");

		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT																");
		sb.append("    mem_id														");
		sb.append("    , mem_pass      , mem_name									");
		sb.append("	 , TO_CHAR(mem_bir,'YYYY-MM-dd') AS mem_bir				");
		sb.append("    , mem_zip       , mem_add1      , mem_add2				");
		sb.append("    , mem_hp        , mem_mail      							");
		sb.append("    , DECODE(MEM_JOB, 'JB01', '주부', 'JB02', '은행원', 'JB03', '공무원', 'JB04', '축산업', 'JB05', '회사원', 'JB06', '농업', 'JB07', '자영업', 'JB08', '학생', 'JB09', '교사', '알 수 없음') AS MEM_JOB				");
		sb.append("    , DECODE(MEM_HOBBY, 'HB01', '서예', 'HB02', '장기', 'HB03', '수영', 'HB04', '독서', 'HB05', '당구', 'HB06', '바둑', 'HB07', '볼링', 'HB08', '스키', 'HB09', '만화', 'HB10', '낚시', 'HB11', '영화감상', 'HB12', '등산', 'HB13', '개그', 'HB14', '카레이싱', '알 수 없음') AS MEM_HOBBY   					  			");
		sb.append("    , mem_mileage   , mem_del_yn								");
		sb.append(" FROM																");
		sb.append("    member														");
		sb.append(" ORDER BY REGEXP_REPLACE(mem_id, '[0-9]') , to_number(REGEXP_REPLACE(mem_id, '[^0-9]')) ");
		
		pstmt=conn.prepareStatement(sb.toString());
		
		rs = pstmt.executeQuery();
		
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
		if(pstmt !=null) {try{ pstmt.close();}catch(Exception e){}}
		if(conn !=null) {try{ conn.close();}catch(Exception e){}}
	}
%>



 <div class="container">	
	<h3>회원목록</h3>		
	<div>
		<a href="memberForm.jsp" class="btn btn-primary btn-sm pull-right">회원 등록</a>
	</div>
	<table class="table table-striped table-bordered">
	<caption class="hidden">회원목록 조회</caption>
	<colgroup>
		<col style="width: 15%" />
		<col />
		<col style="width: 20%" />
		<col style="width: 20%" />
		<col style="width: 15%" />
		<col style="width: 15%" />
	</colgroup>
	<thead>
		<tr>
			<th>ID</th>
			<th>회원명</th>
			<th>HP</th>
			<th>생일</th>
			<th>직업</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${MemberList }" var="MemberList">
			<tr>
				<td>${MemberList.memId }</td>
				<td><a href="memberView.jsp?memId=${MemberList.memId }">
				${MemberList.memName }</a></td>
				<td>${MemberList.memHp }</td>
				<td>${MemberList.memBir }</td>
				<td>${MemberList.memJob }</td>
				<td>${MemberList.memMileage }</td>
			</tr>
		</c:forEach>
	</tbody>			
	</table>
</div>

</body>
</html>