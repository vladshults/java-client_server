<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,ru.lexpr.model.*, ru.lexpr.dal.DAL"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String driverName = "com.mysql.jdbc.Driver";
		String connString = "jdbc:mysql://localhost:3306/web?user=root&password=admin";
		String search = "";
		List<Course> coursesList = null;
		
		
		try (DAL dal = new DAL(driverName,connString)) {
			
			if (request.getMethod().equals("POST")) {
				request.setCharacterEncoding("UTF-8");
				search = request.getParameter("search");
				coursesList = dal.getCourses(search);
			}
			else
				coursesList = dal.getCourses("");
			
		}
	
	%>


	<form action="Course" method="POST">
		Поиск: <input type="text" name="search" value="">
		<input type="submit" value="Привет!">
	</form>
	<table>
	<%
		for (Course c: coursesList)
			out.print(String.format("<tr><td>%s</td><td>%s</td><td>%d</td><td>%s</td></tr>",
					c.getTitle(), c.getLength(), c.getDescription()));
	
	
	%>
	</table>
</body>
</html>
