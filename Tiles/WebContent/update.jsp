<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function Insert(form) {
		form.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Form</title>
</head>
<body>

	<h1>Update Data :</h1>
	<form action="Action.do?method=Update" method="post">
		<html:hidden name="SicmsbForm" property="id" />

		<table cellpadding="3pt">
			<tr>
				<td>Name :</td>
				<td><html:text name="SicmsbForm" property="name" size="30"></html:text></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><html:text name="SicmsbForm" property="email" size="30"></html:text></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><html:text name="SicmsbForm" property="phone" size="30"></html:text></td>
			</tr>
			<tr>
				<td>Department :</td>
				<td><html:text name="SicmsbForm" property="department"
						size="30"></html:text></td>
			</tr>
			<tr>
				<td>Hometown :</td>
				<td><html:text name="SicmsbForm" property="hometown" size="30"></html:text></td>
			</tr>

		</table>
		<p />

		<input type="button" value="Update"
			onclick="this.disabled=true; Insert(this.form)" />


	</form>
	<bean:write name="SicmsbForm" property="msg"></bean:write>
</body>
</html>