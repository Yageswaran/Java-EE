<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function Generate(form) {
		form.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<html:form action="/Excel.do?method=Excel">
		<table align="center">
			<tr>
				<td>Month :</td>
				<td><html:text name="SicmsbExcel" property="month" size="30"></html:text></td>
			</tr>
			<tr>
				<td>Year :</td>
				<td><html:text name="SicmsbExcel" property="year" size="30"></html:text></td>
			</tr>


			<tr>

				<td align="center"><input type="button" value="Generate"
					onclick="this.disabled=true; Generate(this.form)" />
			</tr>
		</table>
	</html:form>


</body>
</html>