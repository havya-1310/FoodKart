package com.havya.practice.models;

import java.util.ArrayList;
import java.util.List;

public class Rating {
    List<String> comments;
    List<Integer> ratings;
    private int sumOfRatings;

    public Rating() {
        this.comments = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.sumOfRatings = 0;
    }

    public void addRating(String comment, int rating) {
        this.comments.add(comment);
        this.ratings.add(rating);
        sumOfRatings += rating;
    }

    public List<String> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "comments=" + comments +
                ", ratings=" + ratings +
                ", sumOfRatings=" + sumOfRatings +
                '}';
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public int getSumOfRatings() {
        return sumOfRatings;
    }
}
