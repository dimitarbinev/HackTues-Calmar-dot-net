package com.hacktues.controller;

import com.hacktues.controller.model.Credential;
import com.hacktues.persistence.model.CredentialEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

public interface CredentialController {

    @RequestMapping
    @ResponseStatus(HttpStatus.OK)
    ModelAndView showMainPage();


    @RequestMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    ModelAndView showLogin();

    @RequestMapping(value = "/signup")
    @ResponseStatus(HttpStatus.OK)
    ModelAndView showSignup();

    @RequestMapping(value = "/frontpage")
    @ResponseStatus(HttpStatus.OK)
    ModelAndView showFrontpage();

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    HttpStatus login(HttpSession session, @RequestBody Credential credentials);

    @RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    HttpStatus register(HttpSession session, @RequestBody Credential credentials);

    @RequestMapping(value = "/updatedata", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    HttpStatus updateData(HttpSession session, @RequestBody Credential credential);

}
