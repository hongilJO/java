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

jsp 지시자 = <%@ %>   페이지 속성
jsp 주석 태그 = <%-- --%>    !! html 주석은 브라우저에 읽혀지므로 브라우저에 노출돼지만  jsp 주석은 서버에서 실행되므로 브라우저에서 노출이 되지 않는다.
jsp 선언부 = <%! %>   변수, 함수 선언
jsp 표현식 = <%=  %>   결과값 출력 
jsp 스크립틀릿 = <% %> 자바소스 삽입 
jsp 액션태그 <jsp:action> </jsp:action> 자바빈연결

페이지 변환과정 
jsp -> servlet -> class -> html 


내부객체 (jsp 컨테이너에 의해 jsp -> servlet 으로 변환될때 자동으로 객체가 생성된다.)

입출력객체: request, response, out
서블릿객체: page, config
세션객체: session
예외객체: exception
-->


</body>
</html>