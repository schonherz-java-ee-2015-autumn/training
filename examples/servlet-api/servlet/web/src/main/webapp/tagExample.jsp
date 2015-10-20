<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="custom" uri="WEB-INF/customTag.tld"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<custom:hello />
	<br />
	<custom:helloAttr text="attribut" />
	<br />
	<tags:customJSPTag />
	<br />
	<tags:customJSPTagWithAttribute text="Hello Attribute" />
	<tags:customJSPTagWithAttribute text="Hello Attribute" />
	<br />
</body>
</html>