package com.hacktues.persistence.repo;

import com.hacktues.persistence.model.Entity;
import org.springframework.data.repository.CrudRepository;

public interface Repo extends CrudRepository <Entity, Integer> {
    Entity findByUsername(String name);
}
