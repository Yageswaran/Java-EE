<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td><center>
					<h2>
						<bean:write name="SicmsbCalendarForm" property="date"></bean:write>
					</h2>
				</center></td>
		</tr>
		<tr>
			<form action="Calendar.do?method=Save" method="post">
				<tr>
					<td>Date :<html:text name="SicmsbCalendarForm" property="date" size="10"></html:text></td>
				</tr>
				<tr>
					<td>Insert here:<html:text name="SicmsbCalendarForm"
							property="remarks" size="100"></html:text></td>
				</tr>
				<tr>
					<td><input type=submit value="Save"></td>
				</tr>

			</form>
	</table>
</body>
</html>