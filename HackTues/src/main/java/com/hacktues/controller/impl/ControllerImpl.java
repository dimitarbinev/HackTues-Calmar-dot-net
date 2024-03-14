package com.hacktues.controller.impl;

import com.hacktues.controller.model.Credential;
import com.hacktues.controller.Controller;
import com.hacktues.persistence.service.impl.CredentialCredentialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/hacktues")
public class ControllerImpl implements Controller {
    @Autowired
    private CredentialCredentialServiceImpl service;
    @Override
    public ModelAndView showMainPage() {
        return service.showPage();
    }

    @Override
    public ModelAndView showLogin() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @Override
    public ModelAndView showSignup() {
        ModelAndView mav = new ModelAndView("signUp");
        return mav;
    }

    @Override
    public HttpStatus login(Credential credentials) {
        return service.login(credentials);
    }

    @Override
    public void register(@RequestBody Credential credentials) {
        service.register(credentials);
    }


}
