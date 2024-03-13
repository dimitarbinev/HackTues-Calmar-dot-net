package com.hacktues.persistence.repo;

import com.hacktues.persistence.model.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestTableRepo extends CrudRepository <TestEntity, Integer> {
    TestEntity findByName(String name);
}
