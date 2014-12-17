<%@page import="java.util.*,java.text.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
<title>Print a month page.</title>
</head>
<script>
	function go(i) {
		var form = document['HiddenForm'];
		//String d = (i + j + k);
		form['date'].value = i;
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
<body bgcolor="Silver">
    <h3>Welcome! <bean:write name="SicmsbCalendarForm" property="username"></bean:write>!</h3>

	<form name="HiddenForm" action="Calendar.do?method=Remark"
		method="post">
		<input type="hidden" name="date" />
	</form>
	<%
		boolean yyok = false;
		int yy = 0, mm = 0;
		String yyString = request.getParameter("year");
		if (yyString != null && yyString.length() > 0) {
			try {
				yy = Integer.parseInt(yyString);
				yyok = true;
			} catch (NumberFormatException e) {
				//out.println("Year " + yyString + " invalid");
			}
		}
		Calendar c = Calendar.getInstance();
		if (!yyok)
			yy = c.get(Calendar.YEAR);
		mm = c.get(Calendar.MONTH);
		//out.println("YY==" + yy + ",MM==" + mm);
	%>

	<%-- <form method=post action="Calendar.jsp">
		Enter Year : <input type="text" size="5" name="year"
			value=" <%=yy%>"></input> <input type=submit value="Display">
	</form> --%><%!String[] months = { "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" };

	int dom[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };%>
	<%
		int leadGap = 0;
	%>
	<table border=1 align="center">
		<%
			for (int j = 0; j < 12; j++) {
				GregorianCalendar calendar = new GregorianCalendar(yy, j, 1);
		%>
		
		
		<tr>
			<th colspan=7><%=months[j]%> <%=yy%>
		</tr>
		<tr>
			<td>Sunday
			<td>Monday
			<td>Tuesday
			<td>Wednesday
			<td>Thursday
			<td>Friday
			<td>Saturday
		</tr>
		<%
			leadGap = calendar.get(Calendar.DAY_OF_WEEK) - 1;
				int daysInMonth = dom[j];
				if (calendar.isLeapYear(calendar.get(Calendar.YEAR)) && j == 1)
					++daysInMonth;
				out.print("<tr>");
				out.println(" ");
				for (int i = 0; i < leadGap; i++) {
					out.print("<td> ");
				}
				for (int i = 1; i <= daysInMonth; i++) {
					//out.print("<td>");
		%>
		<td><a onclick="go('<%=i%> <%=months[j]%> <%=yy%>')"> <%
 	out.print(i);
 %>
		</a> <%
 	out.print("</td>");
 			if ((leadGap + i) % 7 == 0) {
 				out.println("</tr>");
 				out.print("<tr>");
 			}
 		}
 	}
 %>
		</tr>
	</table>
</html>
