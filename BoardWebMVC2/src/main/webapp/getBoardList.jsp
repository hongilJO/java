<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardDTO"%>
<%@page import="com.springbook.biz.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- session 객체는 getAttribute 호출시에 object로 값을 리턴한다.-->
<%
	List <BoardDTO> boardList = (List) session.getAttribute("boardList");
%>

<%-- 
<%
	// 사용자 입력 정보 추출(검색 기능은 나중에 구현)
	// DB 연동 처리 
	BoardDTO dto = new BoardDTO();
	BoardDAO dao = new BoardDAO();

	List<BoardDTO> boardList = dao.getBoardList(dto);
%>
--%>
	<center>
	
		<h1>글 목록</h1>
		<h3>테스트님 환영합니다. </h3> <a href="logout.do">LOGOUT</a>
		
		<!-- 검색 시작 -->
		
		<form action="getBoardList.jsp" method="post">
			<table boarder="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">	
						<select name="searchCondition">
							<option value="TITLE">제목
							<option value="CONTENT">내용
						</select>
						<input name="searchKeyword" type="text/">
						<input type="submit" value="검색"/>
					</td>
				</tr>
			</table>
		</form>
		
		<!-- 검색 종료 -->
		
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" witdh="100">번호</th>
				<th bgcolor="orange" witdh="200">제목</th>
				<th bgcolor="orange" witdh="150">작성자</th>
				<th bgcolor="orange" witdh="150">등록일</th>
				<th bgcolor="orange" witdh="100">조회수</th>
			</tr>
			
			<% for (BoardDTO board : boardList) { %>
			<tr> 
				<td> <%= board.getSeq() %> </td>
				<td align="left"><a href="getBoard.do?seq=<%= board.getSeq() %>"> <%= board.getTitle() %></a></td>
				<td><%= board.getWriter() %></td>
				<td><%= board.getRegDate() %></td>
				<td><%= board.getCnt() %></td>
			</tr>
			<%} %>
		</table>	
		<br>
		
		<a href="insertBoard.jsp">새글 등록</a>	
	</center>


</body>
</html>