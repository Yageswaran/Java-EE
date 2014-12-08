<%@page import="com.sicmsb.bean.SicmsbTb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<script>
	function submitAdd(form) {
		form.submit();
	}

	function goDetail(id) {
		var myform = document['HiddenForm'];
		myform['id'].value = id;
		myform.submit();
	}

	function update(id) {
		var form = document['Hidden'];
		form['id'].value = id;
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Search here</title>
</head>
<%-- <tiles:insert definition="company-template" ></tiles:insert> --%>
<body>


	<form name="HiddenForm" action="Action.do?method=Details" method="post">
		<input type="hidden" name="id" />
	</form>
	<form name="Hidden" action="Action.do?method=preUpdate" method="post">
		<input type="hidden" name="id" />
	</form>

	


	<form action="Action.do?method=Search" method="post">

		<table cellpadding="3pt" align="center">
			<tr>
				<td><h1>Search in Database :</h1>
			</tr>
			<tr>
				<td>Insert Name : <html:text name="SicmsbForm" property="name"
						size="30"></html:text></td>
			</tr>
			<tr>

				<td><input type="button" value="Search"
					onclick="this.disabled=true; submitAdd(this.form)" />
			</tr>


		</table>
		<p />

	</form>

	<hr />
	<table border="1" align="center">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Department</th>
			<th>Hometown</th>
			<th>Edit</th>
		</tr>

		<logic:iterate id="sic" name="listSicmsb"
			type="com.sicmsb.bean.SicmsbTb">
			<tr>
				<td><a onclick="goDetail('<%=sic.getId()%>')"> <bean:write
							name="sic" property="name" />
				</a>
				<td><bean:write name="sic" property="email" />
				<td><bean:write name="sic" property="phone" />
				<td><bean:write name="sic" property="department" />
				<td><bean:write name="sic" property="hometown" />
				<td><a onclick="update('<%=sic.getId()%>')">Edit</a>
			</tr>
		</logic:iterate>
	</table>



</body>

</html>