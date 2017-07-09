<%@page import="auth_dao.dto"%>
<%@page import="auth_dao.dao"%>
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
	String id, pwd, username, address;
	dao member_dao = dao.getInstance();
	dto member;
	%>
	<%
		id = (String) session.getAttribute("id");
		if (id == null || "".equals(id)) {
			response.sendRedirect("login.jsp");
		}else{
			pwd = (String) session.getAttribute("pwd");
			member = member_dao.member_get(id, pwd);
	%>
	<form method="post" action="modify_ok.jsp">
		ID :<%=id%></br> 
		PASSWORD : <input type="password" name="pwd" value="<%=pwd%>"></br>
		USERNAME : <input type="username" name="username"
			value="<%=member.getUsername()%>"></br> ADDRESS : <input
			type="address" name="address" value="<%=member.getAddress()%>"></br>

		<input type="submit" value="업데이트">
	</form>
	<%
		}
	%>
</body>
</html>