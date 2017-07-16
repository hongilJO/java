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
		Cookie ck;
	%>
	<% 
		request.setCharacterEncoding("utf-8");
		id = request.getParameter("id");
		pwd = request.getParameter("pwd");
		ck =new Cookie("login",id+pwd);
		ck.setMaxAge(60*60);
		response.setContentType("text/html;charset=UTF-8");
		response.addCookie(ck);
	%>
	
	
	<a href="check_cookie.jsp">go check cookie</a>
</body>
</html>