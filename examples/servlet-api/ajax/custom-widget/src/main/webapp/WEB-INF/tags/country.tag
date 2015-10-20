<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="id" description="Id" required="true"%>
<%@ attribute name="name" description="Name" required="true"%>

 <input type="text" id="${id}" name="${name}"> <font  id="${id}_value"></font>

<script>
	$(function() {

		$("#${id}").autocomplete({
			source : "CountryServlet",
			minLength : 1,
			select : function(event, ui) {
				$("#${id}_value").html(ui.item.value);
				this.value = ui.item.label;
				return false;
			}
		});
	});
</script>