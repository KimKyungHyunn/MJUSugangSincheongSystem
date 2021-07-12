<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" import="valueObject.VLine"  import="valueObject.VDirectory" import="valueObject.VUser" %>
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
<link href="css/table.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>수강신청 메인 화면</title>
</head>
<body>
		
	<% if (session.getAttribute("student")==null){ %>
		<jsp:forward page="error.jsp"/>
	<%}%>

	<%
		VUser student = (VUser) session.getAttribute("student");
		String StudentName = student.getName();
		String StudentID = student.getUserId();
		Vector<VLine> VecLine = (Vector<VLine>) session.getAttribute("VecLine");
		Vector<Vector<VDirectory>> VecDepartments = (Vector<Vector<VDirectory>>) session.getAttribute("VecDepartments");
	%>
	
	<p><a href="./List?action=Reservation"> 미리담기 목록 </a> &nbsp;
	<a href="./List?action=Apply"> 수강신청 목록 </a> &nbsp;
	<a href="./List?action=Information"> 학생 정보 </a> &nbsp;
	<a href="./List?action=Logout"> 로그아웃 </a> &nbsp; 
	<%=StudentName%> 학생
	</p>
	 
	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table class="table" cellspacing="0">

					<%
						for (int i = 0; i < VecLine.size(); i++) {
							VecLine.get(i);
					%>
					<thead>
						<tr>
							<th><%=VecLine.get(i).getLineName()%></th>
						</tr>
					</thead>

					<%
						Vector<VDirectory> VecDepart = VecDepartments.get(i);
							for (int j = 0; j < VecDepart.size(); j++) {
								VecDepart.get(j);
								String DepName = VecDepart.get(j).getDepartmentName();
					%>
					<tbody>
						<tr>
							<td><a href="./Sugang?DepName=<%=DepName%>"><%=VecDepart.get(j).getDepartmentName()%></a></td>
						</tr>
					</tbody>
					<%
						}
						}
					%>

				</table>
			</div>
		</div>
	</div>


</body>
</html>