package com.havya.practice.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    String name;
    int id;
    List<String> servingPinCodes = new ArrayList<>();
    FoodItem foodItem;
    Rating rating;

    User owner;

    public Restaurant(String name, List<String> servingPinCodes, FoodItem foodItem, Rating rating, User owner) {
        this.name = name;
        this.servingPinCodes = servingPinCodes;
        this.foodItem = foodItem;
        this.rating = rating;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getServingPinCodes() {
        return servingPinCodes;
    }

    public void setServingPinCodes(List<String> servingPinCodes) {
        this.servingPinCodes = servingPinCodes;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public double getAvgRating() {
        if (rating.getSumOfRatings() == 0 || rating.getRatings() == null || rating.getRatings().size() == 0) {
            return 0d;
        }
        return rating.getSumOfRatings() * 1.0d / rating.getRatings().size();
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public boolean isEnoughQty() {
        return this.getFoodItem().getQuantity() > 0;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", servingPinCodes=" + servingPinCodes +
                ", foodItem=" + foodItem +
                ", rating=" + rating +
                ", owner=" + owner +
                '}';
    }
}
