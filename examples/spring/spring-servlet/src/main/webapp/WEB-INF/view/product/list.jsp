<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
<h1>Available products</h1>
<c:if test="${not empty products}">
	<ul>
		<c:forEach var="product" items="${products}">
			<li>
				<strong><c:out value="${product.longName}"/></strong> / <c:out value="${product.shortName}"/>
			</li>
		</c:forEach>
	</ul>
</c:if>
</body>
</html>