package net.caimito.mealplanner.cookbooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import net.caimito.mealplanner.recipes.Recipe;

@Controller
public class CookbookController {

	private Map<String, List<Recipe>> cookbooks = new HashMap<>() ;
	
	@GetMapping(value="/user/{userId}", produces = "application/json")
	public ResponseEntity<List<Recipe>> getCookbookJson(@PathVariable String userId) {
		List<Recipe> cookbook = cookbooks.get(userId) ;
		
		if (cookbook == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
		else
			return new ResponseEntity<>(cookbook, HttpStatus.OK) ;
	}

	@PostMapping(value="/user/{userId}/recipe", consumes = "application/json")
	public ResponseEntity<Cookbook> addRecipeToCookbook(@PathVariable String userId, @RequestBody Recipe recipe) {
		if (cookbooks.get(userId) == null)
			cookbooks.put(userId, new ArrayList<>()) ;
		
		cookbooks.get(userId).add(recipe) ;
		return new ResponseEntity<>(HttpStatus.CREATED) ;
	}
}
