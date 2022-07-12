<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/inc/header.jsp"%>
<link rel="shortcut icon" href="../resources/images/favicon.ico">
<title>회원가입 2단계</title>
<style type="text/css">
	.form-group-sm span{
		color: red;
		font-size: 10px;
	}
</style>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp"%>
<div class="container">
<form:form modelAttribute="member" action="step3.wow" method="post">
<div class="row col-md-8 col-md-offset-2">
	<div class="page-header">
		<h3>회원가입 2단계</h3>
	</div>
	<table class="table" >
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<th>ID</th>
			<td>
				<form:input path="memId" cssClass="form-control input-sm" />
				<form:errors path="memId"></form:errors>			    
				<button type="button" id="idCheck">중복확인</button>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<form:password path="memPass" cssClass="form-control input-sm" />
				<form:errors path="memPass"></form:errors>	
			</td>
		</tr>
		
		<tr class="form-group-sm">
			<th>회원명</th>
			<td>
				<form:input path="memName" cssClass="form-control input-sm" />
				<form:errors path="memName"></form:errors>		
			</td>
		</tr>
		<tr class="form-group-sm">
			<th>이메일</th>
			<td>
				<form:input path="memMail" cssClass="form-control input-sm" />
				<form:errors path="memMail"></form:errors>		
			</td>
		</tr>		
		<tr>
			<td colspan="2">
				<div class="pull-left" >
					<a href="cancel" class="btn btn-sm btn-default" >
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						&nbsp;&nbsp;취 소
					</a>
				</div>
				<div class="pull-right">
					<button type="submit" class="btn btn-sm btn-primary" >
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						&nbsp;&nbsp;다 음
					</button>
				</div>
			</td>
		</tr>	
	</table>
</div>
	</form:form>
</div> <!-- END : 메인 콘텐츠  컨테이너  -->
</body>
<script type="text/javascript">
var isIdChecked=false;
	$(document).ready(function(){
		$("#idCheck").on("click", function(e){
			e.preventDefault();
			var id = $("input[name='memId']").val();
			$.ajax({
				url : "<c:url value='/join/idCheck.wow' />"
				,data : {"id": id}
				,success : function(data){
					if(data=='success'){
						alert("사용가능");
						isIdChecked=true;
					} 
					if(data=='fail'){
						alert("사용불가");
						isIdChecked=false;
					}
				}
				,error : function(req,st,err){
					alert(req);
				}
			});
		}); //idCheck
		
		// 다음버튼(form submit) 눌렀을때 idCheck를 했다면 넘어가도되고
		// 안했다면 alert("idCheck 안했다")
		// submit 바로 하면 안되니까 e.preventDefault()
		// submit 해도 되면 submit()함수
		
		$("button[type=submit]").click(function(e) {
            e.preventDefault();
            if(isIdChecked){
                $("form").submit();
            }else {
                alert("id 중복체크를 해주세요");
    	        }
	       });// 다음버튼
		 $("input[name='memId']").on("change", function(e){
        isIdChecked=false;
    	});//memId값 바뀔 때마다 
		
	}); // document
</script>
</html>