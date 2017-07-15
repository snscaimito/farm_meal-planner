package net.caimito;

import java.util.Calendar;

public class CookingJobWorker {

	public void assignJobToMealPlan(MealPlan mealPlan, CookingJob job) {
		for (String mealEvent : job.getMonday())
			mealPlan.add(Calendar.MONDAY, MealEvent.valueOf(mealEvent.toUpperCase()), job.getRecipeID());
	}

}
