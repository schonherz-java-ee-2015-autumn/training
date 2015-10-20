<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	Simple Date Tag:	<tags:dateTag id="a" name="a"></tags:dateTag>
	<br/>
	Fomated Date Tag:   <tags:dateTag id="b" name="b" dateFormat="yy.mm.dd"></tags:dateTag>
	<br/>
	Country Tag: 	<tags:country name="c" id="c"></tags:country>
	<br/>
</body>
</html>