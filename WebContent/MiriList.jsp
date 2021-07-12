<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector" import="valueObject.VLecture"%>
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
<title>수강신청 리스트</title>
</head>
<body>
	<%
		if (session.getAttribute("student") == null) {
	%>
	<jsp:forward page="error.jsp" />
	<%
		}
	%>

	<%
		Vector<VLecture> VecLecture = (Vector<VLecture>) request.getAttribute("VecLecture");
		String value = (String) request.getAttribute("action");
	%>

	<a href="./SugangMain.jsp"> 메인으로 돌아가기 </a> &nbsp;
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				 <table class="table" cellspacing="0">
					<thead>
						<tr>
							<th>강좌번호</th>
							<th>강좌명</th>
							<th>교수명</th>
							<th>강의시간</th>
							<th>학점</th>
							<th>수강인원</th>
							<th>수강제한인원</th>
							<th>삭제</th>
							<th>수강신청</th>
						</tr>
					</thead>

					<%
						for (VLecture lecture : VecLecture) {
					%>
					<tbody>
						<tr>
							<td><%=lecture.getId()%></td>
							<td><%=lecture.getName()%></td>
							<td><%=lecture.getProfessor()%></td>
							<td><%=lecture.getTime()%></td>
							<td><%=lecture.getGradeSize()%></td>
							<td><%=lecture.getNumApplyPerson()%></td>
							<td><%=lecture.getNumLimited()%></td>
							<td>
								<form action="./Apply" method="post">
									<input type=hidden name="value" value=<%=value%>> <input
										type=hidden name="LectureID" value=<%=lecture.getId()%>>
									<input type=submit name="action" value="삭제">
								</form>
							</td>
							<td>
								<form action="./Apply" method="post">
									<input type=hidden name="LectureID" value=<%=lecture.getId()%>>
									<input type=submit name="action" value="수강신청">
								</form>
							</td>
						</tr>
					</tbody>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>


</body>
</html>