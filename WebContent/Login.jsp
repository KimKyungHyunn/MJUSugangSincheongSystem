<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/login.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>수강신청 시작</title>
</head>
<body>
	
<div class="wrapper fadeInDown">
  <div id="formContent">
		<h2>수강신청 로그인 화면</h2>
		<form action = "./LoginCheck" method = "post">		
			<input type= text class="fadeIn second" name = "id"  placeholder="login">
			<input type= text class="fadeIn third"  name = "pw" placeholder="password">
			<input type = submit name = "로그인하기" class="fadeIn fourth">	
		</form>	
	
	</div>
</div>
</body>
</html>


  