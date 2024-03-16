package com.hacktues.persistence.repo;

import com.hacktues.persistence.model.CredentialEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repo extends CrudRepository <CredentialEntity, Integer> {
    boolean existsByUsername(String username);
    boolean existsByPassword(String password);
    CredentialEntity findByUsername(String username);
    List<CredentialEntity> findByBrawlStars(boolean brawl_stars);
    List<CredentialEntity> findByValorant(boolean valorant);
    List<CredentialEntity> findByLeague_of_legends(boolean league_of_legends);
    List<CredentialEntity> findByRocket_league(boolean rocket_league);
}
