<%@page import="com.springbook.biz.board.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%

	// 1. 검색할 게시글 번호 추출 
	String seq = request.getParameter("seq");
 	
	BoardDTO dto =  new BoardDTO();
 	
	dto.setSeq(Integer.parseInt(seq));

	BoardDAO dao = new BoardDAO();
	BoardDTO board = dao.getBoard(dto);
	
%>
 
	<h1> 글 상세 </h1>
	<a href="logout_proc.jsp">LOGOUT</a>
	<hr>
	<form action="updateBoard_proc.jsp" method="post">
	<input type="hidden" name="seq" value="<%= board.getSeq() %>"/>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange" width="70">제목</td> 
			<td align="left"><input name="title" type="text" value="<%= board.getTitle() %>"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">작성자</td>
			<td align="left"><%= board.getWriter() %></td>
		</tr>
		<tr>
			<td bgcolor="orange">내용</td>
			<td align="left"><textarea name="content" rows="10" cols="40"><%= board.getContent() %></textarea>
		</tr>
		<tr>
			<td bgcolor="orange">등록일</td>
			<td align="left"><%= board.getRegDate() %></td>
		</tr>
		<tr>
			<td bgcolor="orange">조회수</td>
			<td align="left"><%= board.getCnt() %></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="글 수정"/></td>
		</tr>
	</table>	
	</form>
	<hr>
	<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard_proc.jsp?seq=<%= board.getSeq() %>">글 삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.jsp">글 목록</a>&nbsp;&nbsp;&nbsp;
</center>
</body>
</html>