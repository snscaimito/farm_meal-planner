package net.caimito.mealplanner.navigation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	
    @GetMapping("/")
    public String getNavigation(Model model) {
    		model.addAttribute("username", "to be done") ;
    		return "navigation/navigation";
    }
    
}
