package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    @Column(unique = true,nullable = false)
    private String name;

    @Column(nullable = false)
    private int population;

    @Column(name = "travel_guide", columnDefinition = "text", nullable = false)
    private String travelGuide;

    @OneToMany(targetEntity = Team.class ,mappedBy = "town")
    private Set<Team> teams;

    @OneToMany(targetEntity = Player.class,mappedBy = "town")
    private Set<Player> players;

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", name, population);
    }
}
