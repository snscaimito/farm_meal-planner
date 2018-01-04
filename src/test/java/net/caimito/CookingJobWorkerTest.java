package net.caimito;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import net.caimito.recipe.Recipe;

public class CookingJobWorkerTest {

	@Test
	public void emptyCookingJob() {
		MealPlan mealPlan = new MealPlan();
		CookingJob job = new CookingJob();

		CookingJobWorker worker = new CookingJobWorker();
		worker.assignJobToMealPlan(mealPlan, job);
		assertThat(mealPlan.getAssignedRecipeIDs(), is(empty())) ;
	}

	@Test
	public void addCookingJobToMealPlan() {
		Recipe recipe = new Recipe();

		Map<String, List<String>> schedule = new HashMap<>();
		schedule.put("monday", new ArrayList<>());
		schedule.get("monday").add("breakfast");

		CookingJob job = new CookingJob();
		job.setRecipeID(recipe.getId());
		job.setSchedule(schedule);

		MealPlan mealPlan = new MealPlan();

		CookingJobWorker worker = new CookingJobWorker();
		worker.assignJobToMealPlan(mealPlan, job);
		assertThat(mealPlan.getAssignedRecipeIDs(), hasItem(recipe.getId()));
	}

}
