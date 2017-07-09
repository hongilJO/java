<%@page import="auth_dao.dao"%>
<%@page import="auth_dao.dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String id, pwd, username, address;
	boolean result;
	dao member_dao = dao.getInstance();
	%>
	<%
		id = (String) session.getAttribute("id");
		if (id == null || "".equals(id)) {
			response.sendRedirect("login.jsp");
		} else {
			pwd = request.getParameter("pwd");
			username = request.getParameter("username");
			address = request.getParameter("address");

			result = member_dao.member_update(new dto(id, pwd, username, address));
			if (result) {
				session.setAttribute("pwd", pwd);
				response.sendRedirect("main.jsp");
			} else {
				response.sendRedirect("modify.jsp");
			}
		}
	%>
</body>
</html>