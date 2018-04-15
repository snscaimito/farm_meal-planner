package net.caimito.mealplanner.main;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import net.caimito.mealplanner.recipes.Recipe;

@Controller
@RequestMapping("/")
public class MainPageController {
	private static final Logger logger = LoggerFactory.getLogger(MainPageController.class) ;
	
	@Autowired
	private RestTemplate restTemplate ;
	
	public MainPageController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate ;
	}
	
	private String mainApplicationURL = null ;

	// APPLICATION_URL is an environment variable and indicates where the app is running as seen from the outside
	@ModelAttribute("mainApplicationURL")
	public String getMainApplicationURL() {
		if (mainApplicationURL == null) {
			mainApplicationURL = System.getenv("APPLICATION_URL") ;
		}
			
		return mainApplicationURL ;
	}
	
	@GetMapping
	public String getFeaturedRecipes(Model model) {
		// http://recipes:8080 refers to intra-container networking
		// TODO move this into some configuration or service discovery (Docker swarm mode may already do it)
		String url = "http://recipes:8080/recipes/api/recipes/" ;
		try {
			Collection<Recipe> recipes = restTemplate.getForObject(url, Collection.class) ;
			model.addAttribute("recipes", recipes) ;
		} catch (ResourceAccessException e) {
			logger.warn("Retrieval of recipes from {} failed", url, e) ;
			model.addAttribute("recipes", new ArrayList<>()) ;
		}
		return "main/welcome";
	}
}
