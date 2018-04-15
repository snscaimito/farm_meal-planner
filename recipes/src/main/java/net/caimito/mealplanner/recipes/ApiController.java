package net.caimito.mealplanner.recipes;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/api/recipes")
public class ApiController {
	
	@Autowired
	private RecipeRepository repository ;


	@GetMapping(produces = "application/json")
	public ResponseEntity<Collection<Recipe>> getAllRecipesJson() {
    		return new ResponseEntity<>(repository.listAll(), HttpStatus.OK) ;
    }

	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<Recipe> getRecipeJson(@PathVariable("id") String id, Model model) {
		Recipe recipe =  repository.findById(id) ;
		
		if (recipe == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
		else
			return new ResponseEntity<>(recipe, HttpStatus.OK) ;
    }
	
	@DeleteMapping(produces = "application/json")
	public ResponseEntity<Recipe> deleteRecipes() {
		repository.deleteAll() ;
		return new ResponseEntity<>(HttpStatus.OK) ;
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<Recipe> putRecipe(@RequestBody Recipe recipe) {
		String id = repository.add(recipe).toString() ;
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/api/recipes/{id}")
				.buildAndExpand(id).toUri();

		return ResponseEntity.created(location).build();
	}

}
