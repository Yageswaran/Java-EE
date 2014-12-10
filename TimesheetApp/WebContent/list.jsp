<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function getFileName(filename) {
		var fileform = document['HiddenForm'];
		fileform['fileName'].value = filename;
		fileform.submit();
	}

	function submitAdd(form) {
		form.submit();
	}
</script>
<style>
A {
	text-decoration: underline;
	color: blue;
	cursor: pointer;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="HiddenForm" action="Excel.do?method=download" method="post">
		<html:hidden property="fileName" value="" />
	</form>




	<table align="center">
		<tr>
			<td><h1>Select a file to be Downloaded:</h1></td>
		</tr>
	</table>
	<%@ page import="java.io.*"%>
	<%@ page import="org.apache.struts.upload.FormFile"%>
	<%
		File folder = new File(
				"D:\\Timesheet\\");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
	%>

	<form action="Excel.do?method=download" method="post">
		<table border="1">

			<tr>
				<td width="120%"><%=listOfFiles[i].getName()%></td>

				
				<td><a onclick="getFileName('<%=listOfFiles[i].getName()%>')">
						Download</a>
				
			</tr>

		</table>
	</form>

	<%
		}
	%>

</body>

</html>