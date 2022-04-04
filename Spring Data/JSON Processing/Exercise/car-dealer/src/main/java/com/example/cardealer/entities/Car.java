package com.example.cardealer.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity{

    private String make;

    private String model;

    @Column(name = "travel_distance")
    private double travelledDistance;

    @OneToOne(mappedBy = "car")
    private Sale sale;

    @ManyToMany
    @JoinTable(name = "parts_cars",
        joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"))
    private Set<Part> parts;

}
