package net.caimito;

import java.util.ArrayList;
import java.util.List;

import net.caimito.recipe.Recipe;

public class ShoppingListWorker {

	public List<String> compileItems(MealPlan mealPlan) {
		List<String> items = new ArrayList<String>() ;
		
		List<Ingredient> combinedIngredients = new ArrayList<>() ;
		for (Recipe recipe : mealPlan.getAssignedRecipes()) {
			combinedIngredients.addAll(recipe.getIngredients()) ;
		}

		IngredientsCollector collector = new IngredientsCollector() ;
		for (Ingredient ingredient : collector.collect(combinedIngredients)) {
			items.add(String.format("%s %s %s", ingredient.getQuantity(), ingredient.getUnit(), ingredient.getName())) ;
		}

		return items ;
	}

}
