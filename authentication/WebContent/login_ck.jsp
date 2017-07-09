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
		String id,pwd;
		boolean result;
		dao member_dao = dao.getInstance();
	%>
	
	<%	
		id = request.getParameter("id");
	    pwd = request.getParameter("pwd");
		result = member_dao.member_check(id,pwd);
		if (result){
			session.setAttribute("id", id);
			session.setAttribute("pwd", pwd);
			session.setMaxInactiveInterval(3600);
			response.sendRedirect("main.jsp");
		}else{
	%>
	<script>
		alert("아이디 또는 비밀번호가 틀렸습니다.");
	</script>
	<% 
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>