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
			<h2>Employee Registration Form</h2>
			<form action="<%=request.getContextPath()%>/register" method="post" name="formregister">
				<table>
					<tr>
						<td><label>First Name:</label></td>
						<td><input onkeydown="return /[a-z]/i.test(event.key)" name="firstName" id="firstName" required></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><input onkeydown="return /[a-z]/i.test(event.key)" name="lastName" id="lastName" required></td>
					</tr>
					<tr>
						<td><label>User Name:</label></td>
						<td><input onkeydown="return /[a-z]/i.test(event.key)" name="username" id="userName" required></td>
					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><input type="password" name="password" id="password" required maxlength="16" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{6,16}$" title="Passsword has to be minimum 6 characters and maximum 16 characters with one letter, one number and oner special character"></td>
					</tr>
					<tr>
						<td><label>Address:</label></td>
						<td><input type="text" name="address" id="address" required maxlength="50"></td>
					</tr>
					<tr>
						<td><label>Contact:</label></td>
						<td><input type="text" name="contact" id="contactNo" required inputmode="numeric" pattern="[6-9]{1}[0-9]{9}" title="Phone number starting with 6 to 9 and remaing 9 digit with 0-9"></td>
					</tr>
				</table>
				<div class="btn-register">
					<button type="submit" name = "submit" value = "register">register</button>
				</div>
			</form>
		</div>
	</body>
</html>