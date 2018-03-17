package net.caimito.mealplanner.main;

import java.util.Collection;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import net.caimito.mealplanner.recipes.Recipe;

@Controller
@RequestMapping("/")
public class MainPageController {
	@Autowired
	private RestTemplate restTemplate ;
	
	private String mainApplicationURL = null ;

	@ModelAttribute("mainApplicationURL")
	public String getMainApplicationURL() {
		if (mainApplicationURL == null) {
			mainApplicationURL = System.getenv("APPLICATION_URL") ;
		}
			
		return mainApplicationURL ;
	}
	
	@GetMapping
	public String getFeaturedRecipes(Model model) {
		Collection<Recipe> recipes = restTemplate.getForObject(getMainApplicationURL() + "/recipes/", Collection.class) ;
		
		model.addAttribute("recipes", recipes) ;
		return "main/welcome";
	}
}
