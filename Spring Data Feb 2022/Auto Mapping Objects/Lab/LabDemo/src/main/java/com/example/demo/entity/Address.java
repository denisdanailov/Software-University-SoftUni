package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    private String street;

    private int number;

    @OneToMany(mappedBy = "address")
    private Set<Employee> employees;

    public Address() {
    }

    public Address(String city, String street, int number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }
}
