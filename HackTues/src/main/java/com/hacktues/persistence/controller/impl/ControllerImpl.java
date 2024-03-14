package com.hacktues.persistence.controller.impl;

import com.hacktues.persistence.controller.Controller;
import com.hacktues.persistence.model.Entity;
import com.hacktues.persistence.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequestMapping("/api/hacktues")
public class ControllerImpl implements Controller {
    @Autowired
    private ServiceImpl service;
    @Override
    public ModelAndView showPage() {
        return service.showPage();
    }

    @Override
    public HttpStatus login(Entity credentials) {
        return service.login(credentials);
    }

    @Override
    public void register(Entity credentials) {
        service.register(credentials);
    }


}
