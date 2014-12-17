<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<script>
	function Login(form) {
		form.submit();
	}
</script>
</head>
<body>
<form action="Calendar.do?method=Login" method="post">
	<table align="center">
		<tr>
			<td><h2>Please login to proceed!</h2>
		<tr>
			<td>Username :<td><html:text name="SicmsbCalendarForm" property="username" size="30"></html:text></td>
		<tr>
			<td>Password :<td><html:password name="SicmsbCalendarForm" property="password" size="30"></html:password></td>
		<tr>
			<td><td><input type="button" value="Login"
				onclick="this.disabled=true; Login(this.form)" />
	</table>
</form>


</body>
</html>

