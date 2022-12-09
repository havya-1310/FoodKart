package com.havya.practice;

import com.havya.practice.enums.Gender;
import com.havya.practice.enums.SortingStrategy;
import com.havya.practice.models.Restaurant;
import com.havya.practice.service.RestaurantService;
import com.havya.practice.service.UserService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        UserService userService = new UserService();
        userService.registerUser("Pralove", Gender.MALE, "phoneNumber-1", "HSR");
        userService.registerUser("Nitesh", Gender.MALE, "phoneNumber-2", "BTM");
        userService.registerUser("Vatsal", Gender.FEMALE, "phoneNumber-3", "BTM");
        userService.loginUser("phoneNumber-1");
        System.out.println(userService.getLoggedInUser());
        RestaurantService restaurantService = new RestaurantService();
        System.out.println(userService.getLoggedInUser());
        restaurantService.registerRestaurant("first rest", Arrays.asList("BTM"), "Panipuri", 100, 10);
        restaurantService.registerRestaurant("second rest", Arrays.asList("BTM"), "Dhokla", 20, 5);
        restaurantService.registerRestaurant("third rest", Arrays.asList("ASR"), "Handvo", 20, 15);
        userService.loginUser("phoneNumber-2");
        List<Restaurant> list = restaurantService.getSortedRestaurants(SortingStrategy.PRICE);
        for (Restaurant restaurant : list) {
            System.out.println(restaurant.getName() + " " + restaurant.getFoodItem().getPrice() + " " + restaurant.getAvgRating());
        }
        if (restaurantService.placeOrder("first rest", 100)) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }

        if (restaurantService.placeOrder("first rest", 1)) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
        restaurantService.rateRestaurant("first rest", 1, "good");
        restaurantService.rateRestaurant("first rest", 5, "best");

        System.out.println("--------------------------------");
        list = restaurantService.getSortedRestaurants(SortingStrategy.RATING);
        for (Restaurant restaurant : list) {
            System.out.println(restaurant.getName() + " " + restaurant.getFoodItem().getPrice() + " " + restaurant.getAvgRating());
        }

    }
}