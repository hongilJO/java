<%@page import="auth_dao.dao"%>
<%@page import="auth_dao.dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="500.jsp" %>
<%-- 
<jsp:useBean id="member" class="auth_dao.dto"/>
<jsp:setProperty property="*" name="member"/>

bean 객체를 이용하여 dto의 값을 바로 넣어줄수가 있다. 이렇게 이용을 하려면 첫번째 dto의 객체 생성자를 없애야한다.
둘째 이전에 form 태그에서 날렸던 attribute값과 dto 객체의 변수 값이 이름이 값아야 한다. 
셋째 setProperty 의 프로퍼티 값에 *을 적용한다.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String id,pwd,username,address;
		dao member_dao = dao.getInstance();
		dto member;
		boolean result;
		int i;
	%>
	<%
		id = request.getParameter("id");
		pwd = request.getParameter("pwd");
		username = request.getParameter("username");
		address = request.getParameter("address");
		member = new dto(id,pwd,username,address);
		
		result = member_dao.member_check(id, pwd);
		if (result){
			response.sendRedirect("join.jsp");
		}
		i = member_dao.member_apply(member);
		
		if(i==1){
			response.sendRedirect("login.jsp");
		}else{
			response.sendRedirect("join.jsp");
		}
	%>
</body>
</html>