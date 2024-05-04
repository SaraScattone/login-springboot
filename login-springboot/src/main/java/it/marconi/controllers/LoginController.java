package it.marconi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.marconi.services.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    @GetMapping("/utente")
    public ModelAndView nuovoUtente(@RequestParam("type") String type) {

        ModelAndView modelAndView = new ModelAndView();

        if(type.equals("new")) {
            modelAndView.setViewName("registrazione");
        }
        else if(type.equals("login")) {
            modelAndView.setViewName("accesso");
        }

        return modelAndView;
    }
}