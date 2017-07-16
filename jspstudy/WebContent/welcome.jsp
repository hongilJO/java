<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (request.isRequestedSessionIdValid()) {
			Enumeration en = session.getAttributeNames();
			while (en.hasMoreElements()) {
				String name = en.nextElement().toString();
				if ("id".equals(name)) {
					String value = (String) session.getAttribute(name);
					out.println(value + "님 접속을 환영합니다.!");
					out.println("session id :" + session.getId());
					out.println("세션 유효시간 :" + session.getMaxInactiveInterval());
				}
			}
		}else{
			out.println("세션이 유효하지 않습니다.");
		}
	%>
	<a href="delete_session.jsp">로그아웃</a>
</body>
</html>