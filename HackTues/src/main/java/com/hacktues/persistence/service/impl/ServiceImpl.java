package com.hacktues.persistence.service.impl;

import com.hacktues.persistence.model.Entity;
import com.hacktues.persistence.repo.Repo;
import com.hacktues.persistence.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    private Repo repo;

    @Override
    public ModelAndView showPage() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @Override
    public HttpStatus login(Entity credentials) {
        Entity row = repo.findByUsername(credentials.getUsername()).get(0);
        if (row != credentials) {
            return HttpStatus.BAD_REQUEST;
        } else {
            return HttpStatus.OK;
        }
    }

    @Override
    public void register(Entity credentials) {
        repo.save(credentials);
    }
}
