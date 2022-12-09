package com.havya.practice.strategy;

import com.havya.practice.models.Restaurant;
import com.havya.practice.models.User;

import java.util.List;

public interface RestaurantSortingStrategy {
    List<Restaurant> getRestaurants(List<Restaurant> restaurants, User user);
}
