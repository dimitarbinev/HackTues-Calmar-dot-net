package com.hacktues.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Team {
    private int id;
    private String  team_name;
    private String owner_username;
    private int player_count;
    private String about_team;
}
