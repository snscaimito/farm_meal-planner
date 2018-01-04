package net.caimito;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import net.caimito.recipe.Recipe;

@Component
public class FakeHolder {

	private MealPlan mealPlan = new MealPlan();
	private Map<String, Recipe> recipes = new HashMap<>();

	public MealPlan getMealPlan() {
		return mealPlan;
	}

	public Map<String, Recipe> getRecipes() {
		return recipes;
	}

}
