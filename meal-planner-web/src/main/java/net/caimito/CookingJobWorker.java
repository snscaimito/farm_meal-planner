package net.caimito;

public class CookingJobWorker {

	public void assignJobToMealPlan(MealPlan mealPlan, CookingJob job) {
		if (job.getSchedule() != null && !job.getSchedule().isEmpty()) {
			for (String dayOfTheWeek : job.getSchedule().keySet()) {
				for (String mealEvent : job.getSchedule().get(dayOfTheWeek)) {
					mealPlan.add(WeekDays.valueOf(dayOfTheWeek.toUpperCase()), MealEvent.valueOf(mealEvent.toUpperCase()), job.getRecipeID());
				}
			}
		}
	}

}
