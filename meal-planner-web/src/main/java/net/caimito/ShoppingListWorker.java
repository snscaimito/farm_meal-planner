package net.caimito;

import java.util.ArrayList;
import java.util.List;

import net.caimito.recipe.Recipe;

public class ShoppingListWorker {

	public List<String> compileItems(MealPlan mealPlan) {
		List<String> items = new ArrayList<String>() ;
		
		for (Recipe recipe : mealPlan.getAssignedRecipes()) {
			for (Ingredient ingredient : recipe.getIngredients()) {
				items.add(ingredient.getName()) ;
			}
		}
		return items ;
	}

}
