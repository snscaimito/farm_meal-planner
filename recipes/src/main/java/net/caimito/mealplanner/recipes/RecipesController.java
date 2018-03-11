package net.caimito.mealplanner.recipes;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RecipesController {

	@Autowired
	private RecipeRepository repository ;
	
	@GetMapping
	public String getAllRecipes(Model model) {
		model.addAttribute("recipes", repository.listAll()) ;
    		return Views.RECIPES_LIST;
    }

	@GetMapping(produces = "application/json")
	public ResponseEntity<Collection<Recipe>> getAllRecipesJson() {
    		return new ResponseEntity<>(repository.listAll(), HttpStatus.OK) ;
    }

	@GetMapping("/{id}")
	public String getRecipe(@PathVariable("id") String id, Model model) {
		model.addAttribute("recipe", repository.findById(id)) ;
    		return Views.RECIPES_ADD;
    }

	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<Recipe> getRecipeJson(@PathVariable("id") String id, Model model) {
		return new ResponseEntity<>(repository.findById(id), HttpStatus.OK) ;
    }
	
	@DeleteMapping(produces = "application/json")
	public ResponseEntity<Recipe> deleteRecipes() {
		repository.deleteAll() ;
		return new ResponseEntity<>(HttpStatus.OK) ;
	}

}
