package net.integration;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import net.caimito.FakeHolder;
import net.caimito.recipe.Recipe;
import net.caimito.recipe.RecipesController;

public class RecipeControllerTest {

	@Test
	public void searchRecipes() {
		Recipe recipe = new Recipe() ;
		recipe.setName("Eggs");
		recipe.setDescription("5 Minute boiled Eggs");
		
		RecipesController recipeController = new RecipesController(new FakeHolder()) ;
		recipeController.addRecipe(recipe) ;
		
		assertThat(recipeController.searchRecipes(""), is(empty())) ;
	}
}
