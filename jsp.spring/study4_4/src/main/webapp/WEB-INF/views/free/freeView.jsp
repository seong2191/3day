
<%@page import="com.study.exception.BizNotEffectedException"%>
<%@page import="com.study.exception.BizNotFoundException"%>
<%@page import="com.study.free.service.FreeBoardServiceImpl"%>
<%@page import="com.study.free.service.IFreeBoardService"%>
<%@page import="com.study.free.vo.FreeBoardVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<title>자유게시판 - 글 보기</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/top.jsp"%>

	


		<div class="container">
			<div class="page-header">
				<h3>
					자유게시판 - <small>글 보기</small>
				</h3>
			</div>
			<table class="table table-striped table-bordered">
				<tbody>
					<tr>
						<th>글번호</th>
						<td>${freeBoard.boNo }</td>
					</tr>
					<tr>
						<th>글제목</th>
						<td>${freeBoard.boTitle }</td>
					</tr>
					<tr>
						<th>글분류</th>
						<td>${freeBoard.boCategory }</td>
					</tr>
					<tr>
						<th>작성자명</th>
						<td>${freeBoard.boWriter }</td>
					</tr>
					<!-- 비밀번호는 보여주지 않음  -->
					<tr>
						<th>내용</th>
						<td>${freeBoard.boContent }</td>
					</tr>
					
					<!-- 주석처리말고 지워요<tr>
						<th>등록자 IP</th>
						<td>IP</td>
					</tr> -->
					
					<tr>
						<th>조회수</th>
						<td>${freeBoard.boHit }</td>
					</tr>
					<tr>
						<th>최근등록일자</th>
						<td>
							${freeBoard.boModDate ne null 
							? freeBoard.boModDate
							: freeBoard.boRegDate }
						</td>
					</tr>
					<tr>
						<th>삭제여부</th>
						<td>${freeBoard.boDelYn }</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="pull-left">
								<a href="freeList.wow" class="btn btn-default btn-sm"> <span class="glyphicon glyphicon-list" aria-hidden="true"></span> &nbsp;&nbsp;목록
								</a>
							</div>
							<div class="pull-right">
								<a href="freeEdit.wow?boNo=${freeBoard.boNo }" class="btn btn-success btn-sm"> <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> &nbsp;&nbsp;수정
								</a>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- container -->
		
		<div class="container">
		<!-- reply container -->
		<!-- // START : 댓글 등록 영역  -->
		<div class="panel panel-default">
			<div class="panel-body form-horizontal">
				<form name="frm_reply" action="<c:url value='/reply/replyRegist' />"
					method="post" onclick="return false;">
					<input type="hidden" name="reParentNo" value="${freeBoard.boNo}">
					<input type="hidden" name="reCategory" value="FREE"> <input
						type="hidden" name="reMemId" value="${USER_INFO.userId }">  
					<input type="hidden" name="reIp"
						value="<%=request.getRemoteAddr()%>">
					<div class="form-group">
						<label class="col-sm-2  control-label">댓글</label>
						<div class="col-sm-8">
							<textarea rows="3" name="reContent" class="form-control" 
							readonly='readonly'></textarea>
						</div>
						<div class="col-sm-2">
							<button id="btn_reply_regist" type="button"
								class="btn btn-sm btn-info">등록</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- // END : 댓글 등록 영역  -->


		<!-- // START : 댓글 목록 영역  -->
		<div id="id_reply_list_area">
			<div class="row">
				<div class="col-sm-2 text-right">홍길동</div>
				<div class="col-sm-6">
					<pre>내용</pre>
				</div>
				<div class="col-sm-2">12/30 23:45</div>
				<div class="col-sm-2">
					<button name="btn_reply_edit" type="button"
						class=" btn btn-sm btn-info" onclick="fn_modify()">수정</button>
					<button name="btn_reply_delete" type="button"
						class="btn btn-sm btn-danger">삭제</button>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2 text-right">그댄 먼곳만 보네요</div>
				<div class="col-sm-6">
					<pre> 롤링롤링롤링롤링</pre>
				</div>
				<div class="col-sm-2">11/25 12:45</div>
				<div class="col-sm-2"></div>
			</div>
		</div>

		<div class="row text-center" id="id_reply_list_more">
			<a id="btn_reply_list_more"
				class="btn btn-sm btn-default col-sm-10 col-sm-offset-1"> <span
				class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
				더보기
			</a>
		</div>
		<!-- // END : 댓글 목록 영역  -->


		<!-- START : 댓글 수정용 Modal -->
		<div class="modal fade" id="id_reply_edit_modal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<form name="frm_reply_edit"
						action="<c:url value='/reply/replyModify' />" method="post"
						onclick="return false;">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">×</button>
							<h4 class="modal-title">댓글수정</h4>
						</div>
						<div class="modal-body">
							<input type="hidden" name="reNo" value="">
							<textarea rows="3" name="reContent" class="form-control"></textarea>
							<input type="hidden" name="reMemId" value="${USER_INFO.userId }">
						</div>
						<div class="modal-footer">
							<button id="btn_reply_modify" type="button"
								class="btn btn-sm btn-info">저장</button>
							<button type="button" class="btn btn-default btn-sm"
								data-dismiss="modal">닫기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- END : 댓글 수정용 Modal -->

	</div>
	<!-- reply container -->

