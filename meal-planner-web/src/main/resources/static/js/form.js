$(document).ready(function(){
	
	$(".editable").click(function(){
		var element = $(this);
		var inputField = null ;
		
		if ($(element).prop("tagName").toUpperCase() === "P") {
			inputField = document.createElement("textarea");
			$(inputField).attr("rows", "2") ;
			$(inputField).attr("cols", "50") ;
		} else {
			inputField = document.createElement("input");
			inputField.type = "text";
		}
		
		if (!$(element).hasClass("defaultValue"))
			inputField.value = $(element).text();
		
		$.each($(this).prop("attributes"), function() {
		    $(inputField).attr(this.name, this.value);
		});

		$(inputField).removeClass("editable");
		$(inputField).removeClass("defaultValue");
		
		$(inputField).blur(function(){
			$(element).text($(inputField).val());
			$(element).removeClass("defaultValue");
			$(inputField).remove();
			$(element).show();
		});
		
		$(element).hide();
		$(element).after(inputField);
		$(inputField).focus();
	}) ;

});
