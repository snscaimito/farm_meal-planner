package net.caimito.mealplanner.recipes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class RecipeRepository {
	
	private Map<String, Recipe> recipes = new HashMap<>() ;

	public void add(Recipe recipe) {
		recipes.put(recipe.getName(), recipe) ;
	}

	public Collection<Recipe> listAll() {
		return recipes.values();
	}

}
