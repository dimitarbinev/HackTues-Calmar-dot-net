package com.hacktues.controller;

import com.hacktues.controller.model.Credential;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

public interface Controller {

    @RequestMapping
    @ResponseStatus(HttpStatus.OK)
    ModelAndView showMainPage();

    @RequestMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    ModelAndView showLogin();

    @RequestMapping(value = "/signup")
    @ResponseStatus(HttpStatus.OK)
    ModelAndView showSignup();

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    HttpStatus login(@RequestBody Credential credentials);

    @RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    void register(Credential credentials);
}
