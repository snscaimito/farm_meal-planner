package net.caimito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	private final Logger logger = LoggerFactory.getLogger(RecipeController.class) ;

	@RequestMapping(method=RequestMethod.PUT)
	public Recipe addRecipe(@RequestBody Recipe recipe) {
		logger.info(recipe.toString());
		return recipe ;
	}
}
