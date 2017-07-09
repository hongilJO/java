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
		String id;
	%>
	<% 
		id = (String) session.getAttribute("id");
		if (id == null || "".equals(id)) {
			response.sendRedirect("login.jsp");
		}
	%>
	<a href="modify.jsp"> 회원정보 수정</a></br>
	
	<a href="logout.jsp"> 로그아웃</a>
	<%-- 
		만든뒤에 강사분이랑 다른점
		1. 첫째 강사분은 로그인 페이지에도 세션 검사를 하도록 했다. 그래서 세션 값이 있을시에 main.jsp로 forwarding 되게 했다.
	 	<jsp:forward page=""/>
	 	2. 둘째 회원가입 페이지에서 dto의 객체에 값을 넣을때 강사분은 usebean을 이용하여 생성했다. 
	 	<jsp:useBean id="변수" class="클래스위치"/> <jsp:setProperty property="*" name="변수"/>
	 	3. 셋째 boolean 대신에 public static final int를 이용하여 상수를 만들어 사용했다.
	 	4. 넷째 dao 객체 호출은 싱글턴 디자인 패턴으로 제공한다.
	 --%>
</body>
</html>