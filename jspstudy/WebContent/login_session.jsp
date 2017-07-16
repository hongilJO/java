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
	%>
	<%	
		id = request.getParameter("id");
		pwd = request.getParameter("pwd");
		
		if("hongil".equals(id) && "12345".equals(pwd)){
			session.setAttribute("id",id);
			response.sendRedirect("welcome.jsp");
		}else{
			response.sendRedirect("login_session.html");
		}
	
	%>
</body>
</html>