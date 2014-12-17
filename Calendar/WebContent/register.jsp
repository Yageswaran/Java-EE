<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function Register(form) {
		form.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>


	<form action="Calendar.do?method=Register" method="post">
		<table cellpadding="3pt" align="center">
			<tr>
				<td><h1>Register Here:</h1>
			</tr>
			<tr>
				<td>Username :</td>
				<td><html:text name="SicmsbCalendarForm" property="username" size="30"></html:text></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><html:password name="SicmsbCalendarForm" property="password" size="30"></html:password></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="button" value="Register"
					onclick="this.disabled=true; Register(this.form)" />
			</tr>

		</table>
		<p />




	</form>
	<bean:write name="SicmsbCalendarForm" property="msg"></bean:write>
</body>
</html>