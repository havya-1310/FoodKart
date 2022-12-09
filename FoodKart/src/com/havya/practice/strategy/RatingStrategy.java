package com.havya.practice.strategy;

import com.havya.practice.models.Restaurant;
import com.havya.practice.models.User;
import com.havya.practice.strategy.utils.RestaurantSortingUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RatingStrategy implements RestaurantSortingStrategy {
    @Override
    public List<Restaurant> getRestaurants(List<Restaurant> restaurants, User user) {
        List<Restaurant> applicableRestaurants = RestaurantSortingUtil.getApplicableRestaurants(restaurants, user);
        Collections.sort(applicableRestaurants, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant r1, Restaurant r2) {
                return Double.compare(r1.getAvgRating(), r2.getAvgRating());
            }
        });
        return restaurants;
    }
}
