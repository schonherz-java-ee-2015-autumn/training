
  $(function() {
	  $('#leftColumn').css('overflow','visible');
    $( "#navcolumn ul" ).menu({
      items: "> :not(.ui-widget-header)"
    });
  });

$( document ).ready(function() {
   $.each(  $('div.section h2') , function(  key,value ) {
	   console.log(key);
	   if(key>0){
			$( value).insertBefore($(value).parent());
		 }else{
			 $( value).addClass('ui-state-default ui-corner-all');
		$( value).parent().insertBefore($(value).parent().parent());
		 }
		});
	
	$('#contentBox script').remove();
		
	$('#contentBox p a').parent().remove();
		
	$('#h3').addClass('ui-state-default ui-corner-all');
	
	$( "#contentBox" ).accordion(
		{
		heightStyle: "content",
		animate: 1000
		}
		);
	
	$.each(  $('tbody') , function(  key,value ) {
	$($("tr",value)[0]).insertBefore($($("tr",value)[0]).parent());
	
	});
	
	$.each(  $('table') , function(  key,value ) {
		
	$($("tr",value)[0]).wrap(function() {
		return "<thead>" + $( this ).html() + "</thead>";
	});
	$($("tr",value)[0]).remove();
	});
	 $('table').DataTable();
	 
	 $.each(  $('link') , function(  key,value ) {
	var href=$(value).attr('href');
	if(href.indexOf('smoothness')>0){
	$(value).attr('href',href.replace('smoothness','start'));	
	}
	});
	 
});