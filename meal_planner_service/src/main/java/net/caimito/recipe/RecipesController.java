package net.caimito.recipe;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.caimito.FakeHolder;

/*
 * The RecipeController is a self-contained service concerned only with recipes. 
 * Data storage is local.
 * 
 * In the future this service can be deployed as a Docker container and become 
 * a micro-service.
 */
@RestController
@RequestMapping("/api/recipes")
public class RecipesController {
	private final Logger logger = LoggerFactory.getLogger(RecipesController.class) ;

	@Autowired
	private RecipeRepository repository ;

	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity addRecipe(@RequestBody RecipeIn recipeIn) {
		String id = repository.store(recipeIn) ;
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(id).toUri();

		if (logger.isDebugEnabled()) {
			logger.debug(location.toASCIIString()) ;
		}
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/{recipeId}")
	public ResponseEntity<RecipeOut> getRecipe(@PathVariable String recipeId) {
		Recipe recipe = repository.findById(recipeId) ;
		if (recipe == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
		else {
			RecipeOut recipeOut = new RecipeOut() ;
			BeanUtils.copyProperties(recipe, recipeOut);
			return new ResponseEntity<>(recipeOut, HttpStatus.OK) ;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<RecipeOut> listAll() {
		Collection<RecipeOut> recipes = new ArrayList<>() ;

		for (Recipe recipe : repository.findAll()) {
			RecipeOut recipeOut = new RecipeOut() ;
			BeanUtils.copyProperties(recipe, recipeOut);
			recipes.add(recipeOut) ;
		}
		
		return recipes ;
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public void deleteAll() {
		repository.deleteAll() ;
	}

	@RequestMapping(value="/search", method=RequestMethod.GET)
	public List<RecipeOut> searchRecipes(@RequestParam(name="term", required = true) String searchTerm) {
		logger.info(searchTerm);
		List<RecipeOut> recipesFound = new ArrayList<>() ;
		
		if (searchTerm.isEmpty())
			return recipesFound ;
		
//		for (RecipeOut recipe : fakeHolder.getRecipes().values()) {
//				if (recipe.getName().contains(searchTerm))
//					recipesFound.add(recipe) ;
//				else if (recipe.getDescription().contains(searchTerm))
//					recipesFound.add(recipe) ;
//		}
		
		return recipesFound ;
	}
}
