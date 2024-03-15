package com.hacktues.controller.impl;

import com.hacktues.controller.CredentialController;
import com.hacktues.controller.model.Credential;
import com.hacktues.persistence.model.CredentialEntity;
import com.hacktues.persistence.service.impl.CredentialServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/hacktues")
public class ControllerImpl implements CredentialController {
    @Autowired
    private CredentialServiceImpl service;
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
    public HttpStatus login(HttpSession session, Credential credentials) {
        //String username = (String)session.getAttribute("username");
        HttpStatus result = service.login(credentials);
        if (result == HttpStatus.OK) {
            session.setAttribute("username", credentials.getUsername());
        }
        return result;
    }

    @Override
    public HttpStatus register(@RequestBody Credential credentials) {
        try {
            service.register(credentials);
        } catch (DataIntegrityViolationException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updateData(Credential credential) {
        service.updateData(credential);
        return HttpStatus.OK;
    }


}
