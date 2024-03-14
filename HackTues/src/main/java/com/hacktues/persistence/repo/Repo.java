package com.hacktues.persistence.repo;

import com.hacktues.persistence.model.Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface Repo extends CrudRepository <Entity, Integer> {
    List<Entity> findByUsername(String username);
}
