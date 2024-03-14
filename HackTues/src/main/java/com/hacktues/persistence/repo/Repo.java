package com.hacktues.persistence.repo;

import com.hacktues.persistence.model.CredentialEntity;
import org.springframework.data.repository.CrudRepository;

public interface Repo extends CrudRepository <CredentialEntity, Integer> {
    boolean existsByUsername(String username);
    boolean existsByPassword(String password);
}
