package dto;

import com.google.gson.annotations.Expose;

public class DogDTO {
    @Expose
    private String name;

    @Expose
    private int age;

    @Expose
    private double weight;

    public DogDTO(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}
