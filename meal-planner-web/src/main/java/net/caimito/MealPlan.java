package net.caimito;

import java.util.ArrayList;
import java.util.List;

import net.caimito.recipe.Recipe;

public class MealPlan {
	private List<PlanElement> planElements = new ArrayList<PlanElement>() ;

	public void add(WeekDays dayOfTheWeek, MealEvent mealEvent, String recipeID) {
		planElements.add(new PlanElement(dayOfTheWeek, mealEvent, recipeID)) ;
	}

	private class PlanElement {
		protected WeekDays dayOfTheWeek ;
		protected MealEvent mealEvent ;
		protected String recipeID ;
		
		public PlanElement(WeekDays dayOfTheWeek, MealEvent mealEvent, String recipeID) {
			this.dayOfTheWeek = dayOfTheWeek ;
			this.mealEvent = mealEvent ;
			this.recipeID = recipeID ;
		}
		
	}

	public List<String> getAssignedRecipeIDs() {
		List<String> recipeIDs = new ArrayList<>();
		
		for (PlanElement element : planElements)
			recipeIDs.add(element.recipeID) ;
		
		return recipeIDs ;
	}
}
