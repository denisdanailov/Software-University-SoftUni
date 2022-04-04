package dto;

import com.google.gson.annotations.Expose;

import java.util.List;

public class PersonDTO {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private int age;

    @Expose
    private boolean isMarried;

    @Expose
    private double height;

    @Expose
    private WifeDTO wife;

    @Expose
    private List<KidsDTO> kids;

    @Expose
    private DogDTO dog;

    public PersonDTO(String firstName, String lastName, int age, boolean isMarried, double height, WifeDTO wife, List<KidsDTO> kids, DogDTO dog) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
        this.height = height;
        this.wife = wife;
        this.kids = kids;
        this.dog = dog;
    }
}
