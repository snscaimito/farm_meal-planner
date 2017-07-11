package net.caimito;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

import net.caimito.recipe.Recipe;

public class ShoppingListWorkerTest {

	@Test
	public void compileShoppingListBasedOnMealPlan() {
		Recipe eggRecipe = new Recipe() ;
		eggRecipe.setIngredients(Arrays.asList(new Ingredient[]{ new Ingredient("1 Egg") }));
		
		MealPlan mealPlan = new MealPlan() ;
		mealPlan.add(Calendar.MONDAY, MealEvent.BREAKFAST, eggRecipe) ;
		
		ShoppingListWorker worker = new ShoppingListWorker() ;
		assertThat(worker.compileItems(mealPlan), hasItem("1 Egg")) ;
	}
	
	@Test
	public void compileNotNullShoppingList() {
		MealPlan mealPlan = new MealPlan() ;

		ShoppingListWorker worker = new ShoppingListWorker() ;
		assertThat(worker.compileItems(mealPlan), is(not(nullValue()))) ;
	}
}
