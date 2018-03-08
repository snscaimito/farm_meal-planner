package net.caimito.mealplanner.recipes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddRecipeController {

	@RequestMapping("/add")
	public String addRecipe() {
    		return "recipes/add";
    }

}
