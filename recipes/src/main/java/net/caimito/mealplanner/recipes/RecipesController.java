package net.caimito.mealplanner.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAutoConfiguration
@RequestMapping("/")
public class RecipesController {

	@RequestMapping(method=RequestMethod.GET)
	public String getNavigation(Model model) {
    		return "recipes/list";
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(RecipesController.class, args);
    }
}
