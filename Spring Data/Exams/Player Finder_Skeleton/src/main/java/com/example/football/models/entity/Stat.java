package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "stats")
public class Stat extends BaseEntity{

    @Column(nullable = false)
    private double passing;

    @Column(nullable = false)
    private double shooting;

    @Column(nullable = false)
    private double endurance;

    @OneToOne(targetEntity = Player.class,mappedBy = "stats")
    private Player player;

    public double getPassing() {
        return passing;
    }

    public void setPassing(double passing) {
        this.passing = passing;
    }

    public double getShooting() {
        return shooting;
    }

    public void setShooting(double shooting) {
        this.shooting = shooting;
    }

    public double getEndurance() {
        return endurance;
    }

    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    @Override
    public String toString() {
        return String.format("%.2f - %.2f - %.2f", passing, shooting, endurance);
    }
}
