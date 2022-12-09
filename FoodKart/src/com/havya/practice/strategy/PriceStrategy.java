package com.havya.practice.strategy;


import com.havya.practice.models.Restaurant;
import com.havya.practice.models.User;
import com.havya.practice.strategy.utils.RestaurantSortingUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriceStrategy implements RestaurantSortingStrategy {

    @Override
    public List<Restaurant> getRestaurants(List<Restaurant> restaurants, User user) {
        List<Restaurant> applicableRestaurants = RestaurantSortingUtil.getApplicableRestaurants(restaurants, user);
        Collections.sort(applicableRestaurants, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant r1, Restaurant r2) {
                return Integer.compare(r1.getFoodItem().getPrice(), r2.getFoodItem().getPrice());
            }
        });
        return applicableRestaurants;
    }
}
