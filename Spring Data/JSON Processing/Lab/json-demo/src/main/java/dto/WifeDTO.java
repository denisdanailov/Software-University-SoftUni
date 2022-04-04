package dto;

import com.google.gson.annotations.Expose;

public class WifeDTO {

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

    public WifeDTO(String firstName, String lastName, int age, boolean isMarried, double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
        this.height = height;
    }
}
