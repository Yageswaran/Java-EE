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
	/* function sendMsg(msg){
		var msg;
		msg['msg']=msg;
		msg.submit();
	} */
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>
	<div style="background-color: grey">

		<form action="Action.do?method=Insert" method="post">
			<table cellpadding="3pt" align="center">
				<tr>
					<td><h1>Insert Data :</h1>
				</tr>
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
				<tr>
					<td></td>
					<td><input type="button" value="Insert"
						onclick="this.disabled=true; Insert(this.form)" />
				</tr>

			</table>
			<p />




		</form>
	</div>
	<bean:write name="SicmsbForm" property="msg"></bean:write>
</body>
</html>