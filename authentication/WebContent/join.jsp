<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page errorPage="500.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join_ok.jsp" method="post">
		ID : <input type="text" name="id"></br>
		PWD : <input type="password" name="pwd"></br>
		USERNAME : <input type="text" name="username"></br>
		ADDRESS : <input type="text" name="address"></br>
	
		<input type="submit" name="등록"></br>
	</form>
</body>
</html>