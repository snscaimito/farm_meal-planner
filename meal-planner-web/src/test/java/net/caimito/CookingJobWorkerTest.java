package net.caimito;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import net.caimito.recipe.Recipe;

public class CookingJobWorkerTest {
	
	@Test
	public void addCookingJobToMealPlan() {
		Recipe recipe = new Recipe() ;
		
		CookingJob job = new CookingJob() ;
		job.setRecipeID(recipe.getId());
		job.setMonday(new String[] { "breakfast", "lunch" });
		
		MealPlan mealPlan = new MealPlan() ;
		
		CookingJobWorker worker = new CookingJobWorker() ;
		worker.assignJobToMealPlan(mealPlan, job) ;
		assertThat(mealPlan.getAssignedRecipeIDs(), hasItem(recipe.getId())) ;
	}

}
