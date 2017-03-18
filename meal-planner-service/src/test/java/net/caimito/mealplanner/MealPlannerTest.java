package net.caimito.mealplanner;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class MealPlannerTest {

	@Test
	public void emptyShoppingList() {
		MealPlanner mealPlanner = new MealPlanner() ;
		assertThat(mealPlanner.createShoppingList(), emptyCollectionOf(Ingredient.class));
	}
	
	@Test
	public void cookFrenchFries() {
		MealPlanner mealPlanner = new MealPlanner() ;
		
		mealPlanner.addRecipe(Cookbook.getRecipe(Cookbook.FRENCH_FRIES)) ;
		
		Collection<Ingredient> ingredients = mealPlanner.createShoppingList() ;
		assertThat(ingredients, hasItem(new Ingredient("Potatoes"))) ;
		assertThat(ingredients, hasItem(new Ingredient("Vegetable Oil"))) ;
	}
}
