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
		String id,pwd,email,phone,address,gender;
	%>
	
	<%
		out.println(request.getServerName()+"</br>");
		out.println(request.getServerPort()+"</br>");
		out.println(request.getProtocol()+"</br>");
		out.println(request.getMethod()+"</br>");
		out.println(request.getRequestURL()+"</br>");
		out.println(request.getRemoteAddr()+"</br>");
		
		
		request.setCharacterEncoding("utf-8");
		id = request.getParameter("id");
		pwd = request.getParameter("pwd");
		email = request.getParameter("email");
		phone = request.getParameter("phone");
		address = request.getParameter("address");
		gender = request.getParameter("gender");
		response.setContentType("text/html;utf-8");
	%>
	
	<!--  request.getParameter(string) name에 해당하는 파라미터값을 구한다.
	      request.getParameterNames() 모든 파라미터 이름을 구함.
	      request.getParameterValue(string[]) name에 해당하는 여러값을 배열로 가져온다.
	
	 -->
	ID = <%= id %></br>
	PASSWORD = <%= pwd %></br>
	EMAIL = <%= email %></br>
	PHONE = <%= phone %></br>
	ADDRESS = <%= address %></br>
	GENDER = <%= gender %></br>
	<% if (gender.equals("남자")){
		out.println("당신은	 멋쟁이 이십니다.");
	}
	else {
			out.println("당신은 이쁜이 이십니다.");
	}	
	%>
   <%-- 
        request.getcContextPath() 웹어플리케이션의 컨텍스트 패스를 얻는다.
        request.getSession() 세션 객체를 얻는다.
        request.getQueryString() 쿼리스트링을 얻는다.  
   		response.addCookie(cookie) 클라이언트에 쿠키를 지정한다. 
   		response.sendRedirect(url) 지정한 url로 이동한다.
   --%>
	
	
</body>
</html>