<%@ tag language="java" pageEncoding="ISO-8859-1" display-name="date"%>
<%@ attribute name="dateFormat" description="Date Format" required="false"%>
<%@ attribute name="id" description="Id" required="true"%>
<%@ attribute name="name" description="Name" required="true"%>

<input type="text" id="${id}" name="${name}">

<script>
	$(function() {
		$("#${id}").datepicker({
			dateFormat : "${empty dateFormat ?  'dd.mm.yy' : dateFormat}"
		});
	});
</script>