</body>

<script type="text/javascript">
	// 댓글 데이터를 딱 10개만 가지고 오도록 하는 파라미터 모음
    var params={"curPage":1, "rowSizePerPage" : 10
            ,"reCategory" : "FREE", "reParentNo": ${freeBoard.boNo} };
            
	//ajax 요청해서 댓글리스트를 받아오는 함수.
   function fn_reply_list(){
        $.ajax({
              url:"<c:url value='/reply/replyList.wow'/>"
        	, data:params
        	, success: function(data) {
        		var list=data.result;
				console.log("ajax : ", data);
				replyresult = "";
				$.each(list, function(i, elt) {
					//elt가 replyVO 1개 list는 List<ReplyVO>
					replyresult += "<div class='row'>";
					replyresult += "<div class='col-sm-2 text-right'>"+elt.reMemName+"</div>";
					replyresult += "<div class='col-sm-6'><pre>"+elt.reContent+"</pre></div>";
					replyresult += "<div class='col-sm-2'>"+elt.reRegDate+"</div>";
					replyresult += "<div class='col-sm-2'></div>";
					replyresult += "</div>";
				});
				$("#id_reply_list_area").append(replyresult);
			}
            ,error: function (e) {
                alert("댓글 목록을 가져오는데 실패했습니다.");
                console.log(e)
            }
        });
    }//function fn_reply_list

    $(document).ready(function(){ //documnet가 준비될 때 
    		fn_reply_list();
    
    
        //더보기 버튼
        $("#id_reply_list_more").on("click",function(e){
			//fn_reply_list에서 마지막에 curPage=2로 바꿔줍니다. 
            //그래서 그냥 fn_reply_list()하면 다음 댓글 10개 가져옵니다.
		});

        //등록버튼
        $("#btn_reply_regist").on("click",function(e){
			// form태그안에 input hidden으로 필요한거 넣기
            //가장가까운 form찾은 후 ajax 호출(data는 form.serialize(), )
		    //성공 : 등록 글 내용부분 지우기,  댓글영역초기화( list_area.html('), curPage=1, fn_reply_list)
            //실패 : error : req.status==401이면 login으로   location.href
        });//등록버튼

        
      	//수정버튼 : 댓글 영역안에 있는 수정버튼만  이벤트 등록 
        $("#id_reply_list_area").on("click", 'button[name="btn_reply_edit"]'
                ,function(e){
           //현재 버튼의 상위 div(한개 댓글) 찾기
 	       //div에서 현재 댓글 내용을 modal에 있는 textarea에 복사
	       //div태그의 data-re-no 값을 modal에 있는 input name="reNo" 태그의 value값에 복사 
           //복사 후   .modal('show')
        });//수정버튼


        //모달창 저장 버튼
        $("#btn_reply_modify").on("click", function(e){
			//가장 가까운form 찾기 , ajax 호출(  data:form.serialzie()
            // 성공 :  modal찾은 후 modal('hide')
            // 현재 모달에 있는 reNo, reContent 찾기
            // 댓글영역에서 re_no에 해당하는 댓글 찾은 후 안의 내용 re_content로 변경
        });//모달창 저장버튼


        //삭제버튼
        $("#id_reply_list_area").on("click", 'button[name="btn_reply_delete"]'
                ,function(e){
			//가장 가까운 div 찾기, 
			//reNo,  reMemId(현재 로그인 한 사람의 id) 구하기
            // ajax 호출(reNo, reMemeId보내기) reMemId는 본인이 쓴 글인지 확인하는데 쓰임 (BizAccessFailException)
	        //성공  후 해당 div.remove 
        }); //삭제버튼


    });
</script>


</html>






