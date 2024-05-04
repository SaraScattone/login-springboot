package it.marconi.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.marconi.domains.Login;
import it.marconi.domains.LoginForm;
import it.marconi.repositories.LoginRepository;

@Service
public class LoginService {
    
    @Autowired
    private LoginRepository loginRepo;

    public Login save(LoginForm loginForm) {

        Login l = mapLogin(loginForm);
        return loginRepo.save(l);
    }

    private Login mapLogin(LoginForm loginForm) {

        Login l = new Login();
        l.setNickname(loginForm.getNickname());
        l.setEmail(loginForm.getEmail());
        l.setPassword(loginForm.getPassword());

        return l;
    }

    /*public Optional<Login> get(UUID loginId) {
        return loginRepo.findById(loginId);
    }*/
}
