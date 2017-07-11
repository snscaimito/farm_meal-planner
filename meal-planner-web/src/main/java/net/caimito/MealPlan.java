package net.caimito;

import java.util.ArrayList;
import java.util.List;

import net.caimito.recipe.Recipe;

public class MealPlan {
	private List<PlanElement> planElements = new ArrayList<PlanElement>() ;

	public void add(int dayOfTheWeek, MealEvent mealEvent, Recipe recipe) {
		planElements.add(new PlanElement(dayOfTheWeek, mealEvent, recipe)) ;
	}

	private class PlanElement {
		protected int dayOfTheWeek ;
		protected MealEvent mealEvent ;
		protected Recipe recipe ;
		
		public PlanElement(int dayOfTheWeek, MealEvent mealEvent, Recipe recipe) {
			this.dayOfTheWeek = dayOfTheWeek ;
			this.mealEvent = mealEvent ;
			this.recipe = recipe ;
		}
		
	}

	public List<Recipe> getAssignedRecipes() {
		List<Recipe> recipes = new ArrayList<>();
		
		for (PlanElement element : planElements)
			recipes.add(element.recipe) ;
		
		return recipes ;
	}
}
