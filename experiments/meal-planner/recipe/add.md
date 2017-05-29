---
layout: main
title: Add Recipe
---

<div itemscope itemtype="http://schema.org/Recipe">
	<p itemprop="name" class="recipeName editable defaultValue">The name of your recipe</p>
	<p itemprop="description" class="editable defaultValue">Describe your recipe</p>
	<p>Yield: <span itemprop="recipeYield" class="editable defaultValue">For how many people</span></p>
	
	<p>Ingredients</p>
	<ul id="ingredientsList"></ul>
	<div id="ingredientsForm">	
		<input type="text" class="focusOnNext" name="ingredientQuantity" size="4" placeholder="qty"/>
		<input type="text" class="focusOnNext" name="ingredientUnit" size="10" placeholder="unit"/>	
		<input type="text" class="focusOnNext submit" name="ingredientName" size="30" placeholder="ingredient name"/>	
		<input type="button" value="Add Ingredient" id="addIngredient"/><br/>
	</div>
	
	<p>Instructions</p>
	<ul id="instructionsList"></ul>
	<div id="instructionForm">
		<textarea id="instruction" rows="4" cols="50" placeholder="Describe step by step how to cook this"></textarea>
		<input type="button" value="Add step" id="addInstruction"/>
	</div>
</div>

<input type="button" value="Save" id="saveRecipe"/>

<script>
$(document).ready(function(){
	
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
</script>