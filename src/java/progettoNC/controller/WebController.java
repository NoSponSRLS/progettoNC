package progettoNC.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
@ComponentScan("progettoNC.service")
public class WebController {
    
    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }
    
}