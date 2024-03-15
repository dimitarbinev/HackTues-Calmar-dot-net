package com.hacktues.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "team")
@Entity
public class TeamEntity {

    public TeamEntity( String team_name, String owner_username, int player_count, String about_team) {
        this.team_name = team_name;
        this.owner_username = owner_username;
        this.player_count = player_count;
        this.about_team = about_team;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    private String  team_name;

    @Column(nullable = false, unique = true)
    private String owner_username;

    @Column(nullable = false)
    private int player_count;

    @Column(nullable = false)
    private String about_team;
}
