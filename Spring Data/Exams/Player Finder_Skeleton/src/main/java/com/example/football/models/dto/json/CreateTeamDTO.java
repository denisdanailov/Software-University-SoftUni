package com.example.football.models.dto.json;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class CreateTeamDTO {
    @Size(min = 3)
    private String name;
    @Size(min = 3)
    private String stadiumName;
    @Min(value = 1000)
    private int fanBase;
    @Size(min = 10)
    private String history;
    private String townName;

//    public boolean validate(){
//
//        if(name.length() < 3 || stadiumName.length() < 3 ||
//                fanBase < 1000 || history.length() < 10) {
//            return false;
//        }
//
//        return true;
//    }

    public String getName() {
        return name;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public int getFanBase() {
        return fanBase;
    }

    public String getHistory() {
        return history;
    }

    public String getTownName() {
        return townName;
    }

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

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
