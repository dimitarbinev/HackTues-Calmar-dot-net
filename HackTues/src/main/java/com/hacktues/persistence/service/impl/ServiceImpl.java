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
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @Override
    public HttpStatus login(Entity credentials) {
        if (repo.existsByUsername(credentials.getUsername()) && repo.existsByPasswordHash(credentials.getPasswordHash())) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    @Override
    public void register(Entity credentials) {
        repo.save(credentials);
    }
}
