package com.example.football.models.dto.json;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CreateTownDTO {

    @Size(min = 2)
    private String name;

    @Positive
    private int population;

    @Size(min = 10)
    private String travelGuide;

//    public boolean validate() {
//        if (name.length() < 2 || population < 1 || travelGuide.length() < 10) {
//            return false;
//        }
//
//        return true;
//    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getTravelGuide() {
        return travelGuide;
    }
}
