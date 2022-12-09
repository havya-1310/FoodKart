package com.havya.practice.service;

import com.havya.practice.models.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantDao {

    private static RestaurantDao restaurantDaoInstance;

    int id;
    Map<String, Restaurant> currentRestaurants = new HashMap<>();

    public RestaurantDao() {
        currentRestaurants = new HashMap<>();
        id = 0;
    }

    public static RestaurantDao getRestaurantDaoInstance() {
        if (restaurantDaoInstance == null) {
            restaurantDaoInstance = new RestaurantDao();
        }
        return restaurantDaoInstance;
    }

    public Restaurant getRestaurant(String name) throws Exception {
        if (!currentRestaurants.containsKey(name)) {
            throw new Exception("Restaurant not present!!");
        }
        return currentRestaurants.get(name);
    }

    public void addRestaurant(Restaurant restaurant) {
        id += 1;
        restaurant.setId(id);
        currentRestaurants.put(restaurant.getName(), restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(currentRestaurants.values());
    }


}
