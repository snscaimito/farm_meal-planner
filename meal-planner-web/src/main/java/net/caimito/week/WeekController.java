package net.caimito.week;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class WeekController {

    @GetMapping("/week/index.html")
    String index() {
        return "week/index";
    }

}
