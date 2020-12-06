package com.internshipHomework.libraryApi.model;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String fullName;
    private double averageRating;
    private ArrayList<Double> ratings = new ArrayList<>();

    public Author(String fullName, double averageRating) {
        this.fullName = fullName;
        this.averageRating = averageRating;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Double> getRatings() {
        return ratings;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void calculateAverageRating(){
        double sum = 0;
        for(Double rating : ratings)
            sum += rating;
        averageRating = sum/ratings.size();
    }

    public void addRating(double rating){
        ratings.add(rating);
    }
}
