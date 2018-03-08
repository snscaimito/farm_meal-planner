package net.caimito.mealplanner.recipes;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RecipesController {

	@ModelAttribute("recipes")
	public Collection<Recipe> populateTypes() {
		Collection<Recipe> recipes = new ArrayList() ;
		recipes.add(new Recipe()) ;
		return recipes ;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getNavigation() {
    		return "recipes/list";
    }
    
}
