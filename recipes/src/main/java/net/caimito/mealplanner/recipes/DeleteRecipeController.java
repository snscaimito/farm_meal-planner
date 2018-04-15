package net.caimito.mealplanner.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/ui/delete")
public class DeleteRecipeController {

	@Autowired
	private RecipeRepository repository ;

	@GetMapping("/{id}")
	public RedirectView deleteRecipe(@PathVariable("id") String id) {
		repository.deleteById(id);
		return new RedirectView("/", true);
    }


}
