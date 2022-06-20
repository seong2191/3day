
<%@page import="com.study.free.service.FreeBoardServiceImpl"%>
<%@page import="com.study.free.service.IFreeBoardService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.study.free.vo.FreeBoardVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/inc/top.jsp"%>


<%
	IFreeBoardService freeBoardService = new FreeBoardServiceImpl();
	List<FreeBoardVO> freeBoardList = freeBoardService.getBoardList();
	request.setAttribute("freeBoardList", freeBoardList);
	
	// 밑에있는 쿼리 실행코드는 dao로 갔음
%>



<div class="container">
	<div class="page-header">
		<h3>자유게시판 - <small>글 목록</small></h3>
	</div>
<div class="row">
    <div class="col-sm-2 col-sm-offset-10 text-right" style="margin-bottom: 5px;" >
        <a href="freeForm.jsp" class="btn btn-primary btn-sm"> 
        	<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
        	&nbsp;새글쓰기
		</a>
    </div>
</div>
	<table class="table table-striped table-bordered table-hover">
	<colgroup>
		<col width="10%" />
		<col width="15%" />
		<col />
		<col width="10%" />
		<col width="15%" />
		<col width="10%" />
	</colgroup>
	<thead>
		<tr>
			<th>글번호</th>
			<th>분류</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
	</thead>	
	<tbody>
		<c:forEach items="${freeBoardList }" var="freeBoardList">
			<tr class="text-center">
				<td>${freeBoardList.boNo }</td>
				<td>${freeBoardList.boCategory }</td>
				<td class="text-left">
					<a href="freeView.jsp?boNo=${freeBoardList.boNo }">
						${freeBoardList.boTitle }
					</a>
				</td>
				<td>${freeBoardList.boWriter }</td>
				<td>${freeBoardList.boRegDate }</td>
				<td>${freeBoardList.boHit }</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</div><!-- container --> 
</body>
</html>






