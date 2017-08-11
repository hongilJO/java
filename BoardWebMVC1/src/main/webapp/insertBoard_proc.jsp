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
	
	<%
		//1. 사용자 입력 정보 추출
		request.setCharacterEncoding("EUC-KR");
		String title = request.getParameter("title");
		String writer =  request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		
		BoardDAO dao = new BoardDAO();
			
		dao.insertBoard(dto);
		response.sendRedirect("getBoardList.jsp");
	
	%>

</body>
</html>