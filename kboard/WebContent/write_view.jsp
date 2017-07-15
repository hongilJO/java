<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write.do" method="post">
			<tr>
				<td>글 제목 </td>
				<td><input type="text" name="btitle"></td>
			</tr>
			<tr>
				<td>작성자 </td> 
				<td><input type="text" name="bname"></td>
			</tr>
			<tr>	
				<td>글 내용</td>	
				<td><textarea rows="100" cols="100" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="글 작성"></td>
			</tr>
		</form>
	</table>
	<a href="list.do">목록 가기</a>
</body>
</html>