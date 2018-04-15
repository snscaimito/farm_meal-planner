package net.caimito.mealplanner.recipes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/edit")
public class EditRecipeController {

	@Autowired
	private RecipeRepository repository ;

	@GetMapping("/{id}")
	public String getRecipe(@PathVariable("id") String id, Model model) {
		Recipe recipe = repository.findById(id) ;
		model.addAttribute("recipe", recipe) ;
    		return Views.RECIPES_EDIT;
    }

	@PostMapping("/{id}")
    public RedirectView submit(@ModelAttribute Recipe recipe) {
		repository.update(recipe) ;
		return new RedirectView(String.format("/%s", recipe.getId()), true);
    }

	@RequestMapping(value="/{id}", params={"addRow"})
	public String addRow(final Recipe recipe, final BindingResult bindingResult) {
	    recipe.getIngredients().add(new Ingredient());
		return Views.RECIPES_EDIT;
	}
	
	@RequestMapping(value="/{id}", params={"removeRow"})
	public String removeRow(
	        final Recipe recipe, final BindingResult bindingResult, 
	        final HttpServletRequest req) {
	    final Integer rowId = Integer.parseInt(req.getParameter("removeRow"));
	    recipe.getIngredients().remove(rowId.intValue());
		return Views.RECIPES_EDIT;
	}


}
