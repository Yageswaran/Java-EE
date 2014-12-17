<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title></title>
</head>
<body>
	 <table border="1"  width="100%" height="100%">
		<tr>
			<td><tiles:insert attribute="header" /></td>
		</tr>
		<tr>
			<td><tiles:insert attribute="body" /></td>
		</tr>
		<tr>
			<td><tiles:insert attribute="footer" /></td>
		</tr>
	</table>
</body>

</html>