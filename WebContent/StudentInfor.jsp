<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" import="valueObject.VUser" %>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/font.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>수강신청 리스트</title>
</head>
<body>
	<% if (session.getAttribute("student")==null){ %>
		<jsp:forward page="error.jsp"/>
	<%}%>
	
	<% 	VUser vUser =  (VUser)request.getAttribute("vUser");%>

	<a href="./SugangMain.jsp"> 메인으로 돌아가기  </a> &nbsp; <br>
	<h2>학생 개인정보 조회</h2> <br>
	<label>이름 : <%= vUser.getName() %> </label> <br>
	<label>계좌번호 : <%= vUser.getAccountNum() %> </label><br>
	<label>학년 : <%= vUser.getGrade() %> </label><br>
	<label>전공 : <%= vUser.getMajor() %> </label> <br>
</body>
</html>