<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul><%!  %>
		<li>
			<jsp:include page="/include/includeWithParam.jsp">
				<jsp:param value="Hello" name="message" />
			</jsp:include>
		</li>
		<li>
		<%
			
			
			%> 
			<jsp:useBean id="date"  class="java.util.Date"></jsp:useBean>
			<jsp:getProperty property="time" name="date" />
			
		</li>
		<li>
			<jsp:useBean id="formatter" class="java.text.SimpleDateFormat"></jsp:useBean> 
			
		formated date	${formatter.format(date)}
		</li>
		
		<li>
			<%
			
				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy.MM.dd");
				pageContext.setAttribute("formatter2", formatter2);
			%> 
			
			${formatter2.format(date)}
			
			<%out.print(formatter2.format(date));%>
			
			<%=formatter2.format(date)%>
		</li>
		
		<li>
			<jsp:useBean id="bean" class="hu.neuron.java.bean.Bean">
				<jsp:setProperty property="date" name="bean" value="${date}"/>
				<jsp:setProperty property="text" name="bean" value="${formatter2.format(date)}"/>
			</jsp:useBean>
			date: <jsp:getProperty property="date" name="bean" />
			text: <jsp:getProperty property="text" name="bean" />
		</li>
	</ul>
</body>
</html>