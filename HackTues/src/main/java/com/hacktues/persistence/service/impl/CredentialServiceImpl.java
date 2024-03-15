package com.hacktues.persistence.service.impl;

import com.hacktues.controller.model.Credential;
import com.hacktues.persistence.model.CredentialEntity;
import com.hacktues.persistence.repo.Repo;
import com.hacktues.persistence.service.CredentialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Service
public class CredentialServiceImpl implements CredentialService {

    @Autowired
    private Repo repo;

    @Override
    public ModelAndView showPage() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @Override
    public HttpStatus login(Credential credential) {
        if (repo.existsByUsername(credential.getUsername()) &&
                repo.existsByPassword(credential.getPassword())) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    @Override
    public HttpStatus register(Credential credential) {
        if (repo.existsByUsername(credential.getUsername())) {
            return HttpStatus.BAD_REQUEST;
        } else {
            CredentialEntity credentialEntity =
                    new CredentialEntity(credential.getUsername(), credential.getPassword());
            repo.save(credentialEntity);
            return HttpStatus.OK;
        }
    }
}
