package net.caimito.mealplanner.navigation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	
    @GetMapping("/")
    public String getNavigation(Model model) {
    		return "navigation/navigation";
    }
    
}
