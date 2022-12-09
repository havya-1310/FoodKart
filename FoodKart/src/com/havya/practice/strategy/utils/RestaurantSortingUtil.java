package com.havya.practice.strategy.utils;

import com.havya.practice.models.Restaurant;
import com.havya.practice.models.User;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSortingUtil {
    public static List<Restaurant> getApplicableRestaurants(List<Restaurant> restaurants, User user) {
        String pinCode = user.getPinCode();
        List<Restaurant> applicableRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getServingPinCodes().contains(pinCode) && restaurant.isEnoughQty()) {
                applicableRestaurants.add(restaurant);
            }
        }
        return applicableRestaurants;
    }
}
