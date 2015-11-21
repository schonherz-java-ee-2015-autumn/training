<%@ page language="java" contentType="text/html;"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Hello World!</h2>
	<a href="<c:url value='secured/secured.jsp'/>">Secured</a>
	<a href="<c:url value='j_spring_security_logout'/>" > Logout</a>
</body>
</html>
