package com.hacktues.persistence.service.impl;

import com.hacktues.controller.model.Credential;
import com.hacktues.controller.model.Team;
import com.hacktues.persistence.model.CredentialEntity;
import com.hacktues.persistence.model.TeamEntity;
import com.hacktues.persistence.repo.Repo;
import com.hacktues.persistence.service.CredentialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        CredentialEntity entity = repo.findByUsername(credential.getUsername());
        if (entity == null) {
            return HttpStatus.NOT_FOUND;
        }
        String password = hashPassword(credential.getPassword());
        if (!entity.getPassword().equals(password)) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus register(Credential credential) {
        if (repo.existsByUsername(credential.getUsername())) {
            return HttpStatus.BAD_REQUEST;
        } else {
            String password = hashPassword(credential.getPassword());
            CredentialEntity credentialEntity =
                    new CredentialEntity(credential.getUsername(), password);
            repo.save(credentialEntity);
            return HttpStatus.OK;
        }
    }

    @Override
    public HttpStatus updateData(Credential credential) {
        CredentialEntity entity = repo.findByUsername(credential.getUsername());
        entity.setValorant(credential.isValorant());
        entity.setLeague_of_legends(credential.isLeague_of_legends());
        entity.setRocket_league(credential.isRocket_league());
        entity.setBrawl_stars(credential.isBrawl_stars());
        entity.setDiscord(credential.getDiscord());
        entity.setAbout_me(credential.getAbout_me());
        repo.save(entity);
        return HttpStatus.OK;
    }

    @Override
    public String getTags(String username) {
        CredentialEntity entity = repo.findByUsername(username);
        String json = String.format(
                "{\"valorant\": %s," +
                " \"league_of_legends\": %s," +
                " \"rocket_league\": %s," +
                " \"brawl_stars\": %s}",
                entity.isValorant(),
                entity.isLeague_of_legends(),
                entity.isRocket_league(),
                entity.isBrawl_stars());
        return json;
    }


    private static String hashPassword(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
