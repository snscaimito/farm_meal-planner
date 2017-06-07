package net.caimito.recipe;

import java.util.ArrayList;
import java.util.List;

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

	@RequestMapping(value="/recipe", method=RequestMethod.PUT)
	public Recipe addRecipe(@RequestBody Recipe recipe) {
		logger.info(recipe.toString());
		return recipe ;
	}

	@RequestMapping(value="/recipe/search", method=RequestMethod.GET)
	public List<Recipe> searchRecipes(@RequestParam(name="term", required = true) String searchTerm) {
		Recipe recipe = new Recipe() ;
		recipe.setName("Mexican Omelette");
		recipe.setDescription("Wonderful thing from Mexico");
		recipe.setYield("1 person");
		
		List<Recipe> recipes = new ArrayList<>() ;
		recipes.add(recipe) ;
		
		return recipes ;
	}
}
