<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardDTO"%>
<%@page import="com.springbook.biz.board.BoardDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>  


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- DispatcherServlet은 controller가 리턴한 model and view 객체에서 model 정보를 추출한 다음  httpservlet request
     객체에 model 정보를 저장하여 jsp로 포워딩 한다. 따라서 request로 attribute를 받아야 한다.-->
<%
	List <BoardDTO> boardList = (List) request.getAttribute("boardList");
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
	
		<h1><spring:message code="message.board.list.mainTitle"/></h1>
		<h3>${sessionScope.username} <spring:message code="message.board.list.welcomeMsg"/></h3><a href="logout.do">LOGOUT</a>
		
		<!-- 검색 시작 -->
		
		<form action="getBoardList.do" method="post">
			<table boarder="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">	
						<select name="searchCondition">
						 	<option value="${conditionMap.TITLE}">제목
							<option value="${conditionMap.CONTENT}">내용
						</select>
						<input name="searchKeyword" type="text/">
						<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>"/>
					</td>
				</tr>
			</table>
		</form>
		
		<!-- 검색 종료 -->
		
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" witdh="100"><spring:message code="message.board.list.table.head.seq"/></th>
				<th bgcolor="orange" witdh="200"><spring:message code="message.board.list.table.head.title"/></th>
				<th bgcolor="orange" witdh="150"><spring:message code="message.board.list.table.head.writer"/></th>
				<th bgcolor="orange" witdh="150"><spring:message code="message.board.list.table.head.regDate"/></th>
				<th bgcolor="orange" witdh="100"><spring:message code="message.board.list.table.head.cnt"/></th>
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
		
		<a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"/></a>	
	</center>


</body>
</html>