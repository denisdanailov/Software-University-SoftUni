package com.example.football.models.entity;

import com.example.football.models.enums.Position;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "players")
public class Player extends BaseEntity{

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id", nullable = false)
    private Town town;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    private Team team;

    @OneToOne
    @JoinColumn(name = "stat_id", referencedColumnName = "id", nullable = false)
    private Stat stats;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setStats(Stat stats) {
        this.stats = stats;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public Town getTown() {
        return town;
    }

    public Team getTeam() {
        return team;
    }

    public Stat getStats() {
        return stats;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", firstName, lastName, position.toString());
    }
}
