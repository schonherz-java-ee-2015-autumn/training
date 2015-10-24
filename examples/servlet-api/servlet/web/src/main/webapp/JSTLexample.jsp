<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:import url="/include/includeWithParam.jsp" var="jspPage" scope="page">
		<c:param value="Hello" name="message"></c:param>
	</c:import>

	from java:	<%=pageContext.getAttribute("jspPage")%>
	<br/>
	from jstl:	<c:out value="${jspPage}"></c:out>

	<hr>
	<c:forEach var="i" begin="1" end="5">
   Item <c:out value="${i}" />
		<br />
	</c:forEach>
	<hr>
	<%
		ArrayList<Date> arrayList = new ArrayList<Date>();
		arrayList.add(new Date(112, 10, 1));
		arrayList.add(new Date());
		arrayList.add(new Date());
		arrayList.add(new Date());
		arrayList.add(new Date(2012, 10, 1));
		pageContext.setAttribute("list", arrayList);
	%>

	<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>

	<c:forEach var="item" items="${list}">
  		Item: <c:out value="${item}" />
		<br />
		<c:choose>
			<c:when test="${item <date}">
				<font color="red"> Item formatted: 
				<fmt:formatDate pattern="yyyy.MM.dd" value="${item}" />
				</font>
			</c:when>
			<c:when test="${item >date}">
				<font color="green"> Item formatted: <fmt:formatDate pattern="yyyy.MM.dd" value="${item}" />
				</font>
			</c:when>
			<c:otherwise>
      			Item formatted: <fmt:formatDate pattern="yyyy.MM.dd" value="${item}" />
			</c:otherwise>
		</c:choose>

		<fmt:formatDate pattern="yyyy.MM.dd" value="${item}" var="currentFormattedDate" />

		<fmt:formatDate pattern="yyyy.MM.dd" value="${date}" var="formattedDate" />


		<c:if test="${formattedDate eq currentFormattedDate}">
			<font color="blue">${date} </font>
		</c:if>

		<br />
	</c:forEach>
</body>
</html>