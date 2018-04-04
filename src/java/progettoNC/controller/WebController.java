package progettoNC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import progettoNC.model.Dipendente;
import progettoNC.service.DipendenteService;

@Controller
@RequestMapping("/")
@ComponentScan("progettoNC.service")
public class WebController {

    @Autowired
    DipendenteService service;

    public WebController() {
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = {"/check"}, params = {"matr", "pass"}, method = RequestMethod.POST)
    public String check(ModelMap model, @RequestParam("matr") String matr, @RequestParam("pass") String pass) {
        if (validate(matr) && validate(pass)) {
            Dipendente dip = service.findDipendenteById(matr);
            if (dip == null) {
                model.addAttribute("ErrMsg", "Error : username doesn't exist");
                return "login";
            } else if (dip.getPassword().equals(pass)) {
                switch (dip.getRuolo()) {
                

                }
                return "index";
            } else {
                model.addAttribute("ErrMsg", "Error : wrong password");
            }
        } else {
            model.addAttribute("ErrMsg", "Error : only alphanumeric characters and _ are allowed");
        }
        return "login";

    }

    manager ,
            operatore,
            controlloreQ,
            responsabileQ

    private boolean validate(String input) {
        String regex = "[a-zA-Z0-9]\\w*";
        return input.matches(regex);
    }

}
