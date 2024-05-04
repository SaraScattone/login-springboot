package it.marconi.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.marconi.domains.Login;
import it.marconi.domains.LoginForm;
import it.marconi.services.LoginService;
import jakarta.validation.Valid;

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

    @PostMapping("/utente")
    public ModelAndView visualizzaUtente(@ModelAttribute @Valid LoginForm loginForm,
    BindingResult br) {

        // verifico la presenza di errori di validazione, e ricarico la pagina
        if (br.hasErrors())
            return new ModelAndView("contact-form");

        Login login = loginService.save(loginForm);

        // applico pattern PRG (Post Redirect Get)
        return new ModelAndView("redirect:/utente?id=" + login.getId()); 
    }

    /*@GetMapping(params = "id")
    public ModelAndView mostraUtente(@RequestParam("id") UUID loginId) {

        Optional<Login> opLogin = loginService.get(loginId);
    }*/
}