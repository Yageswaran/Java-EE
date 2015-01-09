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
					<td>Date:<html:text name="SicmsbCalendarForm"
							property="date" size="10"></html:text></td>
				</tr>
				<tr>
					<%-- <td>Start Time:<html:text name="SicmsbCalendarForm" property="starttime" size="100"></html:text></td> --%>
					<td><html:select name="SicmsbCalendarForm"
							property="starttime">
							<html:option value="">-- Select Start Time --</html:option>
							<html:option value="00:00">00:00</html:option>
							<html:option value="01:00">01:00</html:option>
							<html:option value="02:00">02:00</html:option>
							<html:option value="03:00">03:00</html:option>
							<html:option value="04:00">04:00</html:option>
							<html:option value="05:00">05:00</html:option>
							<html:option value="06:00">06:00</html:option>
							<html:option value="07:00">07:00</html:option>
							<html:option value="08:00">08:00</html:option>
							<html:option value="09:00">09:00</html:option>
							<html:option value="10:00">10:00</html:option>
							<html:option value="11:00">11:00</html:option>
							<html:option value="12:00">12:00</html:option>
							<html:option value="13:00">13:00</html:option>
							<html:option value="14:00">14:00</html:option>
							<html:option value="15:00">15:00</html:option>
							<html:option value="16:00">16:00</html:option>
							<html:option value="17:00">17:00</html:option>
							<html:option value="18:00">18:00</html:option>
							<html:option value="19:00">19:00</html:option>
							<html:option value="20:00">20:00</html:option>
							<html:option value="22:00">21:00</html:option>
							<html:option value="23:00">23:00</html:option>
							<html:option value="24:00">24:00</html:option>
						</html:select>
				</tr>
				<%-- <tr>
					<td>End Date:<html:text name="SicmsbCalendarForm"
							property="enddate" size="100"></html:text></td>
				</tr> --%>
				<tr>
					<%-- <td>End Time:<html:text name="SicmsbCalendarForm"
							property="endtime" size="100"></html:text></td> --%>
					<td><html:select name="SicmsbCalendarForm"
							property="endtime">
							<html:option value="">-- Select End Time --</html:option>
							<html:option value="00:00">00:00</html:option>
							<html:option value="01:00">01:00</html:option>
							<html:option value="02:00">02:00</html:option>
							<html:option value="03:00">03:00</html:option>
							<html:option value="04:00">04:00</html:option>
							<html:option value="05:00">05:00</html:option>
							<html:option value="06:00">06:00</html:option>
							<html:option value="07:00">07:00</html:option>
							<html:option value="08:00">08:00</html:option>
							<html:option value="09:00">09:00</html:option>
							<html:option value="10:00">10:00</html:option>
							<html:option value="11:00">11:00</html:option>
							<html:option value="12:00">12:00</html:option>
							<html:option value="13:00">13:00</html:option>
							<html:option value="14:00">14:00</html:option>
							<html:option value="15:00">15:00</html:option>
							<html:option value="16:00">16:00</html:option>
							<html:option value="17:00">17:00</html:option>
							<html:option value="18:00">18:00</html:option>
							<html:option value="19:00">19:00</html:option>
							<html:option value="20:00">20:00</html:option>
							<html:option value="22:00">21:00</html:option>
							<html:option value="23:00">23:00</html:option>
							<html:option value="24:00">24:00</html:option>
						</html:select>
				</tr>
				<tr>
					<%-- <td>Remarks:<html:text name="SicmsbCalendarForm"
							property="remarks" size="10"></html:text></td> --%>
							<td><html:select name="SicmsbCalendarForm"
							property="remarks">
							<html:option value="">-- Select Event --</html:option>
							<html:option value="Annual Leave">Annual leave</html:option>
							<html:option value="Emergency leave">Emergency Leave</html:option>
							<html:option value="Vacation Leave">Vacation Leave</html:option>
							<html:option value="On-Site Work">On-Site Work</html:option>
							<html:option value="Client Meeting">Client Meeting</html:option>
							<html:option value="Meeting">Meeting</html:option>
							<html:option value="Biweekly Meeting">Biweekly Meeting</html:option>
							<html:option value="Planned Leave">Planned leave</html:option>
							<html:option value="Half-Day leave">Half-day leave</html:option>
							
						</html:select>
				</tr>

				<tr>
					<td><input type=submit value="Save"></td>
				</tr>

			</form>
	</table>
</body>
</html>