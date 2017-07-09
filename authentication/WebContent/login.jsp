<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%if(session.getAttribute("id")==null || "".equals(session.getAttribute("id"))){
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>

	<form method="post" action="login_ck.jsp">
	
		<h2> 로그인 페이지에 오신걸 환영합니다. </h2>
		ID : <input type="text" name="id"></br>
		PASSWORD : <input type="password" name="pwd"></br>
		
		
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력"></br>
		
		<h4>계정이 없으신 분들은 먼저 회원 가입을 부탁드립니다.</h4>
		<a href="join.jsp">회원가입</a>
		
		
		
	</form>

</html>
<%}else{%>
<jsp:forward page="main.jsp"/>
<%}%>
