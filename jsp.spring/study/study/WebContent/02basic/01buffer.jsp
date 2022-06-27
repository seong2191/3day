<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page autoFlush="false" buffer="8kb"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
02basic폴더에 01buffer.jsp
<!-- out이랑 관계있습니다. out.print("<html>")
out은 response랑 관련
(브라우저에게 전달할) 데이터를 임시저장 / 데이터 = html태그 인 문자   -->
8kb 8 * 1024 byte
		한글 2, 3byte , 영어 1byte
<!-- <html>태그부터</html>까지 8000byte가 보통 안돼요 
		넘어도 autoFlush() 해주니까 ㄱㅊ -->
<%
	long startTime = System.nanoTime();
	for(int i=0; i<10000; i++){
		out.print("술이 좋아");
		//out.flush(); // 버퍼에 있는거를 브라우저에 전달.
		//out.clear();   // 버퍼에 있는거를 비움
	}
	long endTime = System.nanoTime();
	out.print(endTime - startTime);
%>
</body>
</html>