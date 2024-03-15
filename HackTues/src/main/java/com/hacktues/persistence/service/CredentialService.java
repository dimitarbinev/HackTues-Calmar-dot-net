package com.hacktues.persistence.service;

import com.hacktues.controller.model.Credential;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

public interface CredentialService {
    ModelAndView showPage();

    HttpStatus login(Credential credentials);

    HttpStatus register(Credential credentials);

    HttpStatus updateData(Credential credential);
}
