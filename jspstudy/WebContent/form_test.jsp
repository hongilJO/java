<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="formEx" method="post">

	아이디:<input type="text" name="id" size=10/></br>
    패스워드:<input type="password" name="passwd" size=10/></br>
    취미:<input type="checkbox" name="hobby" value="ball">볼링
        <input type="checkbox" name="hobby" value="hotkey">하키 
        <input type="checkbox" name="hobby" value="baseball">야구
        <input type="radio" name="sex" value="man" checked="checked">남자
        <input type="radio" name="sex" value="woman">여자
        <select name="food">
           <option value="rice" selected="selected">밥</option>
           <option value="noodle">면</option>
        </select>
        <input type="submit" value="전송"/>전송
        <input type="reset" value="리셋"/>리셋 

</form>
</body>
</html>