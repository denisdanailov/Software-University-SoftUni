package com.example.productshopxml.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private Integer age;

    @OneToMany(mappedBy = "buyerId")
    private List<Product> boughtItems;

    @OneToMany(mappedBy = "sellerId")
    private List<Product> sellingItems;

    @ManyToMany
    @JoinTable(name = "users_friends",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;

    public User() {
        this.boughtItems = new ArrayList<>();
        this.sellingItems = new ArrayList<>();
        this.friends = new HashSet<>();
    }

    public User(String firstName, String lastName, int age) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Product> getBoughtItems() {
        return Collections.unmodifiableList(boughtItems);
    }

    public void setBoughtItems(List<Product> boughtItems) {
        this.boughtItems = boughtItems;
    }

    public List<Product> getSellingItems() {
        return Collections.unmodifiableList(sellingItems);
    }

    public void setSellingItems(List<Product> sellingItems) {
        this.sellingItems = sellingItems;
    }

    public Set<User> getFriends() {
        return Collections.unmodifiableSet(friends);
    }

    public void addFriends(User user) {
        this.friends.add(user);
    }

}
