package net.caimito.mealplanner;

import java.util.ArrayList;
import java.util.Collection;

public class MealPlanner {
	private Collection<Recipe> recipes = new ArrayList<Recipe>() ;

	public Collection<Ingredient> createShoppingList() {
		Collection<Ingredient> shoppingList = new ArrayList<Ingredient>();
		
		for (Recipe recipe : recipes) {
			for (Ingredient ingredient : recipe.getIngredients()) {
				shoppingList.add(ingredient) ;
			}
		}
		
		return shoppingList ;
	}

	public void addRecipe(Recipe recipe) {
		recipes.add(recipe) ;
	}

}
