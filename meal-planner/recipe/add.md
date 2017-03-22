---
layout: main
title: Add Recipe
---
# Add your recipe

## Recipe overview

<form id="recipeOverview">
	<label for="recipeName">Recipe name</label>
	<input type="text" name="recipeName"/><br/>
	
	<label for="recipeIntroduction">Introduction</label> 
	<textarea id="recipeIntroduction" rows="5" cols="50"></textarea><br/>
</form>
	
## Ingredients

<ul id="ingredientsList"></ul>

<form id="ingredientsForm">	
	<label>Ingredient</label>
	<input type="text" class="focusOnNext" name="ingredientQuantity" size="4"/>
	<input type="text" class="focusOnNext" name="ingredientUnit" size="10" placeholder="unit"/>	
	<input type="text" class="focusOnNext submit" name="ingredientName" size="30" placeholder="ingredient name"/>	
	<input type="button" value="Add Ingredient" id="addIngredient"/><br/>
</form>

## Instructions

<ul id="instructionsList"></ul>

<form id="instructionForm">
	<label for="instruction">Instruction</label> 
	<textarea id="instruction" rows="5" cols="50"></textarea>
	<input type="button" value="Add Instruction" id="addInstruction"/><br/>
</form>

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
		$('#ingredientsList').append('<li>' +
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
		$("#instructionsList").append('<li>' +
			$('#instructionForm #instruction').val() +
			'</li>');
	});
	
	$("#saveRecipe").click(function(){
		alert($("#recipeOverview input[name=recipeName]").val() +
		' ' + $("#recipeOverview #recipeIntroduction").val() +
		' ' + $("#ingredientsList").text() +
		' ' + $("#instructionsList").text());
	});

});
</script>
