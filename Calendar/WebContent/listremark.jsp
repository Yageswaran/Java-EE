<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2" align="center" width="100%">
		<tr>
			<th>Name</th>
			<th>Date</th>
			<th>Remarks</th>
			
		</tr>

		<logic:iterate id="dat" name="listRemarks"
			type="com.sicmsb.bean.Data">
			<tr>
				<td><center><bean:write name="dat" property="username" /></center></td>
				<td><center><bean:write name="dat" property="date" /></center></td>
				<td><center><bean:write name="dat" property="remarks" /></center></td>
				
			</tr>
		</logic:iterate>
	</table>
</body>
</html>