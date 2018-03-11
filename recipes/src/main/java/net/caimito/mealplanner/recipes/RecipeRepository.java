package net.caimito.mealplanner.recipes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class RecipeRepository {
	
	private Map<String, Recipe> recipes = new HashMap<>() ;

	public void add(Recipe recipe) {
		recipes.put(recipe.getId().toString(), recipe) ;
	}

	public Collection<Recipe> listAll() {
		return recipes.values();
	}

	public Recipe findById(String id) {
		return recipes.get(id);
	}

	public void deleteAll() {
		recipes.clear();
	}

}
