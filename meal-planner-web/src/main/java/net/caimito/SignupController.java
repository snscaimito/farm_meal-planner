package net.caimito;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class SignupController {

    @GetMapping("/signup")
    String index() {
        return "signup";
    }

}
