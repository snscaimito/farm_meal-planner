package net.caimito;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import net.caimito.recipe.Recipe;

@Component
public class FakeHolder {

	private CookingJob cookingJob ;
	private Map<String, Recipe> recipes = new HashMap<>() ;
	
	public CookingJob getCookingJob() {
		return cookingJob;
	}
	
	public void setCookingJob(CookingJob cookingJob) {
		this.cookingJob = cookingJob;
	}
	
	public Map<String, Recipe> getRecipes() {
		return recipes;
	}
	
}
