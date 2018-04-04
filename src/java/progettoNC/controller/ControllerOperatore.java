package progettoNC.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/operatore/")
@ComponentScan("progettoNC.service")
public class ControllerOperatore {
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "indexOperatore";
    }
    
}