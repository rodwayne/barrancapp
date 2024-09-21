package org.labarranca.barrancapp.models;

import java.time.LocalDate;

public class Cow {
    private int cowId;
    private String earTag;
    private String breed;
    private String sex;
    private double weight;
    private LocalDate birthdate;

    public Cow(int cowId, String earTag, String breed, String sex, double weight, LocalDate birthdate) {
        this.cowId = cowId;
        this.earTag = earTag;
        this.breed = breed;
        this.sex = sex;
        this.weight = weight;
        this.birthdate = birthdate;
    }

    public Cow() {

    }

    public int getCowId() {
        return cowId;
    }

    public void setCowId(int cowId) {
        this.cowId = cowId;
    }

    public String getEarTag() {
        return earTag;
    }

    public void setEarTag(String earTag) {
        this.earTag = earTag;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }

        this.weight = weight;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
