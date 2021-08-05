package com.example.doctify.Models;

public class EmpModelTwo {

    int image;
    String drName,drSpec,place,time,year;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

//    public String getDrName() {
//        return drName;
//    }
//
//    public void setDrName(String drName) {
//        this.drName = drName;
//    }

    public String getDrSpec() {
        return drSpec;
    }

    public void setDrSpec(String drSpec) {
        this.drSpec = drSpec;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

//    public String getRating() {
//        return rating;
//    }
//
//    public void setRating(String rating) {
//        this.rating = rating;
//    }

    public EmpModelTwo(int image, String drName, String drSpec, String place, String time, String year, String rating) {
        this.image = image;
//        this.drName = drName;
        this.drSpec = drSpec;
        this.place = place;
        this.time = time;
        this.year = year;
//        this.rating = rating;



    }
}
