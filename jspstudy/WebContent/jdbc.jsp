<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--     
    show databases;
    
    use [database명];
    
    show tables;
    
	create table [테이블이름](
		id varchar2 (10) primary key,  //컬럼명 자료형 사이즈 조건 
		pwd varchar2 (30) not null;
	)
	
	
	select [컬럼명] from [table];
	
	
	insert into [테이블이름] (컬럼,컬럼,....) values (값,값,값);
	commit;
	
	delete from [테이블이름] where [컬럼명]=값;
	
	update [테이블이름] set [컬럼명=값, [컬럼명]=값, ..where [컬럼명]=값;
	
	drop database [database명];
	drop table [테이블이름];
	
	
	
	
	
테이블 생성 
   create table 테이블 명 ( 컬럼명 데이터형식 널값여부 기타옵션);
  
  auto_increment;  는 자동으로 번호를 증가시켜준다. 
  primary key ;  는 고유값 설정으로 똑같은 값은 절대 받지 않는다는 뜻.
  not null;  null을 허용하지 않는다.
  default 0;  기본값을 지정한다.
  
*** mysql 각종 데이터형들 

tinyint 부호 있는 정수 -128 ~ 127 

부호 없는 정수 0 ~255 
1 Byte 

SMALLINT 부호 있는 정수 -32768 ~ 32767 
부호 없는 정수 0 ~65535 
2 Byte 

MEDIUMINT 부호 있는 정수 -8388608 ~ 8388607 
부호 없는 정수 0 ~16777215 
3 Byte 

INT 또는 INTEGER 부호 있는 정수 -2147483648 ~ 2147483647 
부호 없는 정수 0 ~4294967295 
4 Byte 

BIGINT 부호 있는 정수 -9223372036854775808 ~ 9223372036854775807 
부호 없는 정수 0 ~18446744073709551615 
8 Byte 

FLOAT 단일 정밀도를 가진 부동 소수점 
-3.402823466E+38 ~3.402823466E+38 

DOUBLE 2 배 정밀도를 가진 부동 소수점 
-1.79769313486231517E+308 ~ 1.79769313486231517E+308 

DATE 날짜를 표현하는 유형 
1000-01-01 ~ 9999-12-31 

DATETIME 날짜와 시간을 표현하는 유형 
1000-01-01 00:00:00 ~ 9999-12-31 23:59:59 

TIMESTAMP 1970-01-01 00:00:00 부터 2037년 까지 표현 
4 Byte 

TIME 시간을 표현하는 유형 
-839:59:59 ~ 838:59:59 

YEAR 년도를 표현하는 유형 
1901 년 ~ 2155년 

CHAR(M) 고정길이 문자열을 표현하는 유형 
M = 1 ~255 

VARCHAR(M) 가변길이 문자열을 표현하는 유형 
M = 1 ~ 255 

TINYBLOB
TINYTEXT 255개의 문자를 저장 
BLOB : BINARY LARGE OBJECT의 약자 

BLOB
TEXT 63535개의 문자를 저장 

MEDIUMBLOB
MEDIUMTEXT 16777215개의 문자를 저장 

LONGBLOB
LONGTEXT 4294967295(4Giga)개의 문자를 저장



 --%>
<%! 
	Connection conn; 
 	Statement stmt;
 	ResultSet rs;
%>
<%
	try{
 		Class.forName("com.mysql.jdbc.Driver");
 	}catch(ClassNotFoundException e){
 		e.getMessage();
 	}
	try{
		String url = "jdbc:mysql://10.101.28.91:13306/jsp_test";
		
		conn = DriverManager.getConnection(url, "admin", "12345");
		
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery("select * from login");
		
		while(rs.next()){
			System.out.println(rs.getString(1));
		}
	}catch(SQLException e){
		e.getMessage();
	}
%>
</body>
</html>