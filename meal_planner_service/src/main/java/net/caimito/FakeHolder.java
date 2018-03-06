package net.caimito;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import net.caimito.recipe.RecipeOut;

@Component
public class FakeHolder {

	private MealPlan mealPlan = new MealPlan();
	private Map<String, RecipeOut> recipes = new HashMap<>();

	public MealPlan getMealPlan() {
		return mealPlan;
	}

	public Map<String, RecipeOut> getRecipes() {
		return recipes;
	}

}
