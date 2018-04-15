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

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
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

	@GetMapping("/{id}")
	public String getRecipe(@PathVariable("id") String id, Model model) {
		Recipe recipe = repository.findById(id) ;

		model.addAttribute("recipe", recipe) ;
		model.addAttribute("recipeName", recipe.getName()) ;
		
    		return Views.RECIPES_VIEW;
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<Recipe> deleteRecipe(@PathVariable("id") String id) {
		repository.deleteById(id) ;
		return new ResponseEntity<>(HttpStatus.OK) ;
    }

}
