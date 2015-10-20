<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="result"></div>

	<ul>
		<li>
			<button type="button" onclick="getObjects()">getObjects</button>
		</li>

	</ul>
	<script>
		function getObjects() {
			$.ajax({
				method : "POST",
				url : 'XMLservlet',
				success : function(data) {
					
					var xmlsource=new XMLSerializer().serializeToString(data).replace(/\</g,'&lt;'); 
					$("#result").html('xml:<samp>' +xmlsource +'</samp></br>');
					console.log(new XMLSerializer().serializeToString(data));
					$(data).find('helper').each(function(i, val) {

						$("#result").append(i + " " + $(val).html() + '</br>');

						$(this).find("name").each(function() {
							var name = $(this).text();
							$("#result").append('nane: ' + name + ' ');

						});

						$(this).find("age").each(function() {
							var age = $(this).text();
							var d = new Date(age.split('CEST')[0]);
							$("#result").append(' age(date): '
									+ d.toLocaleDateString() + " age(time):"
									+ d.toLocaleTimeString());
						});

						$("#result").append('</br>');
					});

				},
				error : function(e) {

					console.log(e);

				},
				dataType : "xml"
			});

		}
	</script>
</body>
</html>