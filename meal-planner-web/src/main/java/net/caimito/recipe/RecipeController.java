package net.caimito.recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {
	private final Logger logger = LoggerFactory.getLogger(RecipeController.class) ;

	private Map<String, Recipe> recipes = new HashMap<>() ;
	
	@RequestMapping(value="/recipe", method=RequestMethod.PUT)
	public Recipe addRecipe(@RequestBody Recipe recipe) {
		logger.info(recipe.toString());
		recipes.put(recipe.getName(), recipe) ;
		return recipe ;
		/*
		 * TODO: Store incoming recipes as JSON in Solr
		 */
	}

	@RequestMapping(value="/recipe/search", method=RequestMethod.GET)
	public List<Recipe> searchRecipes(@RequestParam(name="term", required = true) String searchTerm) {
		logger.info(searchTerm);
		List<Recipe> recipesFound = new ArrayList<>() ;
		
		/*
		 * TODO: Query Solr and obtain recipe data
		 */
		
		if (searchTerm.isEmpty())
			return recipesFound ;
		
		for (Recipe recipe : recipes.values()) {
				if (recipe.getName().contains(searchTerm))
					recipesFound.add(recipe) ;
				else if (recipe.getDescription().contains(searchTerm))
					recipesFound.add(recipe) ;
		}
		
		return recipesFound ;
	}
}
