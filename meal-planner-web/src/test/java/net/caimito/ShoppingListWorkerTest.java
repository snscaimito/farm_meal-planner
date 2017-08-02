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
	
	private FakeHolder fakeHolder = new FakeHolder() ;

	@Test
	public void compileShoppingListBasedOnMealPlan() {
		Recipe eggRecipe = new Recipe() ;
		eggRecipe.setIngredients(Arrays.asList(new Ingredient[]{ new Ingredient(1, "pcs", "Egg") }));
		fakeHolder.getRecipes().put(eggRecipe.getId(), eggRecipe) ;
		
		MealPlan mealPlan = new MealPlan() ;
		mealPlan.add(WeekDays.MONDAY, MealEvent.BREAKFAST, eggRecipe.getId()) ;
		mealPlan.add(WeekDays.TUESDAY, MealEvent.BREAKFAST, eggRecipe.getId()) ;
		
		ShoppingListWorker worker = new ShoppingListWorker(fakeHolder) ;
		assertThat(worker.compileItems(mealPlan), hasItem("2 pcs Egg")) ;
	}
	
	@Test
	public void compileNotNullShoppingList() {
		MealPlan mealPlan = new MealPlan() ;

		ShoppingListWorker worker = new ShoppingListWorker(fakeHolder) ;
		assertThat(worker.compileItems(mealPlan), is(not(nullValue()))) ;
	}
}
