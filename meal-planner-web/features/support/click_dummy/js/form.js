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

	$(document).ready(function(){
		
		$("#getStarted").click(function(){
			$('#createAction').removeClass('unavailable');
			$('#welcome').addClass('hidden');
			$('#recipeForm').removeClass('hidden');
		});
	
		$("#ingredientsForm .focusOnNext").keydown(function(e){
			if (e.which == 13) {
				$(this).next(".focusOnNext").focus();
			}
		});

		$("#ingredientsForm .submit").keydown(function(e){
			if (e.which == 13) {
				$("#addIngredient").click();
				$("#ingredientsForm input[name=ingredientQuantity]").focus();
			}
		});

		$("#addIngredient").click(function(){
			$('#ingredientsList').append('<li itemprop="recipeIngredient">' +
				$('#ingredientsForm input[name=ingredientQuantity]').val() + ' ' +
				$('#ingredientsForm input[name=ingredientUnit]').val() + ' ' +
				$('#ingredientsForm input[name=ingredientName]').val() + 
				'</li>');
			$('#ingredientsForm').trigger("reset");
		});

		$("#instructionForm #instruction").keydown(function(e){
			if (e.which == 13) {
				$("#addInstruction").click();
				$("#instructionForm #instruction").val("");
				return false;
			}
		});

		$("#addInstruction").click(function(){
			$("#instructionsList").append('<li itemprop="recipeInstructions">' +
				$('#instructionForm #instruction').val() +
				'</li>');
		});
	
		$("#saveRecipe").click(function(){
			var recipe = { 
				"recipeName": $("[itemprop=name]").text(), 
				"recipeDescription": $("[itemprop=description]").text(), 
				"recipeYield": $("[itemprop=recipeYield]").text(),
				"ingredients": [],
				"instructions": []
			} ;
		
			$.each()

			alert(JSON.stringify(recipe));
		});

	});
});
