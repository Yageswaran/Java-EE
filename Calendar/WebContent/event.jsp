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
			<td>Username:</td>
			<td><bean:write name="SicmsbCalendarForm" property="username" /></td>
		</tr>
		<tr>
			<td>Start Date:</td>
			<td><bean:write name="SicmsbCalendarForm" property="startdate" /></td>
		</tr>
		<tr>
			<td>End Date :</td>
			<td><bean:write name="SicmsbCalendarForm" property="enddate" /></td>
		</tr>
		<tr>
			<td>Start Time :</td>
			<td><bean:write name="SicmsbCalendarForm" property="starttime" /></td>
		</tr>
		<tr>
			<td>End time :</td>
			<td><bean:write name="SicmsbCalendarForm" property="endtime" /></td>
		</tr>
		<tr>
			<td>Remarks :</td>
			<td><bean:write name="SicmsbCalendarForm" property="remarks" /></td>
		</tr>
		<tr>
			<logic:iterate id="dat" name="list" type="com.sicmsb.bean.Data">
				<td><center>
						<a href="Calendar.do?method=Delete&id=<%=dat.getId()%>">Delete</a>
					</center>
			</logic:iterate>
		</tr>

	</table>







</body>
</html>