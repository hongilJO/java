<%@page import="com.springbook.biz.user.UserDAO"%>
<%@page import="com.springbook.biz.user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta 	http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	
	// 사용자 입력 정보 추출 
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	// db 연동 
	UserDTO dto = new UserDTO();
	
	dto.setId(id);
	dto.setPassword(password);
	
	UserDAO dao = new UserDAO();
	UserDTO user = dao.getUser(dto);
	
	// 화면 네비게이션 
	if (user != null){
		response.sendRedirect("getBoardList.jsp");
	}else {
		response.sendRedirect("login.jsp");
	}
	

%>
</body>
</html>