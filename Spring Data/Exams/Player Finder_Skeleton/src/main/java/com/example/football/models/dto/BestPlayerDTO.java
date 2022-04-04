package com.example.football.models.dto;

import com.example.football.models.enums.Position;

public class BestPlayerDTO {
    private String firstName;
    private String lastName;
    private Position Position;
    private String teamName;
    private String stadiumName;

    public BestPlayerDTO(String firstName, String lastName, com.example.football.models.enums.Position position, String teamName, String stadiumName) {
        this.firstName = firstName;
        this.lastName = lastName;
        Position = position;
        this.teamName = teamName;
        this.stadiumName = stadiumName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Position getPosition() {
        return Position;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getStadiumName() {
        return stadiumName;
    }
}
