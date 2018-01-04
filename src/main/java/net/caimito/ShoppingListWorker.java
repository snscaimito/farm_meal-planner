package net.caimito;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.caimito.recipe.Recipe;

public class ShoppingListWorker {
	private static Logger logger = LoggerFactory.getLogger(ShoppingListWorker.class) ;
	
	private FakeHolder fakeHolder;
	
	public ShoppingListWorker(FakeHolder fakeHolder) {
		this.fakeHolder = fakeHolder ;
	}

	public List<String> compileItems(MealPlan mealPlan) {
		List<String> items = new ArrayList<String>() ;
		
		List<Ingredient> combinedIngredients = new ArrayList<>() ;
		for (String recipeID : mealPlan.getAssignedRecipeIDs()) {
			Recipe recipe = fakeHolder.getRecipes().get(recipeID) ;
			if (recipe != null)
				combinedIngredients.addAll(recipe.getIngredients()) ;
		}

		IngredientsCollector collector = new IngredientsCollector() ;
		for (Ingredient ingredient : collector.collect(combinedIngredients)) {
			items.add(String.format("%s %s %s", ingredient.getQuantity(), ingredient.getUnit(), ingredient.getName())) ;
		}

		return items ;
	}

}
