<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
 <script>
	function submit(form) {
		form.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="File.do?method=UploadFilee" method="post"
		enctype="multipart/form-data">
		<table align="center">
		<tr>
		<td><h1>File Uploader:</h1>
		</tr>
			<tr>
				<td>Select File: <input type="file" name="file" /><br /></td>
			<tr>
			<tr>
				<td></td>
			<tr>
				<td><input type="button" value="Upload"
					onclick="this.disabled=true; submit(this.form)" /></td>
		</table>
	</form>
</body>
</html> 