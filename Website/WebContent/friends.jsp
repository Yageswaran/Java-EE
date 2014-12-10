<%-- <%-- 
    Document   : friends
    Created on : Dec 19, 2008, 1:55:47 AM
    Author     : eswar@vaannila.com


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>More details about the Friends TV show goes here...</p>
    </body>
</html>
 --%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function submitAdd(form) {
		form['myAction'].value = 'doAdd';
		form.submit();
		//document.form['HelloWorldForm'].submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>
	<h1>Insert Data to Database</h1>
	<form action="HelloWorld.do" method="post">
		<html:hidden name="baseLayout" property="myAction" />
		<div>
			<bean:write name="baseLayout" property="message" />
		</div>
		<table cellpadding="3pt">
			<tr>
				<td>Name :</td>
				<td><html:text name="baseLayout" property="myUser" size="30"></html:text></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><html:text name="baseLayout" property="email" size="30"></html:text></td>
			</tr>
			<tr>
				<td>Webpage :</td>
				<td><html:text name="baseLayout" property="webpage" size="30"></html:text></td>
			</tr>
			<tr>
				<td>Summary :</td>
				<td><html:text name="baseLayout" property="summary" size="30"></html:text></td>
			</tr>
			<tr>
				<td>Comment :</td>
				<td><html:text name="baseLayout" property="comments" size="30"></html:text></td>
			</tr>

		</table>
		<p />
		<input type="button" value="Insert"
			onclick="this.disabled=true; submitAdd(this.form)" />
	</form>
</body>
</html>