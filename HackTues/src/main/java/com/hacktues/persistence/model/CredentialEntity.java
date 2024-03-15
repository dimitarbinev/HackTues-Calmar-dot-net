package com.hacktues.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Table(name = "users")
@Entity
public class CredentialEntity {

    public CredentialEntity() {
        this.username = "";
        this.password = "";
        this.valorant = false;
        this.league_of_legends = false;
        this.rocket_league = false;
        this.brawl_stars = false;
        this.discord = "";
        this.about_me = "";
    }

    public CredentialEntity(String username, String password) {
        this.username = username;
        this.password = password;
        this.valorant = false;
        this.league_of_legends = false;
        this.rocket_league = false;
        this.brawl_stars = false;
        this.discord = "";
        this.about_me = "";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column (nullable = false)
    private boolean valorant;

    @Column (nullable = false)
    private boolean league_of_legends;

    @Column (nullable = false)
    private boolean rocket_league;

    @Column (nullable = false)
    private boolean brawl_stars;

    @Column (nullable = false)
    private String discord;

    @Column (nullable = false)
    private String about_me;
}
