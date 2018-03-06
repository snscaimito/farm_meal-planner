package net.caimito.recipe;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RecipeRepository {

	private Map<String, Recipe> database = new HashMap<>() ;

	public String store(RecipeIn recipeIn) {
		Recipe recipe = new Recipe() ;
		BeanUtils.copyProperties(recipeIn, recipe);
		database.put(recipe.getId(), recipe) ;
		
		return recipe.getId();
	}

	public Recipe findById(String recipeId) {
		return database.get(recipeId);
	}

	public Collection<Recipe> findAll() {
		return database.values();
	}

	public void deleteAll() {
		database.clear();
	}

}
