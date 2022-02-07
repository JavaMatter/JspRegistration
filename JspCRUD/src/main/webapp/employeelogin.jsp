<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="${pageContext.request.contextPath}/form.css" rel="stylesheet" type="text/css">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
			<h2>Login Here!</h2>
			<form action="<%=request.getContextPath()%>/register" method="post" name="formregister">
				<table>
					<tr>
						<td><h3 style= "font-size:10px ">${Errormessage}</h3>
							<h3 style = "color: green;">${Sucessmessage}</h3>
						</td>
					</tr>
					<tr>
						<td><label>User Name:</label></td>
						<td><input onkeydown="return /[a-z]/i.test(event.key)" name="username" id="userName" required></td>
					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><input type="password" name="password" id="password"></td>
					</tr>
				</table>
				<div class="btn-register">
					<button type="submit" name = "submit" value = "login">login</button>
				</div>
				<a href = "employeeregister.jsp"> new user click here! </a>
			</form>
		</div>
	</body>
</html>