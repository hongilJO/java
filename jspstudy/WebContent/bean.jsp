<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="student2" class="com.javalec.ex.Student" scope="page"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:setProperty property="name" value="xweb01.nelo2" name="student2"/>
	<jsp:setProperty property="age" value="10" name="student2"/>
	
	hostname : <jsp:getProperty property="name" name="student2"/>
	ip : <jsp:getProperty property="age" name="student2"/>
	
</body>
</html>