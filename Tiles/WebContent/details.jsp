<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>
	<table>
	
		<tr>
			<td>Name :</td>
			<td><bean:write name="SicmsbForm" property="name" /></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><bean:write name="SicmsbForm" property="email" /></td>
		</tr>
		<tr>
			<td>Phone :</td>
			<td><bean:write name="SicmsbForm" property="phone" /></td>
		</tr>
		<tr>
			<td>Department :</td>
			<td><bean:write name="SicmsbForm" property="department" /></td>
		</tr>
		<tr>
			<td>Hometown :</td>
			<td><bean:write name="SicmsbForm" property="hometown" /></td>
		</tr>
		
	</table>



</body>
</html>