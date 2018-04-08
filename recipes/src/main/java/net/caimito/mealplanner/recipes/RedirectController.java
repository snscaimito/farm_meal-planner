package net.caimito.mealplanner.recipes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {

	@GetMapping("/login")
	public RedirectView getLogin() {
		return new RedirectView("/user/login", false) ;
	}
	
}
