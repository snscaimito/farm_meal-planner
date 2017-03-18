package net.caimito.mealplanner;

import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MealPlannerTest {

	@Test
	public void emptyShoppingList() {
		MealPlanner mealPlanner = new MealPlanner() ;
		
		assertThat(mealPlanner.createShoppingList(), emptyCollectionOf(Ingredient.class));
	}
}
