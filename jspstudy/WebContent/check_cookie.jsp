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
		Cookie [] pool;	
	%>
	<%	
		request.setCharacterEncoding("utf-8");
		pool = request.getCookies();
		for (int i=0; i< pool.length; i++){
			if ("login".equals(pool[i].getName())){
				
	%>	
		 아이디와 패스워드는<% out.println(pool[i].getValue()); %>입니다.	
	<% 
		
			}
		}
		response.setContentType("text/html;charset=UTF-8");
	%>
	<a href="delete_cookie.jsp"> 쿠키 삭제</a>
</body>
</html>