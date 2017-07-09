package net.caimito.recipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.caimito.FakeHolder;

@RestController
@RequestMapping("/api/recipes")
public class RecipesController {
	private final Logger logger = LoggerFactory.getLogger(RecipesController.class) ;

	@Autowired
	private FakeHolder fakeHolder ;
	
	@RequestMapping(method=RequestMethod.PUT)
	public Recipe addRecipe(@RequestBody Recipe recipe) {
		recipe.setId(UUID.randomUUID().toString());
		fakeHolder.getRecipes().put(recipe.getId(), recipe) ;
		logger.info(recipe.toString());
		return recipe ;
		/*
		 * TODO: Store incoming recipes as JSON in Solr
		 */
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Recipe> listAll() {
		logger.info("listing all recipes");
		return fakeHolder.getRecipes().values() ;
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public void deleteAll() {
		logger.info("clearing recipes database");
		fakeHolder.getRecipes().clear();
	}

	@RequestMapping(value="/search", method=RequestMethod.GET)
	public List<Recipe> searchRecipes(@RequestParam(name="term", required = true) String searchTerm) {
		logger.info(searchTerm);
		List<Recipe> recipesFound = new ArrayList<>() ;
		
		/*
		 * TODO: Query Solr and obtain recipe data
		 */
		
		if (searchTerm.isEmpty())
			return recipesFound ;
		
		for (Recipe recipe : fakeHolder.getRecipes().values()) {
				if (recipe.getName().contains(searchTerm))
					recipesFound.add(recipe) ;
				else if (recipe.getDescription().contains(searchTerm))
					recipesFound.add(recipe) ;
		}
		
		return recipesFound ;
	}
}
