<%@ page import="java.util.ArrayList"%>
<%@ page import="com.javalec.ex.dto.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! 
		ArrayList<board> list; 
	%>
	<table width="500" cellpading="0" cellspacing="0" border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>날짜</th>
			<th>히트</th>
		</tr>
		<% 
			list = (ArrayList <board>)request.getAttribute("list");
			for(board b: list){   
		%>
		<tr>
			<td><%=b.getBid()%></td>
			<td><%=b.getB_name()%></td>
			<% for(int j=0; j < b.getB_indent(); j++){
			%>-<%	
			}%>
			<td><a href="content_view.do?bid=<%=b.getBid()%>"><%=b.getB_title()%></a></td>
			<td><%=b.getB_date()%></td>
			<td><%=b.getB_hit()%></td>
		</tr>
		<% 
			b = null;	
		}	
		%>
	</table>
	<a href="write_view.do">글작성</a>

</body>
</html>