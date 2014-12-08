<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send an e-mail</title>
<script>
	function submit(form) {
		form.submit();
	}
</script>
</head>
<body>
	<form action="Action.do?method=SendEmail" method="post">
		<table border="0" align="center">
			<caption>
				<h2>Send New E-mail</h2>
			</caption>
			<tr>
				<td>Recipient address:</td>
				<td><input type="text" name="recipient" size="50" /></td>
			</tr>
			<tr>
				<td>Subject:</td>
				<td><input type="text" name="subject" size="50" /></td>
			</tr>
			<tr>
				<td>Content:</td>
				<td><textarea rows="10" cols="39" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					value="Send" onclick="this.disabled=true; submit(this.form)" /></td>

			</tr>
		</table>

	</form>
	<bean:write name="SicmsbForm" property="msg"></bean:write>
</body>
</html>