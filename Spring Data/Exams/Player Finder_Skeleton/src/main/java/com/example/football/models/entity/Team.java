package com.example.football.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "stadium_name", nullable = false)
    private String stadiumName;

    @Column(name = "fan_base", nullable = false)
    private int fanBase;

    @Column(columnDefinition = "text", nullable = false)
    private String history;

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id",nullable = false)
    private Town town;

    @OneToMany(targetEntity = Player.class,mappedBy = "team")
    private Set<Player> players;


    public void setName(String name) {
        this.name = name;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public void setFanBase(int fanBase) {
        this.fanBase = fanBase;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getFanBase() {
        return fanBase;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public String getHistory() {
        return history;
    }

    public Town getTown() {
        return town;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", name, fanBase);
    }
}
