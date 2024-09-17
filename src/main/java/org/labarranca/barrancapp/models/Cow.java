package org.labarranca.barrancapp.models;

public class Cow {
    private int cowId;
    private String earTag;
    private String breed;
    private String sex;
    private double weight;
    private String birthdate;

    public Cow(int cowId, String earTag, String breed, String sex, double weight, String birthdate) {
        this.cowId = cowId;
        this.earTag = earTag;
        this.breed = breed;
        this.sex = sex;
        this.weight = weight;
        this.birthdate = birthdate;
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
        this.weight = weight;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
