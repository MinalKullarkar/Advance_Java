<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="Student_Info.jsp">
			<table border="1px solid">
				<tr>
					<td>Id</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>SQL</td>
					<td><input type="checkbox" name="course" value="SQL"></td>
				</tr>
				<tr>
					<td>JAVA</td>
					<td><input type="checkbox" name="course" value="JAVA"></td>
				</tr>
				<tr>
					<td>WEB-TECH</td>
					<td><input type="checkbox" name="course" value="WEB-TECH"></td>
				</tr>
				<tr>
					<td>J2EE</td>
					<td><input type="checkbox" name="course" value="J2EE"></td>
				</tr>
			</table>
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>