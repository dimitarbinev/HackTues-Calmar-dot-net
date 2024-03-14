package com.hacktues.persistence.service;

import com.hacktues.persistence.model.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

public interface Service {
    ModelAndView showPage();

    HttpStatus login(Entity credentials);

    void register(Entity credentials);
}
