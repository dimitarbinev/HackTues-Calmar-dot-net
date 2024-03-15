package com.hacktues.persistence.repo;

import com.hacktues.controller.model.Team;
import com.hacktues.persistence.model.CredentialEntity;
import com.hacktues.persistence.model.TeamEntity;
import org.springframework.data.repository.CrudRepository;

public interface Repo extends CrudRepository <CredentialEntity, Integer> {
    boolean existsByUsername(String username);
    boolean existsByPassword(String password);
    CredentialEntity findByUsername(String username);
    TeamEntity findByTeam_name(String team_name);
}
