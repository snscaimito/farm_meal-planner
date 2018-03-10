package net.caimito.mealplanner.recipes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonView;

@Controller
@RequestMapping("/")
public class RecipesController {

	@Autowired
	private RecipeRepository repository ;

	@RequestMapping(method=RequestMethod.GET)
	public String getNavigation(Model model) {
		model.addAttribute("recipes", repository.listAll()) ;
    		return "recipes/list";
    }

	@RequestMapping(method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<Recipe>> getAllRecipes() {
    		return new ResponseEntity<>(repository.listAll(), HttpStatus.OK) ;
    }

}
