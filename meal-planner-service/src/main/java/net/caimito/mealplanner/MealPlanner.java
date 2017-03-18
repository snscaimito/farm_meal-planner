package net.caimito.mealplanner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MealPlanner {
	private Collection<Recipe> recipes = new ArrayList<Recipe>() ;

	public Set<Ingredient> createShoppingList() {
		Set<Ingredient> shoppingList = new HashSet<Ingredient>();
		
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
