<%@page import="java.util.List"%>
<%@page import="com.jspiders.smswithspringmvc2.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:include page="home.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

div {
	margin-top: 50px;
}

table {
	width: 80%;
	border-collapse: collapse;
	background-color: #fff;
	border: 1px solid #ccc;
	margin: 0 auto 20px auto; /* Center the table */
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: #007bff;
	color: #fff;
}

tr:nth-child(even) {
	background-color: #f2f2f2; /* Alternate row color */
}

div[align="center"] {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

h1 {
	color: #007bff;
}
</style>
</head>
<body>
	<%
	 @SuppressWarnings("unchecked")
		List<StudentPOJO> students=(List<StudentPOJO>)request.getAttribute("students");
		if(students!=null && students.size()>0){
	%>
	<div align="center">
		<table border="1px soild">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Age</th>
			</tr>
			<%
				for (StudentPOJO student : students) {
				%>
			<tr>
				<td><%= student.getId() %></td>
				<td><%= student.getName() %></td>
				<td><%= student.getEmail() %></td>
				<td><%= student.getMoblie() %></td>
				<td><%= student.getAge() %></td>
			</tr>
			<%}%>
		</table>
	</div>
	<% }else{
		%>
	<div>
		<h1>Students Not Found</h1>
	</div>
	<%} %>


</body>
</html>