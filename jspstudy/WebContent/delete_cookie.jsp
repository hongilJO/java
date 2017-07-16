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
		Cookie []ck;
	
	%>
	
	<%	
		request.setCharacterEncoding("utf-8");
		ck = request.getCookies();
		for (int i=0; i< ck.length;i++){
			if("login".equals(ck[i].getName())){
				ck[i].setMaxAge(0);
				response.addCookie(ck[i]);
			}
		}	
		response.setContentType("text/html;charset=UTF-8");
	%>
	<a href="check_cookie.jsp">쿠키 체크 하기</a>
</body>
</html>