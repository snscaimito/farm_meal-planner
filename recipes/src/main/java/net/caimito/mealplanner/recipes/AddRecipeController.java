package net.caimito.mealplanner.recipes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping(params={"addRow"})
	public String addRow(final Recipe recipe, final BindingResult bindingResult) {
	    recipe.getIngredients().add(new Ingredient());
		return "recipes/add";
	}
	
	@RequestMapping(params={"removeRow"})
	public String removeRow(
	        final Recipe recipe, final BindingResult bindingResult, 
	        final HttpServletRequest req) {
	    final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
	    recipe.getIngredients().remove(rowId.intValue());
	    return "recipes/add";
	}

}
