<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
int id;
String name;
String [] course;

%>
<%
 id=Integer.parseInt(request.getParameter("id"));
 name=request.getParameter("name");
 course=request.getParameterValues("course");
 
%>
<div>
<h1><%= id  %></h1>
<h1><%= name %> </h1>


<br>
<%
 for(String course:course)
 {%>
	 <h1><%=course %></h1>
 <% }
%> 
</div>

</body>
</html>