<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	System.out.println("JSP: Result.jsp ");
%>
<body>
	<table>
		<tr>
			<th>Expression</th>
			<th>Value</th>
			<th>Expression</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>request.getAttribute("requestValue")</td>
			<td><%=request.getAttribute("requestValue")%></td>

			<td>$ {requestScope.requestValue}</td>
			<td>${requestScope.requestValue}</td>
		</tr>
		<tr>
			<td>session.getAttribute("sessionValue")</td>
			<td><%=session.getAttribute("sessionValue")%></td>
			<td>$ {sessionScope.sessionValue}</td>
			<td>${sessionScope.sessionValue}</td>
		</tr>
		<tr>
			<td>config.getServletContext().getAttribute("contextValue")</td>
			<td><%=config.getServletContext().getAttribute("contextValue")%></td>
			<td>$ {applicationScope.contextValue}</td>
			<td>${applicationScope.contextValue}</td>
		</tr>
	</table>



</body>
</html>