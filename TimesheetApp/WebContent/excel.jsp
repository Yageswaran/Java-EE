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
				<td><h2>Please select:</h2>
			</tr>
			<tr>
				<td><html:select property="month">
						<html:option value="">-- Select Month --</html:option>
						<html:option value="1">January</html:option>
						<html:option value="2">February</html:option>
						<html:option value="3">March</html:option>
						<html:option value="4">April</html:option>
						<html:option value="5">May</html:option>
						<html:option value="6">June</html:option>
						<html:option value="7">July</html:option>
						<html:option value="8">August</html:option>
						<html:option value="9">September</html:option>
						<html:option value="10">October</html:option>
						<html:option value="11">November</html:option>
						<html:option value="12">December</html:option>
					</html:select>
			</tr>
			<tr>
				<td><html:select property="year">
						<html:option value="">-- Select Year --</html:option>
						<html:option value="2014">2014</html:option>
						<html:option value="2015">2015</html:option>
						<html:option value="2016">2016</html:option>
						<html:option value="2017">2017</html:option>
						<html:option value="2018">2018</html:option>
						<html:option value="2019">2019</html:option>
					</html:select>
			<tr>

				<td align="center"><input type="button" value="Generate"
					onclick="this.disabled=true; Generate(this.form)" />
			</tr>
			<tr>

				<td><img src="C:\\Users\\yageswaran.ramar\\Desktop\\si.png"> 
			</tr>
		</table>
	</html:form>


</body>
</html>