package net.caimito.mealplanner.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/add")
public class AddRecipeController {
	
	@Autowired
	private RecipeRepository repository ;

	@GetMapping
	public String addRecipe(Model model) {
		model.addAttribute("recipe", new Recipe()) ;
    		return "recipes/add";
    }
	
	@PostMapping
    public RedirectView submit(@ModelAttribute Recipe recipe) {
		repository.add(recipe) ;
		return new RedirectView("./");
    }


}
