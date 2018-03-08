package net.caimito.mealplanner.navigation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class NavigationController {
    @RequestMapping("/navigation")
    public String getNavigation(Model model) {
    		return "navigation/navigation";
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(NavigationController.class, args);
    }
}
