<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			String userName = null;
			if (request.getMethod().equals("POST")) {
				request.setCharacterEncoding("UTF-8");
				userName = request.getParameter("userName");
			}
		
			if (userName == null)
				userName = "";
			else
				userName = userName.trim();
		%>
		
		<%
			if (!userName.isEmpty())
				out.println(String.format("Привет, %s", userName));
			else
				out.println(String.format("Привет!"));
			
		
		%>
	<h1>
	</h1>
	<form action="hello.jsp" method="post">
		Name: <input type="text" name="userName" value="<%= userName%>">
		<input type="submit" value="Привет!">
	</form>
</body>
</html>
