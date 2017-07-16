<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 

jsp 지시자 <%-- <%@  %> --%>
1. page : 해당페이지의 전체적인 속성 지정 <%-- <%@ page import="java.util.Arrays" %> --%>
2. include : 별도의 페이지를 현재 페이지에 삽입  <%-- <%@ include file="two.jsp" %> --%>
3. tag: 태그라이브러리의 태그 사용 
 -->
<h1>two.jsp를 삽입합니다!!!.</h1>
<%@ include file="two.jsp" %>
</body>
</html>