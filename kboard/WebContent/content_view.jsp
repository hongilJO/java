<%@page import="com.javalec.ex.dto.board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%! board b; %>
	<table>
		<form action="modify.do" method="post">
	<% 
		b = (board)request.getAttribute("board"); 
	
	%>
		<input type="hidden" name="bid" value="<%=b.getBid()%>">
		<tr>
			<td>글번호</td>
			<td><%=b.getBid()%></td>
		</tr>
		<tr>
			<td>좋아요</td>
			<td><%=b.getB_hit()%></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=b.getB_name()%></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="btitle" value="<%=b.getB_title()%>"></td>		
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="bcontent" value="<%=b.getB_content()%>"></td>
		</tr>
		<tr>
			<td>글 수정하기</td>
			<td><input type="submit" value="글 수정"></td>
			<td>글 삭제하기</td>
			<td><a href="delete.do?bid=<%=b.getBid()%>">글 삭제</a></td>
		</tr>
		</form>
	</table>
	<a href="list.do">글 목록 보기 </a>
</body>
</html>