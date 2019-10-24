<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="get" modelAttribute="register1"></form>
		<center>
			<h1> Details For Registering</h1>
			<table>
				<tr>
					<th>User Name</th>
					<td><input text="username" /></td>
				</tr>
				</br>
				</br>
				<tr>
					<th>Password</th>
					<td><input text="password" /></td>
				</tr>
				</br>
				</br>
				<tr>
					<td colspan = "2"><input type = "submit" value = "register" style="width: 150px; "/></td>
				</tr>
			</table>
		
		</center>
	
</body>
</html>